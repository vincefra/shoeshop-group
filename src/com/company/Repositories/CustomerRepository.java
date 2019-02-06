package com.company.Repositories;

import com.company.Dao.daoimpl.CustomerDaoImpl;
import com.company.Database.DataBase;
import com.company.Models.Account;
import com.company.Models.Customer;
import com.company.View.CustomerView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerRepository {
    CustomerDaoImpl customerDao;

    public CustomerRepository(){
        customerDao = new CustomerDaoImpl();
    }
    public void printCustomers() throws SQLException
    {
        customerDao.getAllCustomers().forEach(c -> new CustomerView().printCustomer(c.getFirstName(), c.getEmail()));
    }
    public Customer getCustomerByCustomerId(int customerId){
        List<Customer> customers = customerDao.getAllCustomers();
        for(Customer c : customers)
            if(c.getId() == customerId)
                return c;
        return null;
    }

}
