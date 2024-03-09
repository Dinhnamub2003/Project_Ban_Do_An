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
@WebServlet(name = "shipperAdd", urlPatterns = {"/shippera"})
public class shipperAdd extends HttpServlet {

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
            out.println("<title>Servlet shipperAdd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shipperAdd at " + request.getContextPath() + "</h1>");
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
        int id = d1.gethighestShipperID();
        
        request.setAttribute("highest", id);
        request.getRequestDispatcher("shipperAdd.jsp").forward(request, response);
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

// private int id;
//    private String name;
//    private String phone;
//    private String email;
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        shipper s = new shipper(id, name, phone, email);
        shipperDAO d = new shipperDAO();
        d.addShipper(s);
        response.sendRedirect("cruds");
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
