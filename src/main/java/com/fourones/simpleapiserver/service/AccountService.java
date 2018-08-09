package com.fourones.simpleapiserver.service;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;

import java.util.List;

public interface AccountService {

    Account findAccount(Long seq);

    List<Account> findAccounts();
}
