package com.qiren.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.manager.ConnectionManager;

public class BookDAO {

	/**
	 * Get all the books from storage
	 */
	public List<BookBean> getBookList() {
		List<BookBean> bookList = new ArrayList<>();

		Connection connection = ConnectionManager.getConnection();

		String sql = "select * from book";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				BookBean bookBean = new BookBean();
				bookBean.setPkBook(res.getString("pkBook"));
				bookBean.setISBN(res.getString("ISBN"));
				bookBean.setName(res.getString("name"));
				bookBean.setAuthor(res.getString("author"));
				bookBean.setPublisher(res.getString("publisher"));
				bookBean.setInstock(res.getString("instock"));
				bookBean.setDescription(res.getString("description"));
				bookBean.setCoverimg(res.getString("coverimg"));
				bookList.add(bookBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);

		return bookList;
	}

	/**
	 * Get a single book by its ISBN
	 */
	public BookBean getBook(String ISBN) {

		BookBean bookBean = null;

		Connection connection = ConnectionManager.getConnection();

		String sql = "select * from book where ISBN = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, ISBN);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				bookBean = new BookBean();
				bookBean.setPkBook(res.getString("pkBook"));
				bookBean.setISBN(res.getString("ISBN"));
				bookBean.setName(res.getString("name"));
				bookBean.setAuthor(res.getString("author"));
				bookBean.setPublisher(res.getString("publisher"));
				bookBean.setInstock(res.getString("instock"));
				bookBean.setDescription(res.getString("description"));
				bookBean.setCoverimg(res.getString("coverimg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);

		return bookBean;
	}
	
	public BookBean getBookById(String bookId) {

        BookBean bookBean = null;

        Connection connection = ConnectionManager.getConnection();

        String sql = "select * from book where pkBook = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, bookId);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                bookBean = new BookBean();
                bookBean.setPkBook(res.getString("pkBook"));
                bookBean.setISBN(res.getString("ISBN"));
                bookBean.setName(res.getString("name"));
                bookBean.setAuthor(res.getString("author"));
                bookBean.setPublisher(res.getString("publisher"));
                bookBean.setInstock(res.getString("instock"));
                bookBean.setDescription(res.getString("description"));
                bookBean.setCoverimg(res.getString("coverimg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ConnectionManager.closeConnection(connection);

        return bookBean;
    }

	/**
	 * Create a book, regardless of it exists or not. Please make sure check it
	 * before create it.
	 */
	public void createBook(BookBean book) {
		Connection connection = ConnectionManager.getConnection();

		String sql = "insert into book values (?,?,?,?,?,?,?,?)";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, null);
			ps.setString(2, book.getISBN());
			ps.setString(3, book.getName());
			ps.setString(4, book.getAuthor());
			ps.setString(5, book.getPublisher());
			ps.setString(6, book.getDescription());
			ps.setString(7, book.getInstock());
			ps.setString(8, book.getCoverimg());
			
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.closeConnection(connection);
	}

	public void updateBook() {
		Connection connection = ConnectionManager.getConnection();

		ConnectionManager.closeConnection(connection);
	}
}
