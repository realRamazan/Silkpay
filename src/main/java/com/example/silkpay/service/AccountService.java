package com.example.silkpay.service;

import com.example.silkpay.entity.Accounts;

import java.util.List;

public interface AccountService {
    public List<Accounts> getAccounts(Integer user_id);
    public List<Accounts> moneyTransfer(Integer userId, String cardNum, String cardNum2, Double cash);

    public List<Accounts> createAccount(Integer userId, Double balance);
}
