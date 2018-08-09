package com.fourones.simpleapiserver.service;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AnotherAccountServiceImpl implements  AccountService {

    private Account mock;

    public AnotherAccountServiceImpl() {
        this.mock = Account.builder().regDate(new Date()).id("www").build();
    }

    @Override
    public Account findAccount(Long seq) {
        return mock;
    }

    @Override
    public List<Account> findAccounts() {
        return Collections.singletonList(mock);
    }
}
