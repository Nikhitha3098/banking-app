package com.javademo.bankingapp.Controller;

import com.javademo.bankingapp.AccountDto.AccountDTO;
import com.javademo.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.OK);
    }
    @GetMapping("/getAccountDetails/{Id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long Id){
        return new ResponseEntity<>(accountService.getAccountById(Id),HttpStatus.OK);
    }

    @PutMapping("/updateBalance/{id}")
    public ResponseEntity<AccountDTO> updateBalance(@PathVariable Long id, @RequestBody Map<String,Double> request){
     AccountDTO accountDTO= (accountService.updateBalance(id,request.get("amount")));
     return  ResponseEntity.ok(accountDTO);
    }


}
