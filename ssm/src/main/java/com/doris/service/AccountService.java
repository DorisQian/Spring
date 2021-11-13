package com.doris.service;

import com.doris.domain.Account;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    public void save(Account account) throws IOException;
    public List<Account> findAll();
}
