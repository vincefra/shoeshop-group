package com.company.Repositories;
import com.company.Dao.daoimpl.BankDaoImpl;
import com.company.View.BankView;

import java.sql.SQLException;

public class BankRepository {
    BankDaoImpl bankDao;

    public BankRepository(){
        bankDao = new BankDaoImpl();
    }
    public void printProfits(int loanId) throws SQLException
    {
        new BankView().printProfit(bankDao.getBankProfitByLoanId(loanId));
    }
}
