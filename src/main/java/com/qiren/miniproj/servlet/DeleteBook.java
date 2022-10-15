package com.qiren.miniproj.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qiren.miniproj.manager.ServletManager;
import com.qiren.miniproj.service.BookService;
import com.qiren.miniproj.tools.Constants;

/**
 * Servlet implementation class DeleteBook
 */
public class DeleteBook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook() {
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
        if (!ServletManager.getInstance().refererCheck(request, response)) {
            return;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // doGet(request, response);
        String confirm = request.getParameter("confirm");
        String bookId = request.getParameter(Constants.PARAM_BOOK_ID);
        if (null != confirm) {
            // delete
            BookService.getInstance().deleteBook(bookId);
            response.sendRedirect("controller?action=dashboard");
        } else {
            // warning
            request.setAttribute("value", bookId);
            request.setAttribute("key", Constants.PARAM_BOOK_ID);
            request.setAttribute("action", "deleteBook");
            request.setAttribute("warn", "It is not revertable to delete a book");
            request.getRequestDispatcher(Constants.PAGE_WARNING).forward(request, response);
        }
    }

}
