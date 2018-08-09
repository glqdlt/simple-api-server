package com.fourones.simpleapiserver.persistence.simpleMemoryDB.repository.account;

import com.fourones.simpleapiserver.persistence.simpleMemoryDB.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findBySeq(Long seq);

    void deleteBySeq(Long seq);


}
