package com.qiren.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.bean.BorrowBookBean;
import com.qiren.miniproj.manager.ConnectionManager;

public class BorrowBookDAO {

    public BorrowBookBean findBorrowByBookNotReturn(String pkBook) {

        BorrowBookBean bookBean = null;

        Connection connection = ConnectionManager.getConnection();

        // get book not returned
        String sql = "select * from borrow_book where fkBook = ? && toDate is null";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, pkBook);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                bookBean = new BorrowBookBean();
                bookBean.setPkBorrowBook(res.getString("pkBorrowBook"));
                bookBean.setFkBook(res.getString("fkBook"));
                bookBean.setFkUser(res.getString("fkUser"));
                bookBean.setFromDate(res.getString("fromDate"));
                bookBean.setToDate(res.getString("toDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(connection);
        }

        return bookBean;
    }

    public boolean addToBorrow(BorrowBookBean bean) {
        Connection connection = ConnectionManager.getConnection();

        String sql = "insert into borrow_book values (?,date(now()),?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, null);
            ps.setString(2, null);
            ps.setString(3, bean.getFkUser());
            ps.setString(4, bean.getFkBook());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionManager.closeConnection(connection);
        }
        return true;
    }
}
