package com.company.Dao.daoimpl;

import com.company.Dao.AccountDao;
import com.company.Database.DataBase;
import com.company.Models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoImpl implements AccountDao{
    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        Map<Integer, Account> accountMap = new HashMap();

        try (Connection con = DataBase.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");

            while (rs.next())
                accounts.add(new Account(rs.getInt("id"), rs.getInt("customerid"), rs.getDouble("balance"),
                        rs.getInt("active"), rs.getInt("pinnumber"), rs.getDouble("rate")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return accounts;
    }
    @Override
    public void subtractBalance(int accountid, int amount) {
        try (Connection con = DataBase.getConnection()) {
            String query = "call subtractBalance(?, ?)";

            CallableStatement stmt = con.prepareCall(query);{
                stmt.setInt(1, accountid);
                stmt.setInt(2, amount);
                stmt.execute();
            }
            System.out.println("Everything went good:");
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
