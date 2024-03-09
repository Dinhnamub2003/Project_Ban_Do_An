/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.orderDAO;
import dal.productDAO;
import dal.staffDAO;
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
import model.staff;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "updateStaff", urlPatterns = {"/staffu"})
public class updateStaff extends HttpServlet {

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
            out.println("<title>Servlet updateStaff</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateStaff at " + request.getContextPath() + "</h1>");
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
        productDAO d = new productDAO();
        List<String> list = d.thongke();
        List<shipper> list1 = d.topSeller();

        String id_war = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(id_war);
            request.setAttribute("list", list);
            request.setAttribute("list1", list1);
            staffDAO d1 = new staffDAO();
            account a = d1.getStaffID(id);

            request.setAttribute("top", a);

            request.getRequestDispatcher("staffUpdate.jsp").forward(request, response);
        } catch (Exception e) {
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
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        
        int id = Integer.parseInt(request.getParameter("id"));

        staff s = new staff(id, name, phone, email, birth, country);

        staffDAO d = new staffDAO();
        d.updateStaff(s);
        response.sendRedirect("top3satff");
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
