/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.DAO;
import dal.productDAO;
import dal.reviewDAO;
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
import model.product;
import model.review;

@WebServlet(name = "detailProduct", urlPatterns = {"/detail"})
public class productDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet detailProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet detailProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        productDAO p = new productDAO();
        DAO d = new DAO();
        List<review> list = new ArrayList<>();
        String user = request.getParameter("user");
        reviewDAO f = new reviewDAO();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            product a = p.getAllProduct(id);
            list = f.getReviewByProductID(id);
            p.updateView(id);
            String g = p.viewproduct(id);
            request.setAttribute("view", g);
//            list = d.getOldProduct();
            request.setAttribute("detail", a);
            request.setAttribute("user1", user);
            request.setAttribute("review", list);

//            request.setAttribute("oldproduct", list);
            request.getRequestDispatcher("productDetail.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        reviewDAO d = new reviewDAO();
        String user = request.getParameter("user");

        AccountDAO a = new AccountDAO();
        account cc = a.acc(user);
        if (cc == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        review v = new review(content, cc, id);

        d.addReview(v);
        response.sendRedirect("detail?id=" + id + "&user=" + user);

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
