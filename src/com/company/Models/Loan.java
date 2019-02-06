package com.company.Models;

import java.sql.Timestamp;

public class Loan {
    int id;
    int amount;
    double rate;
    int granted;
    Timestamp timestamp;
    int accountId;
    int workerId;

    public Loan(int id, int amount, double rate, int accountId, int workerId, int granted, Timestamp timestamp){
        this.id = id;
        this.amount = amount;
        this.rate = rate;
        this.granted = granted;
        this.timestamp = timestamp;
        this.accountId = accountId;
        this.workerId = workerId;
    }
    public Loan(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getGranted() {
        return granted;
    }

    public void setGranted(int granted) {
        this.granted = granted;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
