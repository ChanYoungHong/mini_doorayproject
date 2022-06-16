package com.nhnacademy.account.project.accountapi.service;

import com.nhnacademy.account.project.accountapi.domain.Account;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account registerAccount(Account account);

    Optional<Account> findAccountById(String accountDto);
}
