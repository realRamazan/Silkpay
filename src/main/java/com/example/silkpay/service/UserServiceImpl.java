package com.example.silkpay.service;

import com.example.silkpay.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Override
    public Users getUser(int id) {
        return null;
    }

    @Override
    public void transfer(int id, double sum) {

    }

    @Override
    public Users createAccount(int id, double sum) {
        return null;
    }
}
