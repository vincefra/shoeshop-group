package com.company.View;
import java.sql.Timestamp;

public class HistoryView {
    public void printHistory(Timestamp timestamp, int accountid, int amount, String comment){
        System.out.println(" Created " + timestamp + " Amount " + amount
                + " Accountid: " + accountid + " Comment " + comment);
    }
}
