package com.example.silkpay.accountDAOImpl;


import com.example.silkpay.dao.AccountDAO;
import com.example.silkpay.dao.AccountDAOImpl;
import com.example.silkpay.entity.Accounts;
import com.example.silkpay.repostitory.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountDAOImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountDAOImpl accountDAO;

    @Test
    public void shouldReturnAccountsByUserId(){
        Integer userId = 1;
        List<Accounts> accounts = getAccounts2();
        Mockito.when(accountRepository.findAllByUserId(1)).thenReturn(accounts);
        List<Accounts> res = accountDAO.getAccounts(userId);

        Assertions.assertNotNull(res);
        Assertions.assertEquals(2, res.size());
        Assertions.assertEquals(accounts.get(0).getUserId(), res.get(0).getUserId());
    }

    private List<Accounts> getAccounts2(){
        Accounts account = new Accounts();
        Accounts account2 = new Accounts();
        account.setId(1);
        account.setCardNum("4854");
        account.setUserId(1);
        account.setBalance(700);

        account2.setId(2);
        account2.setCardNum("1547");
        account2.setUserId(2);
        account2.setBalance(400);
        return List.of(account, account2);
    }
}
