package com.company.Models;


public class Account {
    int id;
    int customerid;
    double balance;
    int active;
    int pinNumber;
    double rate;



    public Account(int id, int customerId, double balance,  int active, int pinNumber, double rate){
        this.id = id;
        this.balance = balance;
        this.customerid = customerId;
        this.active = active;
        this.pinNumber = pinNumber;
        this.rate = rate;
        new Customer();
        new Loan();
    }
    public Account(){
    }
    public int getAccountId() {
        return id;
    }
    public int getCustomerid() {
        return customerid;
    }
    public double getBalance() {
        return balance;
    }
    public int isActive() {
        return active;
    }
    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
