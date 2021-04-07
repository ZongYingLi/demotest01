package com.example02.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
//        访问http://localhost:8080/main.html也可以进入index.html页面
        registry.addViewController("/main.html").setViewName("index");
    }

//    配置拦截器,可以添加过滤所有请求，并且可以排除一些请求(一些指定页面，以及静态资源)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login","/css/*","/js/**","/fonts/**","/img/**","/vendor/**");

    }
}
