package com.company.Repositories;

import com.company.Dao.daoimpl.WorkerDaoImpl;
import com.company.View.WorkerView;

public class WorkerRepository {
    WorkerDaoImpl workerDao;
    public WorkerRepository(){
        workerDao = new WorkerDaoImpl();
    }
//    public void printWorkersByAccountId(int accountId) {
//        getWorkerByAccountId(accountId).forEach(c -> new WorkerView().printWorker(c.getFirstName()));
//    }
    public void printWorkers() {
        workerDao.getAllWorkers().forEach(c -> new WorkerView().printWorker(c.getFirstName()));
    }
//    public List<Workers> getWorkerByAccountId(int accountId) {
//        List<Workers> workers = workerDao.getAllWorkers();
//        List<Workers> temp = new ArrayList<>();
//        for (Workers w : workers) {
//            if (w.getAccountId() == accountId) {
//                temp.add(w);
//            }
//        }
//        return temp;
//    }

}
