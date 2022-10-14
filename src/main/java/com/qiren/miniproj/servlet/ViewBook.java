package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.bean.BookBean;
import com.qiren.miniproj.service.BookService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class ViewBook
 */
public class ViewBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        String bookId = request.getParameter(Constants.PARAM_BOOK_ID);

        if (null == bookId || bookId.isBlank()) {
            request.setAttribute(Constants.PARAM_ERROR, "No book selected");
            request.getRequestDispatcher(Constants.PAGE_FAILED).forward(request, response);
            return;
        }

        BookBean bb = BookService.getInstance().getBook(bookId);

        request.setAttribute(Constants.PARAM_BOOK_BEAN, bb);
        request.getRequestDispatcher(Constants.PAGE_VIEW_BOOK).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
