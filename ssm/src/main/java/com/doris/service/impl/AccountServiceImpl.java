package com.doris.service.impl;

import com.doris.domain.Account;
import com.doris.mapper.AccountMapper;
import com.doris.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
            accountMapper.save(account);

    }

    public List<Account> findAll() {
        List<Account> accountList = accountMapper.findAll();
        return accountList;
    }
}
