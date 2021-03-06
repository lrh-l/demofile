package com.example.demofile.com.demo.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demofile.com.demo.test.service.FileService;
import com.example.demofile.com.demo.test.utlis.FtpFileUtis;
import com.example.demofile.com.demo.test.utlis.ServerResponse;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {
    private final static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public ServerResponse upload(Part file) {
        Map<String, String> resultMap = new HashMap();
        String oldName = file.getSubmittedFileName();
        String newName = UUID.randomUUID().toString();
        //给文件重命名
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        try {
            //利用FtpUtil中到方法进行上传文件
            boolean result = FtpFileUtis.uploadFile("/home/liurenhua", newName, file.getInputStream());
            if (result) {
                //如果上传成功，则返回前端新的文件名和路径
                resultMap.put("uri", newName);
                //根据nginx配置的ftp文件夹和域名的对应关系组装文件在ftp服务器中的位置
                resultMap.put("url", "http://" + FtpFileUtis.FTP_IP+":8080"+"/img/" + newName);
                logger.info("图片路径为"+ JSONObject.toJSON(resultMap.get("url")).toString());
                logger.info("响应为"+JSONObject.toJSON(ServerResponse.createBySucess("上传成功！",resultMap)).toString());
                return ServerResponse.createBySucess("上传成功！",resultMap);
            } else {
                return ServerResponse.createByErrorMessage("上传失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ServerResponse.createByErrorMessage("上传失败");
    }

    public static void main(String[] args) throws Exception{
        FileServiceImpl fileService = new FileServiceImpl();
        File file = new File("E:\\img\\20170813194034_UaKdW.jpeg");
        InputStream is = new FileInputStream(file);
       // fileService.upload()
    }
}
