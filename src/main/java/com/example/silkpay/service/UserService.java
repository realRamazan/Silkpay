package com.example.silkpay.service;

import com.example.silkpay.entity.Users;

public interface UserService {
    public Users getUser(int id);
    public void transfer(int id, double sum);
    public Users createAccount(int id, double sum);
}
