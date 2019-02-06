package com.company.Dao.daoimpl;
import com.company.Dao.CustomerDao;
import com.company.Database.DataBase;
import com.company.Models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (Connection con = DataBase.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");

            while (rs.next())
                customers.add(
                        new Customer(rs.getInt(1), rs.getString(2)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return customers;
    }
}
