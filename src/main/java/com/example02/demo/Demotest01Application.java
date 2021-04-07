package com.example02.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@springBootApplication=（默认属性）@Configuration+@EnableAutoConfiguration+@ComponentScan

//@Configuration：和@Bean配合使用，就可以创建一个简单的spring配置类，可以用来替代相应的xml配置文件
//@Configuration的注解类表示这个类可以使用Spring Ioc容器作为bean定义的来源
//@Bean注解告诉spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册在Spring应用程序上下文中的bean

//@EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置

//@ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成为bean，当然包括@Component下的子注解@Service,@Repository,@Controller

//程度的主入口，不能删也不能改
@SpringBootApplication
public class Demotest01Application {

    public static void main(String[] args) {
        SpringApplication.run(Demotest01Application.class, args);
    }

}
