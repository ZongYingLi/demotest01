package com.example02.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

//当点击login按钮时就在login.html中提交请求，请求就到LoginController中来
@Controller
public class LoginController {
    @RequestMapping("/user/login")
//    先用 @ResponseBody和 return "ok" 用来检测代码是否可以跑进来，
//    成功的话浏览器访问http://localhost:8080/login.html点击登录，会出现ok
    //   回显数据用model
//    @ResponseBody
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
//        具体的业务：判断用户名密码是否正确
//        如果账号不为空并且密码为123456就允许登录成功
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
//         登录成功，重定向到main.html页面
//         一旦登录成功，session里面就存有loginUser，然后使它等于username
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
//        告诉用户登录失败，用model传值
        else {
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }
    }
}
