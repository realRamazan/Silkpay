package com.example.silkpay.service;

import com.example.silkpay.dao.UserDAO;
import com.example.silkpay.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

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
