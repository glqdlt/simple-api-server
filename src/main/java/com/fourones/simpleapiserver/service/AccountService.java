package com.fourones.simpleapiserver.service;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;
import com.fourones.simpleapiserver.persistence.simpleMemoryDB.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account findAccount(Long seq){
        return accountRepository.findBySeq(seq);
    }

    public List<Account> findAccounts(){
        return accountRepository.findAll();
    }

}
