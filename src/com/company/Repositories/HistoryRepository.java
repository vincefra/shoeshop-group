package com.company.Repositories;
import com.company.Dao.daoimpl.HistoryDaoImpl;
import com.company.Dao.daoimpl.WorkerDaoImpl;
import com.company.Models.History;
import com.company.Models.Loan;
import com.company.View.AccountView;
import com.company.View.BankView;
import com.company.View.HistoryView;

import java.security.Timestamp;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {
    HistoryDaoImpl historyDao;
    WorkerDaoImpl workerDao;

    public HistoryRepository(){
        historyDao = new HistoryDaoImpl();
        workerDao = new WorkerDaoImpl();
    }
    public List<History> getHistoryByAccountId(int accountId) {
        List<History> histories = historyDao.getAllHistories();
        List<History> temp = new ArrayList<>();
        for (History h : histories) {
            if (h.getAccountid() == accountId) {
                temp.add(h);
            }
        }
        return temp;
    }
    public void printHistories(int accountId) {
        historyDao.getHistoryLastMonthByAccountid(accountId).forEach(c -> new HistoryView().printHistory(c.getTimestamp(), c.getAmount(), c.getAccountid(), c.getComment()));
    }
    public void printHistories() {
        historyDao.getAllHistories().forEach(c -> new HistoryView().printHistory(c.getTimestamp(), c.getAmount(), c.getAccountid(), c.getComment()));
    }
//    public void printHistoriesByHistoryId(int historyId) {
//        new HistoryView().printHistory(workerDao.selectCreatedFromCertainPeriod(historyId));
//    }
}
