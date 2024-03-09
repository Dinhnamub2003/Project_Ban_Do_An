/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.account;
import model.shipper;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "managerProduct", urlPatterns = {"/manager"})
public class managerProduct extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet managerProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet managerProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        productDAO d = new productDAO();
        List<String> list = d.thongke();
        List<shipper> list1 = d.topSeller();
        List<account> list2 = d.OrderRecent();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);

        int page, numberPage = 10;
        int size = list2.size();
        int num = (size % numberPage == 0 ? (size / numberPage) : ((size / numberPage) + 1));
        String xpage = request.getParameter("page");

        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int e;
        int s;

        s = (page - 1) * numberPage;

        e = Math.min(page * numberPage, size);
        List<account> list3 = d.getList1ByPage1(list2, s, e);

        request.setAttribute("list3", list3);
        request.setAttribute("num", num);
        request.setAttribute("so", size);
        request.setAttribute("page", page);
        request.getRequestDispatcher("managerProduct.jsp").forward(request, response);

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
