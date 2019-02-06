package com.company.Repositories;

import com.company.Dao.daoimpl.AccountDaoImpl;
import com.company.Database.DataBase;
import com.company.Models.Account;
import com.company.Models.Customer;
import com.company.View.AccountView;
import com.company.View.CustomerView;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class AccountRepository {
    AccountDaoImpl accountDao;


    public AccountRepository(){
         accountDao = new AccountDaoImpl();
    }
    public void printAccountsByCustomerId(int customerId) {
        getAccountByCustomerId(customerId).forEach(c -> new AccountView().printAccount(c.getAccountId(), c.getBalance()));
    }
    public void printAccounts() {
        accountDao.getAllAccounts().forEach(c -> new AccountView().printAccount(c.getAccountId(), c.getBalance()));
    }
    public Account getAccountByAccountId(int accountId){
        List<Account> accounts = accountDao.getAllAccounts();
        for(Account a : accounts){
            if(a.getAccountId() == accountId){
                return a;
            }
        }
        return null;
    }
    public List<Account> getAccountsByPinNumber(int pinNumber) {
        List<Account> accounts = accountDao.getAllAccounts();
        List<Account> temp = new ArrayList<>();
        for(Account a : accounts){
            if(a.getPinNumber() == pinNumber){
                temp.add(a);
            }
        }
        return temp;
    }
    public List<Account> getAccountByCustomerId(int customerId) {
        List<Account> accounts = accountDao.getAllAccounts();
        List<Account> temp = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getCustomerid() == customerId) {
                temp.add(a);
            }
        }
        return temp;
    }
}
