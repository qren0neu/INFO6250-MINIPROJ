package com.qiren.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.bean.BorrowBookBean;
import com.qiren.miniproj.manager.ConnectionManager;

public class BorrowBookDAO {
    
    public BorrowBookBean findBorrowBookBeanById(String id) {
        BorrowBookBean bookBean = null;

        Connection connection = ConnectionManager.getConnection();

        // get book not returned
        String sql = "select * from borrow_book where pkBorrowBook = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
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

    public boolean updateReturnDate(String id) {
        Connection conn = ConnectionManager.getConnection();
        
        String sql = "update borrow_book set todate = date(now()) where pkBorrowBook = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, id);
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            ConnectionManager.closeConnection(conn);
        }
        return true;
    }

    public List<BorrowBookBean> getBorrowList() {

        Connection conn = ConnectionManager.getConnection();
        List<BorrowBookBean> books = new ArrayList<>();
        String sql = "select pkBorrowBook, fromDate, todate, `user`.username, book.`name`"
                + " from borrow_book "
                + " left join book "
                + " on fkBook = pkBook "
                + " left join `user` "
                + " on fkUser = pkUser;";
        System.out.println(sql);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                BorrowBookBean bean = new BorrowBookBean();
                bean.setPkBorrowBook(res.getString("pkBorrowBook"));
                bean.setFromDate(res.getString("fromDate"));
                bean.setToDate(res.getString("todate"));
                bean.setFkUser(res.getString("username"));
                bean.setFkBook(res.getString("name"));
                books.add(bean);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
        return books;
    }

    public List<BorrowBookBean> getBorrowListByUser(String userId) {

        Connection conn = ConnectionManager.getConnection();
        List<BorrowBookBean> books = new ArrayList<>();
        String sql = "select pkBorrowBook, fromDate, todate, `user`.username, book.`name`"
                + " from borrow_book "
                + " left join book "
                + " on fkBook = pkBook "
                + " left join `user` "
                + " on fkUser = pkUser "
                + " where pkUser = ?;";

        System.out.println(sql);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userId);

            ResultSet res = ps.executeQuery();

            while (res.next()) {
                BorrowBookBean bean = new BorrowBookBean();
                bean.setPkBorrowBook(res.getString("pkBorrowBook"));
                bean.setFromDate(res.getString("fromDate"));
                bean.setToDate(res.getString("todate"));
                bean.setFkUser(res.getString("username"));
                bean.setFkBook(res.getString("name"));
                books.add(bean);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(conn);
        }
        return books;
    }
}
