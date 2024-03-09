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
import java.util.List;
import model.product;
import model.typeproduct;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "productAdd", urlPatterns = {"/producta"})
public class productAdd extends HttpServlet {

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
            out.println("<title>Servlet productAdd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productAdd at " + request.getContextPath() + "</h1>");
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
        DAO d = new DAO();
        productDAO a = new productDAO();
        int id = a.getHighestID();
        List<typeproduct> list = d.getAllcat();
        request.setAttribute("allcat", list);
        request.setAttribute("highest", id);

        request.getRequestDispatcher("productAdd.jsp").forward(request, response);
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

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String describe = request.getParameter("describe");

        String images = request.getParameter("images");
        String date = request.getParameter("dateupdate");

            int id = Integer.parseInt(request.getParameter("id"));

            int idp =  Integer.parseInt(request.getParameter("typeproduct"));
//                          processRequest(request, response);
//System.out.println(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int viewed = Integer.parseInt(request.getParameter("viewed"));
            double price = Double.parseDouble(request.getParameter("price"));

            productDAO d = new productDAO();
            int a=( (id-4)%6==0?((id-4)/6):((id-4)/6)+1);
//            DAO k = new DAO();
//            category h = new category();
//            typeproduct e1 = k.getTypeProduct(idp);
//            typeproduct e = new typeproduct(idp, e1.getName(), e1.getCategoryid());
//
//            product c = new product(id, name, describe, price, images, date,
//                    e, quantity, viewed);

            d.addProduct(id, name, describe, price, images, date, idp, quantity, viewed);
            response.sendRedirect("crudp?page="+a);
            

       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
