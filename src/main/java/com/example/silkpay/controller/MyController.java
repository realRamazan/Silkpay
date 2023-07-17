package com.example.silkpay.controller;

import com.example.silkpay.entity.Accounts;
import com.example.silkpay.service.AccountService;
import com.example.silkpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/{id}")
    public List<Accounts> userInfo(@PathVariable("id") Integer user_id){

        return accountService.getAccounts(user_id);
    }

    @PostMapping("/transfer")
    public List<Accounts> moneyTransfer(@RequestParam("id") Integer userId,
                                        @RequestParam("cardNum") String cardNum,
                                        @RequestParam("cardNum2") String cardNum2,
                                        @RequestParam("cash") Double cash){
        return accountService.moneyTransfer(userId, cardNum, cardNum2, cash);

    }

    @PostMapping("/create")
    public List<Accounts> createAccount(@RequestParam("id") Integer id,
                                        @RequestParam("balance") Double balance){
        return accountService.createAccount(id, balance);
    }
}
