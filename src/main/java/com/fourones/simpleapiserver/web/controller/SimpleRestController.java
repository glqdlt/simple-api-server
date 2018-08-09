package com.fourones.simpleapiserver.web.controller;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;
import com.fourones.simpleapiserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class SimpleRestController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public List<Account> findAccounts() {
        return accountService.findAccounts();
    }

    @GetMapping("/board/{seq}")
    public Account findAccountBySeq(@PathVariable("seq") String seq) {
        return accountService.findAccount(Long.parseLong(seq));
    }

}
