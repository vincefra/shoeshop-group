package com.company.Dao.daoimpl;

import com.company.Dao.BankDao;
import com.company.Database.DataBase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class BankDaoImpl implements BankDao{

    public double getBankProfitByLoanId(int loan_id) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call bankprofit(?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, loan_id);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
                return outputValue;
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
