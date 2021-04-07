package com.example02.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//添加拦截器，只有登录成功才可进入main.html，拦截器写好之后要添加到bean里面注册
public class LoginHandlerInterceptor implements HandlerInterceptor {
//    快捷方式：右键-->Generate-->override

//    return true 就是放行，return false 就是不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登录成功之后，应该有用户的session
//        如果loginUser存在，则说明登录了
        Object loginUser=request.getSession().getAttribute("loginUser");
//        如果loginUser为空，则说明没有登录
        if(loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        else
            return true;
    }
}
