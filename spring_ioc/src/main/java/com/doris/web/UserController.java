package com.doris.web;

import com.doris.service.UserService;
import com.doris.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();
//        依赖注入
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("/Users/doris/study/java/Spring/spring_ioc/src/main/resources/applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
//        配置文件UserService只存在一个bean可以用该方式
//        UserService userService1 = app.getBean(UserService.class);
        userService.save();
    }
}
