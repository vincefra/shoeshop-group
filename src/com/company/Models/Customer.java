package com.company.Models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    String email;
    List<Account> accounts;


    public Customer(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
        accounts = new ArrayList<>();
    }
    public Customer(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
}
