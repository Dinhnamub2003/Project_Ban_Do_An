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
import java.util.List;
import model.account;
import model.shipper;

/**
 *
 * @author Truong cun
 */
@WebServlet(name="getView", urlPatterns={"/topview"})
public class thongkeView extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getView</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getView at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        productDAO d = new productDAO();

//         productDAO d = new productDAO();
        List<String> list = d.thongke();
        List<shipper> list1 = d.topSeller();
//        List<account> list2 = d.OrderRecent();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        
        request.setAttribute("view1",  d.getView(1));
        request.setAttribute("view2",  d.getView(2));
        request.setAttribute("view3",  d.getView(3));
        request.setAttribute("view4", d.getView(4));
        request.setAttribute("view5", d.getView(5));
        request.setAttribute("view6", d.getView(6));
        request.setAttribute("view7", d.getView(7));
        request.setAttribute("view8",  d.getView(8));
        request.setAttribute("view9",  d.getView(9));
        
        request.getRequestDispatcher("thongkeView.jsp").forward(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
