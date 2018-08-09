package com.fourones.simpleapiserver.persistence.simpleMemoryDB.repository.account;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        List<Account> accounts = IntStream.rangeClosed(1, 10).boxed().map(x -> Account.builder().id("userId-" + x).password("pw-" + x).regDate(new Date()).build()).collect(Collectors.toList());
        accountRepository.save(accounts);
    }

    @Test
    public void constructedThisTest() {

    }

    @Test
    public void findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        Assert.assertSame(10, accounts.size());
    }

    @Test
    public void findByAccountId() {
        Account account = accountRepository.findBySeq((long) 1);
        log.info("account : {} ", account.toString());
        Assert.assertNotNull(account);
        Assert.assertSame(account.getId(), "userId-1");
    }

    @Test
    public void findByAccountSeqWithUpdateAccount() {
        Account account = accountRepository.findBySeq((long) 1);
        Account updatedAccount = Account.builder().seq(account.getSeq()).id("hahaha").password(account.getPassword()).regDate(new Date()).build();
        accountRepository.saveAndFlush(updatedAccount);
        Assert.assertSame("hahaha", accountRepository.findBySeq((long) 1).getId());
    }

    @Test
    public void deleteByAccountSeq() {
        accountRepository.deleteBySeq((long) 1);
        Account account = accountRepository.findBySeq((long) 1);
        Assert.assertNull(account);
    }


}