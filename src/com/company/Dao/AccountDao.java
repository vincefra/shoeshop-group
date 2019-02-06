package com.company.Dao;

import com.company.Models.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAllAccounts();
    void subtractBalance(int account_id, int value);
}
