package com.example.silkpay.dao;

import com.example.silkpay.entity.Accounts;

import java.util.List;

public interface AccountDAO {

    List<Accounts> getAccounts(Integer user_id);

    List<Accounts> moneyTransfer(Integer userId, String cardNum, String cardNum2, Double cash);

    List<Accounts> createAccount(Integer userId, Double balance);

}
