package com.company.Dao.daoimpl;
import com.company.Dao.WorkerDao;
import com.company.Database.DataBase;
import com.company.Models.Workers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {
    @Override
    public List<Workers> getAllWorkers() {
        List<Workers> workers = new ArrayList<>();

        try (Connection con = DataBase.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM worker");

            while (rs.next())
                workers.add(
                        new Workers(rs.getInt(1), rs.getString(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }
    public void createAccount(int customerId, int pinNumber) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call createAccount(?,?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
                cStmt.setInt(2, customerId);
            cStmt.setInt(3, pinNumber);

                cStmt.execute();
                int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeCustomer(int customerId) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call removeCustomer(?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, customerId);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void disableAccount(int accountid) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call disableAccount(?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, accountid);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changePaymentPlan(int loanid, int newMonths) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call changePaymentPlan(?,?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, loanid);
            cStmt.setInt(3, newMonths);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeRateAccount(int accountId, double rate) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call changeRateAccount(?, ?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, accountId);
            cStmt.setDouble(3, rate);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void changeRateLoan(int loanId, double rate) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call changeRateLoan(?, ?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, loanId);
            cStmt.setDouble(3, rate);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void grantLoan(int workerId, int loanid, int numOfMonths) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call grantLoan(?,?,?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, workerId);
            cStmt.setDouble(3, loanid);
            cStmt.setDouble(4, numOfMonths);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void subtractBalance(int account_id, int value) {
        try (Connection con = DataBase.getConnection()) {
            String query = "call subtractBalance(?, ?)";

            CallableStatement stmt = con.prepareCall(query);{
                stmt.setInt(1, account_id);
                stmt.setInt(2, value);
                stmt.executeQuery();
            }
            System.out.println("Everything went good:");
            con.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong with the withdrawal :(");
        }
    }
    public void addBalance(int account_id, int value) {
        try (Connection con = DataBase.getConnection()) {
            String query = "call addBalance(?, ?)";

            CallableStatement stmt = con.prepareCall(query);{
                stmt.setInt(1, account_id);
                stmt.setInt(2, value);
                stmt.executeQuery();
            }
            System.out.println("Everything went good:");
            con.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong with the withdrawal :(");
        }
    }

    @Override
    public void uppdateCustomerCity(int customer_id, String uppdatedCity) {
        try (Connection con = DataBase.getConnection()) {
            String query = "{? = call uppdateCustomerCity(?,?)}";
            CallableStatement cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.INTEGER);
            cStmt.setInt(2, customer_id);
            cStmt.setString(3, uppdatedCity);
            cStmt.execute();
            int outputValue = cStmt.getInt(1);

            if(outputValue > 0){
                System.out.println("Everything went good:");
                con.close();
            }else{
                System.out.println("Something went wrong with the withdrawal :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createNewCustomer(String name, String city) {
        try (Connection con = DataBase.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO customer (name, city) VALUES(?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, city);
            int a = stmt.executeUpdate();
            if(a > 0){
                System.out.println("Everything went good");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectCreatedFromCertainPeriod(int historyId) {
        try (Connection con = DataBase.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM history WHERE id = '?'");
            stmt.setInt(1, historyId);
            int a = stmt.executeUpdate();
            if(a > 0){
                System.out.println("Everything went good");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void monthlyHistory(int account_id) {
        try (Connection con = DataBase.getConnection()) {
            String query = "call monthlyHistory(?)";

            CallableStatement stmt = con.prepareCall(query);{
                stmt.setInt(1, account_id);
                stmt.executeQuery();
            }
            System.out.println("Everything went good:");
            con.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong with the withdrawal :(");
        }
    }
}
