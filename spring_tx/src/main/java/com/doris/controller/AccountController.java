package com.doris.controller;

import com.doris.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

//        @Autowired
//        private AccountService accountService;
//
//        public void transfer(){
//                accountService.transfer("tom", "lucy", 500);
//        }
        public static void main(String[] args) {
                ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
                AccountService service = app.getBean(AccountService.class);
                service.transfer("tom", "lucy", 500);
        }


}
