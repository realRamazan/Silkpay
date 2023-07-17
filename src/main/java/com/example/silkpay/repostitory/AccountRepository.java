package com.example.silkpay.repostitory;

import com.example.silkpay.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
    public List<Accounts> findAllByUserId(Integer userId);
    public Accounts findByCardNum(String cardNum);
}
