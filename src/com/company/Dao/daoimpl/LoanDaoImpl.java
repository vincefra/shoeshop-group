package com.company.Dao.daoimpl;

import com.company.Dao.LoanDao;
import com.company.Database.DataBase;
import com.company.Models.Account;
import com.company.Models.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanDaoImpl implements LoanDao{

    @Override
    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();

        try (Connection con = DataBase.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Loan");

            while (rs.next())
                loans.add(new Loan(rs.getInt(1), rs.getInt(2), rs.getDouble(3),
                        rs.getInt(4), rs.getInt(5),rs.getInt(6),rs.getTimestamp(7)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return loans;
    }
}
