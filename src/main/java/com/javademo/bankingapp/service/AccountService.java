package com.javademo.bankingapp.service;

import com.javademo.bankingapp.AccountDto.AccountDTO;
import com.javademo.bankingapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {

    @Autowired
    AccountDTO createAccount(AccountDTO accountDto);

    AccountDTO getAccountById(Long Id);

    AccountDTO updateBalance(Long id, double balance);
}
