package com.company.Models;

import java.sql.Timestamp;

public class History {
    int id;
    Timestamp timestamp;
    int accountid;
    String comment;
    int amount;

    public History(int id, Timestamp timestamp, int accountid,  int amount, String comment){
        this.accountid = accountid;
        this.comment = comment;
        this.amount = amount;
        this.timestamp = timestamp;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
