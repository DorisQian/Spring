package com.doris.controller;

import com.doris.domain.Account;
import com.doris.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/save", produces = "text/html;charset=utf-8")
    public String save(Account account){
        try {
            accountService.save(account);
            return "保存成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "失败";
    }

    @ResponseBody
    @RequestMapping(value = "/findAll")
    public ModelAndView findAll(){
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
