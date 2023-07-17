package com.example.silkpay.service;

import com.example.silkpay.entity.Accounts;
import com.example.silkpay.repostitory.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;


    @Override
    @Transactional
    public List<Accounts> getAccounts(Integer user_id) {
        return accountRepository.findAllByUserId(user_id);
    }

    @Override
    @Transactional
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
    @Transactional
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
