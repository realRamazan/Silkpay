package com.example.silkpay.dao;

import com.example.silkpay.entity.Users;


public interface UserDAO {
    public Users getUser(int id);
    public void transfer(int id, double sum);
    public Users createAccount(int id, double sum);
}
