package com.example.demofile.com.demo.test;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test {

    /*private String brfore_image_path = "D:\\01.jpg";
    private String after_image_path = "D:\\temp";

    public void get_image(){
        int begin = brfore_image_path.lastIndexOf("\\");
        int end = brfore_image_path.lastIndexOf(".");
        String image_name = brfore_image_path.substring(begin+1,end);

        File in_file = new File(brfore_image_path);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(in_file);
        }catch(Exception e) {
            e.printStackTrace();
        }
        int in_width  = bi.getWidth();
        int in_height = bi.getHeight();
        int in_minx   = bi.getMinX();
        int in_miny   = bi.getMinY();
        int type = bi.getType();
        int out_width = in_width;
        int out_height = in_height;
        int multiple = 1;

        //具体的值可调
        while(out_width * out_height > 1000000){
            out_width = out_width/2;
            out_height = out_height/2;
            multiple = multiple * 2;
        }
        BufferedImage out_image_martrix = new BufferedImage(out_width, out_height, type);
        for(int i=0;i<out_width;i++) {
            for(int j =0;j<out_height;j++) {
                int pixel =bi.getRGB(i*multiple+in_minx, j*multiple+in_miny);
                out_image_martrix.setRGB(i, j, pixel);
            }
        }
        try{
            after_image_path = after_image_path + image_name + ".jpg";
            ImageIO.write(out_image_martrix,"jpg", new File(new_path));
            bi = null;
            out_image_martrix = null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //测试代码
    public static void main(String[] args) {
        new CompressImage().get_image();
    }*/
}
