package com.example.silkpay.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "card_num")
    private String cardNum;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "balance")
    private double balance;

    public Accounts() {
    }

    public Accounts(int id, String cardNum, int user_id, double balance) {
        this.id = id;
        this.cardNum = cardNum;
        this.userId = user_id;
        this.balance = balance;
    }

    public Accounts(String cardNum, int userId, double balance) {
        this.cardNum = cardNum;
        this.userId = userId;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", card_num='" + cardNum + '\'' +
                ", user_id=" + userId +
                ", balance=" + balance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
