/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDAO;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.account;

/**
 *
 * @author Truong cun
 */
@WebServlet(name="ChangePass", urlPatterns={"/change"})
public class ChangePass extends HttpServlet {
   
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
            out.println("<title>Servlet ChangePass</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePass at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
          String u = request.getParameter("user");
          String op = request.getParameter("oldpass");
          String np = request.getParameter("newpass");
          
          DAO d =new DAO();
          AccountDAO m = new AccountDAO();
          account a= m.check(u, op);
          if(a==null){
              request.setAttribute("error", "username or pass wrong");
              request.getRequestDispatcher("ChangePass.jsp").forward(request, response);
          }else{
//               AccountDAO ac = new AccountDAO();
//            account ab = m.acc(u);
            account g = new account(a.getId(), a.getUsername(), np,
                    a.getRealname(), a.getPhone(),
                    a.getEmail(), a.getAddress(), a.getAvatar(), a.getRole());
              
//              account b = new account(u, np, a.getRole());
              m.change(g);
              HttpSession s = request.getSession();
              s.setAttribute("account", g);
              response.sendRedirect("home");
              
          }
          

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
