package com.example02.demo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//首页
//首页配置注意：所有页面的静态资源都需要用thymeleaf来接管;@{}
@SpringBootApplication
@Controller
public class IndexController {
    //浏览器输入http://localhost:8080/login.html可以访问到template下的login.html
    @RequestMapping({"/","/login.html"})
    public String index(){
        return "login";
    }
}
