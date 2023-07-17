package com.example.silkpay.dao;


import com.example.silkpay.entity.Users;
import com.example.silkpay.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

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
