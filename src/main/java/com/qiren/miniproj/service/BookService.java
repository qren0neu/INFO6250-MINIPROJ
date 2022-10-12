package com.qiren.miniproj.service;

import java.util.List;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.dao.BookDAO;

public class BookService {

	private BookDAO bookdao = new BookDAO();

	private BookService() {

	}

	public List<BookBean> getBookList() {
		return bookdao.getBookList();
	}

	public boolean addNewBook(BookBean book) {
		if (null == bookdao.getBook(book.getISBN())) {
			bookdao.createBook(book);
			return true;
		}
		return false;
	}

	public static BookService getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		static BookService instance;
	}

}
