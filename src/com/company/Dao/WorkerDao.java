package com.company.Dao;
import com.company.Models.Workers;
import java.util.List;

public interface WorkerDao {
    List<Workers> getAllWorkers();
    void createAccount(int customerId, int pinNumber);
    void removeCustomer(int customerId);
    void disableAccount(int accountid);
    void changePaymentPlan(int loanid, int newMonths);
    void changeRateAccount(int accountId, double rate);
    void changeRateLoan(int loanId, double rate);
    void grantLoan(int workerId, int loanid, int numOfMonths);
    void subtractBalance(int account_id, int value);
    void addBalance(int accountid, int amount);
    void uppdateCustomerCity (int customer_id, String uppdatedCity);
    void createNewCustomer(String name, String city);
    void selectCreatedFromCertainPeriod(int historyId);
}
