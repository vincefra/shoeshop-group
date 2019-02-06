package com.company.View;

import java.sql.Timestamp;

public class LoanView {

    public LoanView(){
    }
    public void printLoan(int id, int granted, double rate, double amount, Timestamp timestamp){
        System.out.println("Loanid " + id + "Granted: " + granted + " Rate: " + rate + " Amount: " + amount + " Created " + timestamp);
    }
}
