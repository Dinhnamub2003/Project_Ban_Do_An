/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.productDAO;
import dal.shipperDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.account;
import model.shipper;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "shipCrud", urlPatterns = {"/cruds"})
public class shipCrud extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet shipCrud</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shipCrud at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
 productDAO d = new productDAO();
        List<String> list = d.thongke();
        List<shipper> list1 = d.topSeller();
        List<account> list2 = d.OrderRecent();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        shipperDAO d1 = new shipperDAO();
        List<shipper> list3 = d1.getAll();
        List<shipper> list4 = d1.Count();
        
        request.setAttribute("list2", list3);
        request.setAttribute("list3", list4);
        request.getRequestDispatcher("topShiper.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
