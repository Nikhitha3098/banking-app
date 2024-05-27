package com.javademo.bankingapp.service.Impl;

import com.javademo.bankingapp.AccountDto.AccountDTO;
import com.javademo.bankingapp.Mapper.AccountMapper;
import com.javademo.bankingapp.entity.Account;
import com.javademo.bankingapp.repository.AccountRepository;
import com.javademo.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    public AccountDTO getAccountById(Long id){
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits"));
        return AccountMapper.mapToAccountDto(account);
    }

    public AccountDTO updateBalance(Long id, double balance){
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Does not exits"));
        double abalance= account.getBalance()+balance;
        account.setBalance(abalance);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
