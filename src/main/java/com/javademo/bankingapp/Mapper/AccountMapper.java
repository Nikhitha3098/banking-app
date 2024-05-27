package com.javademo.bankingapp.Mapper;

import com.javademo.bankingapp.AccountDto.AccountDTO;
import com.javademo.bankingapp.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDto){
        Account account=new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
        return account;
    }
    public static AccountDTO mapToAccountDto(Account account){
        AccountDTO accountDto=new AccountDTO(account.getId(),account.getAccountHoldername(),account.getBalance());
        return accountDto;
    }
}
