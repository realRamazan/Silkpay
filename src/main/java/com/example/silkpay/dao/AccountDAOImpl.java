package com.example.silkpay.dao;

import com.example.silkpay.entity.Accounts;
import com.example.silkpay.repostitory.AccountRepository;
import com.example.silkpay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Accounts> getAccounts(Integer user_id) {
        return accountRepository.findAllByUserId(user_id);
    }

    @Override
    public List<Accounts> moneyTransfer(Integer userId, String cardNum, String cardNum2, Double cash) {
        Accounts account = accountRepository.findByCardNum(cardNum);
        Accounts account2 = accountRepository.findByCardNum(cardNum2);
        if(account.getBalance() - cash < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не хватает денежных средств");
        }
        else {
            account.setBalance(account.getBalance() - cash);
            account2.setBalance(account2.getBalance() + cash);
            accountRepository.save(account);
            accountRepository.save(account2);
            return accountRepository.findAllByUserId(userId);
        }


    }

    @Override
    public List<Accounts> createAccount(Integer userId, Double balance) {
        Random random = new Random();
        String cardNum = "Some num";
        boolean t = true;
        while(t){
            String randomCardNum = String.format("%04d", random.nextInt(10000));
            if(accountRepository.findByCardNum(randomCardNum) == null){
                cardNum = randomCardNum;
                t = false;
            }
        }
        Accounts accounts = new Accounts(cardNum, userId, balance);
        accountRepository.save(accounts);
        return accountRepository.findAllByUserId(userId);
    }
}
