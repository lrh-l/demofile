package com.example.demofile.com.demo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @RequestMapping(value = "/user/index")
    public String index(){
        System.out.println("----------------");
        return "hello";
    }
}
