package com.doris.controller;

import com.doris.exception.DemoService;
import com.doris.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class DemoException {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show run");
        demoService.show1();
        return "/login.jsp";
    }
}
