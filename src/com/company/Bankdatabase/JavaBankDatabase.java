package com.company.Bankdatabase;

import com.company.Dao.daoimpl.*;
import com.company.Models.Account;
import com.company.Models.Customer;
import com.company.Models.Loan;
import com.company.Repositories.*;

import java.sql.SQLException;
import java.util.Scanner;

public class JavaBankDatabase 
{
    static CustomerDaoImpl customerDao;
    static AccountDaoImpl accountDao;
    static BankDaoImpl bankDao;
    static LoanDaoImpl loanDao;
    static HistoryDaoImpl historyDao;
    static WorkerDaoImpl workerDao;
    static WorkerRepository wr;
    static AccountRepository ar;
    static CustomerRepository cr;
    static BankRepository br;
    static LoanRepository lr;
    static HistoryRepository hr;
    static Customer customer;
    static Account account;
    static Loan loan;
    static int accountId;
    static int amount;

    public static void main(String[] args) throws SQLException
    {
        cr = new CustomerRepository();
        ar = new AccountRepository();
        br = new BankRepository();
        lr = new LoanRepository();
        wr = new WorkerRepository();
        hr = new HistoryRepository();
        historyDao = new HistoryDaoImpl();
        bankDao = new BankDaoImpl();
        workerDao = new WorkerDaoImpl();
        customerDao = new CustomerDaoImpl();
        accountDao = new AccountDaoImpl();
        loanDao = new LoanDaoImpl();
        
        //forCustomer();
        //forAdmin();
    }

    public static String getInputString(String message)
    {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        String name = scan.next();

        return name;
    }

    public static int getInputInt(String message)
    {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();

        return value;
    }

    public static void forCustomer () throws SQLException 
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter your pin number");
        int pinNum = userInput.nextInt();

             Customer customer = cr.getCustomerByCustomerId(ar.getAccountsByPinNumber(pinNum).get(0).getCustomerid());
            if(customer == null){
                System.out.println("Couldnt find customer");
            }
            else{
                printOptionsForCustomer();
            }
        int choice = userInput.nextInt();
        if (choice == 1) {
            ar.printAccountsByCustomerId(customer.getId());
            accountId = getInputInt("Which accountnumber?");
            Account account = ar.getAccountByAccountId(accountId);
            amount = getInputInt("How much would you like to withdraw?");
            accountDao.subtractBalance(account.getAccountId(), amount);
        }
        if (choice == 2) {
            ar.printAccountsByCustomerId(customer.getId());
            accountId = getInputInt("Type an accountnumber to check your loan status");
            lr.printLoan();
        }
        if (choice == 3) {
            ar.printAccountsByCustomerId(customer.getId());
            accountId = getInputInt("Type an accountnumber to check your history");
            hr.printHistories(accountId);
        }
        if(choice == 4){
            ar.printAccounts();
            int accountId = getInputInt("Type in the account id you'd like to chose from");
            workerDao.monthlyHistory(accountId);
            hr.printHistories(accountId);
        }
    }
    public static void forAdmin() throws SQLException 
    {
        printOptionsForWorker();
        int choice = getInputInt("What would you like to do?");
        
        if(choice == 1){
            cr.printCustomers();
            int customerId = getInputInt("for what customer would you like to create an account");
            int pinNumber = getInputInt("Which pinNumber would you like to have");
            workerDao.createAccount(customerId, pinNumber);
        }
        else if(choice == 2){
            cr.printCustomers();
            int customerId = getInputInt("Which customer would you like to remove");
            workerDao.removeCustomer(customerId);
        }
        else if(choice == 3){
            cr.printCustomers();
            int customerid = getInputInt("For what customer would you like to update");
            String uppdatedCity = getInputString("Type the new city");
            workerDao.uppdateCustomerCity(customerid,uppdatedCity);
        }
        else if(choice == 4){
            ar.printAccounts();
            int accoutnId = getInputInt("Which account would you like disable");
            workerDao.disableAccount(accoutnId);
        }
        else if(choice == 5){
            ar.printAccounts();
            int accountId = getInputInt("For what account would you like to add money to?");
            int amount = getInputInt("How much would you like to add?");
            workerDao.addBalance(accountId, amount);
        }
        else if(choice == 6){
            ar.printAccounts();
            int accountId = getInputInt("For what account would you like to withdraw money to?");
            int amount = getInputInt("How much would you like to withdraw?");
            workerDao.subtractBalance(accountId, amount);
        }
        else if(choice == 7){
            ar.printAccounts();
            int accountId = getInputInt("For what account would you like to change the rate?");
            double rate = getInputInt("type the new rate");
            workerDao.changeRateAccount(accountId, rate);
        }
        else if(choice == 8){
            wr.printWorkers();
            int workerId = getInputInt("Which worker is granting  the loan?");
            int loanid = getInputInt("For which loan?");
            int numOfMonths = getInputInt("Type the number of months");
            workerDao.grantLoan(workerId, loanid, numOfMonths);
        }
        else if(choice == 9){
            lr.printLoan();
            int loanid = getInputInt("For which loan?");
            double newRate = getInputInt("Type in the new rate?");
            workerDao.changeRateLoan(loanid,newRate);
        }
        else if(choice == 10){
            lr.printLoan();
            int loanid = getInputInt("For which loan would you like to change the payment plan?");
            int newMonths = getInputInt("Type in the number of months");
            workerDao.changePaymentPlan (loanid, newMonths);
        }
        else if(choice == 11){

        }
        else if(choice == 12){
            lr.printLoan();
            int loanId = getInputInt("Type the desired loan id");
            br.printProfits(loanId);
        }
        else if(choice == 13){
            String name = getInputString("Type the name of the customer");
            String city = getInputString("Type the city of the customer");
            workerDao.createNewCustomer(name,city);
        }
        else if(choice == 14){
            //String theTime = getInputString("Chose the time");
            //workerDao.selectCreatedFromCertainPeriod(theTime);
        }
    }

    public static void printOptionsForCustomer() {
        System.out.println("What would you like to do next?");
        System.out.println("1. Withdraw\n" +
            "2. Check account and loan\n" +
            "3. Check accounthistory\n" +
            "4. show history for a account on a specific timeperio");
    }
    
    public static void printOptionsForWorker()
    {
        System.out.println
           ("1. Create account for customer\n" +
            "2. Delete customer\n" +
            "3. Update customer information\n" +
            "4. Disable a account for a customer\n" +
            "5. Deposit money for customer account\n" +
            "6. Withdraw money for customer account\n" +
            "7. Change rate on customer account\n" +
            "8. Grant a loan for a customer\n" +
            "9. Change rate on a customer loan\n " +
            "10. change paymentplan on a customers loan\n " +
            "11. \n " +
            "12. Show bankprofit\n" +
            "13. Create new customer\n " +
            "14. Show history for a specific time");
    }
}
