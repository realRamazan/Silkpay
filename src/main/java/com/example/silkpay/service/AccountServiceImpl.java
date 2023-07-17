package com.example.silkpay.service;

import com.example.silkpay.dao.AccountDAO;
import com.example.silkpay.entity.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional
    public List<Accounts> getAccounts(Integer user_id) {
        return accountDAO.getAccounts(user_id);
    }

    @Override
    @Transactional
    public List<Accounts> moneyTransfer(Integer userId, String cardNum, String cardNum2, Double cash) {
        return accountDAO.moneyTransfer(userId, cardNum, cardNum2, cash);
    }

    @Override
    @Transactional
    public List<Accounts> createAccount(Integer userId, Double balance) {
        return accountDAO.createAccount(userId, balance);
    }
}
