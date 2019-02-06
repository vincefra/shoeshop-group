package com.company.Models;
import java.util.ArrayList;
import java.util.List;

public class Workers {
    int id;
    String firstName;
    int accountId;
    List<Loan> loans;

    public Workers(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
        loans = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
