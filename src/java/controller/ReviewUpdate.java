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

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "ReviewUpdate", urlPatterns = {"/reviewup"})
public class ReviewUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//          String user = request.getParameter("user");
//
//        AccountDAO a = new AccountDAO();
//        account cc = a.acc(user);
//        int id = Integer.parseInt(request.getParameter("reviewid"));
//        reviewDAO d = new reviewDAO();
//        int idp = Integer.parseInt(request.getParameter("id"));
//        
        productDAO p = new productDAO();
        DAO d = new DAO();
        List<review> list = new ArrayList<>();
        String user = request.getParameter("user");
        reviewDAO f = new reviewDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));
        product a = p.getAllProduct(id);
        list = f.getReviewByProductID(id);

//            list = d.getOldProduct();
        request.setAttribute("detail", a);
        request.setAttribute("user1", user);
        request.setAttribute("review", list);
        
        int id1 = Integer.parseInt(request.getParameter("reviewid"));
        
        reviewDAO r = new reviewDAO();
        review a1 = r.getID(id);
        request.setAttribute("list", a1);
        request.setAttribute("user", user);
        request.setAttribute("reviewid", id1);
        request.getRequestDispatcher("productDetailUpdate.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        
        AccountDAO a = new AccountDAO();
        account cc = a.acc(user);
        
        int id = Integer.parseInt(request.getParameter("reviewid"));
        reviewDAO d = new reviewDAO();
        int idp = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        if (cc == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }
        
        reviewDAO r = new reviewDAO();
        review v = new review(id, content, cc, id);
        r.updateReview(v);
        response.sendRedirect("detail?id=" + idp + "&user=" + user);
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
