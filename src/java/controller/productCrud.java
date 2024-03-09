/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
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
import model.product;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "crudProduct", urlPatterns = {"/crudp"})
public class productCrud extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet crudProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet crudProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        productDAO d = new productDAO();
        String key = request.getParameter("key1");

//          productDAO d = new productDAO();
        List<String> list5 = d.thongke();
        
        if(key==null){
            key="";
        }
        List<product> list = d.getAllProductSearch(key.trim());
// request.setAttribute("search", key);
        int page, numberPage = 6;
        int size = list.size();
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
        List<product> list1 = d.getListByPage(list, s, e);

        request.setAttribute("list", list1);
        request.setAttribute("list5", list5);

        request.setAttribute("search", key);
        request.setAttribute("num", num);
        request.setAttribute("so", size);
        request.setAttribute("page", page);

        request.getRequestDispatcher("productCrud.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
