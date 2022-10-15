package com.qiren.miniproj.service;

import java.text.SimpleDateFormat;
import java.util.List;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.bean.BorrowBookBean;
import com.qiren.miniproj.dao.BorrowBookDAO;
import com.qiren.miniproj.manager.SessionManager;
import com.qiren.miniproj.tools.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BorrowBookService {

    private BorrowBookDAO borrowBookDAO = new BorrowBookDAO();

    private BorrowBookService() {

    }

    public String borrowBook(HttpServletRequest request,
            HttpServletResponse response) {
        // check availability
        String bookId = request.getParameter(Constants.PARAM_BOOK_ID);
        if (null == bookId) {
            return "Book not selected";
        }
        BookBean bookBean = BookService.getInstance().getBook(bookId);
        if (null == bookBean) {
            return "Book not found";
        }
        String stock = bookBean.getInstock();
        int stockInt = Integer.parseInt(stock);
        if (stockInt <= 0) {
            return "No book available now";
        }
        BorrowBookBean borrowHistory = borrowBookDAO.findBorrowByBookNotReturn(bookId);
        // find if this book is borrowed and not returned
        if (null != borrowHistory) {
            return "You have borrowed this book and not returned";
        }
        BorrowBookBean borrowBookBean = new BorrowBookBean();
        borrowBookBean.setFkBook(bookId);
        borrowBookBean.setFkUser(SessionManager.getInstance().getUserId(request));

        if (!borrowBookDAO.addToBorrow(borrowBookBean)) {
            return "Borrow failed";
        }
        bookBean.setInstock("" + (stockInt - 1));
        BookService.getInstance().updateBook(bookBean);
        // return error message, null means no error
        return null;
    }
    
    public List<BorrowBookBean> getBorrowList(HttpServletRequest request,
            HttpServletResponse response) {
        List<BorrowBookBean> borrowList;
        if (Constants.ROLE_STAFF.equals(SessionManager.getInstance().getRole(request))) {
            borrowList = borrowBookDAO.getBorrowList();
        } else {
            borrowList = borrowBookDAO.getBorrowListByUser(
                    SessionManager.getInstance().getUserId(request));
        }
        return borrowList;
    }

//    public String returnBook(HttpServletRequest request,
//            HttpServletResponse response) {
//        
//    }

    public static BorrowBookService getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        static BorrowBookService instance = new BorrowBookService();
    }
}
