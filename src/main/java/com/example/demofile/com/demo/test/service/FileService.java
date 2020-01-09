package com.example.demofile.com.demo.test.service;

import com.example.demofile.com.demo.test.utlis.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;

public interface FileService {
    public ServerResponse upload(Part file);
}
