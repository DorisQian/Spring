package com.doris.controller;

import com.doris.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    //读取yml
    //${user[0].name} map
    @Value("${server.port}")
    public String port;

    //将所有数据封装成一个对象
    private Environment env;

    @Autowired
    public void EnvironmentImpl(Environment env){
        this.env = env;
    }

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("first spring boot");
        System.out.println(port);
        System.out.println(env.getProperty("baseDir"));
        System.out.println(myDataSource);
        return "spring boot start";
    }
}
