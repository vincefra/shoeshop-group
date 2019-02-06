package com.company.Dao.daoimpl;

import com.company.Dao.HistoryDao;
import com.company.Database.DataBase;
import com.company.Models.Account;
import com.company.Models.History;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryDaoImpl implements HistoryDao{
    @Override
    public List<History> getAllHistories() {
        List<History> histories = new ArrayList<>();

        try (Connection con = DataBase.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM History");

            while (rs.next())
                histories.add(new History(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return histories;
    }

    public List<History> getHistoryLastMonthByAccountid(int accountId) {
        List<History> histories = new ArrayList<>();

        try (Connection con = DataBase.getConnection())
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from history where accountid = '" + accountId + "'" +
                    "and created between DATE_ADD(now(), INTERVAL -30 DAY) and current_timestamp()");


            while (rs.next())
                histories.add(new History(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3),
                        rs.getInt(4), rs.getString(5)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return histories;
    }

}
