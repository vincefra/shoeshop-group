package com.company.Repositories;

import com.company.Dao.daoimpl.LoanDaoImpl;
import com.company.Models.Account;
import com.company.Models.Loan;
import com.company.View.AccountView;
import com.company.View.LoanView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    LoanDaoImpl loanDao;

    public LoanRepository(){
        loanDao = new LoanDaoImpl();

    }
    public void printLoan(int accountId) throws SQLException
    {
        getLoanByAccountId(accountId).forEach(c -> new LoanView().printLoan(c.getId(), c.getGranted(), c.getRate(),c.getAmount(),c.getTimestamp()));
    }
        public void printLoan() throws SQLException
    {
        loanDao.getAllLoans().forEach(c -> new LoanView().printLoan(c.getId(), c.getGranted(), c.getRate(),c.getAmount(),c.getTimestamp()));
    }

    public List<Loan> getLoanByAccountId(int accountId) {
        List<Loan> loans = loanDao.getAllLoans();
        List<Loan> temp = new ArrayList<>();
        for (Loan l : loans) {
            if (l.getAccountId() == accountId) {
                temp.add(l);
            }
        }
        return temp;
    }
}
