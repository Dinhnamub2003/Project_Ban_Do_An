/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.account;
import model.newCart;

/**
 *
 * @author Truong cun
 */
@WebServlet(name="Cartcontroller", urlPatterns={"/cart"})
public class Cartcontroller extends HttpServlet {
   
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
        
        String user = request.getParameter("user");
        AccountDAO h = new AccountDAO();
        account a = h.acc(user);
         HttpSession session = request.getSession();//Lấy danh sách giỏ hàng từ session
            Map<Integer, newCart> carts = (Map<Integer, newCart>) session.getAttribute("carts");
            //lấy giá trị map đã lưu trong session trước đó
            if(carts==null){
                carts = new LinkedHashMap<>();
            }
            
            
            
            //tinh tong tien
            double totalMoney = 0;
            for (Map.Entry<Integer, newCart> entry : carts.entrySet()) {//Duyệt qua các phần tử trong map carts
                Integer productId = entry.getKey();
                newCart cart = entry.getValue();
                
                totalMoney += cart.getQuantity() * cart.getProduct().getPrice();
                
            }
            request.setAttribute("totalMoney", totalMoney); // chuyển request sang JSP
            request.setAttribute("carts", carts);
            request.setAttribute("acc", a);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
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
