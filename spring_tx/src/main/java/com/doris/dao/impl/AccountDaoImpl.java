package com.doris.dao.impl;

import com.doris.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate template;

    public void out(String outMan, double money) {
        template.update("update account set money=money-? where name=?", money, outMan);
    }

    public void in(String inMan, double money) {
        template.update("update account set money=money+? where name=?", money, inMan);
    }
}
