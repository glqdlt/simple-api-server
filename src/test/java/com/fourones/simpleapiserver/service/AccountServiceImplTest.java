package com.fourones.simpleapiserver.service;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;
import com.fourones.simpleapiserver.persistence.simpleMemoryDB.repository.account.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

    @TestConfiguration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
//            아래로 다른 구현체로 경우엔 findAccount, findAccountIsNull 에서 에러가 날 것이다.
//            왜냐면 AnotherAccount 에서는 repository를 쓰지 않고, 서비스에서 직접 만든 객체를 return 하기 때문
//            이 주석과 아래 코드를 남기느 ㄴ것은 @TestConfiguration 에 대한 학습 테스트용으로 나두기 위함이다.
//            return new AnotherAccountServiceImpl();
        }

    }

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception {

        Account mock = Account.builder().seq((long) 1).id("hahaha").password("pwpw").regDate(new Date()).build();
        Mockito.when(accountRepository.findBySeq((long) 1)).thenReturn(mock);
        Mockito.when(accountRepository.findAll()).thenReturn(Collections.singletonList(mock));
    }

    @Test
    public void findAccount() {
        Assert.assertSame("hahaha", accountService.findAccount((long) 1).getId());
    }

    @Test
    public void findAccounts(){
        Assert.assertSame(1, accountService.findAccounts().size());
    }

    @Test
    public void findAccountIsNull() {
        Assert.assertNull(accountService.findAccount((long) 2));
    }


}