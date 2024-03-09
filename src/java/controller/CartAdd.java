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
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.newCart;
import model.product;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "CartAdd", urlPatterns = {"/addcart"})
public class CartAdd extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

//            String cidd = request.get("cidd");
out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet home1Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet home1Servlet at " + request.getContextPath() + "</h1>");
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
                    int id = Integer.parseInt(request.getParameter("id"));// Lấy id sản phẩm thêm vào giỏ hàng
            String user = request.getParameter("user");
            String key = request.getParameter("key");

            //map    productId | cart
            HttpSession session = request.getSession();
            Map<Integer, newCart> carts = (Map<Integer, newCart>) session.getAttribute("carts");
            if (carts == null) { // chưa có sản phẩm nào 
                carts = new LinkedHashMap<>();
            }

            if (carts.containsKey(id)) {//sản phẩm đã có trên giỏ hàng
                int oldQuantity = carts.get(id).getQuantity();
                carts.get(id).setQuantity(oldQuantity + 1);
            } else {//sản phẩm chưa có trên giỏ hàng
                productDAO d = new productDAO();
                product p = d.getAllProduct(id);
                carts.put(id, new newCart(p, 1));//thêm một sản phẩm mới vào trong giỏ hàng
            }
            //lưu carts lên session
            session.setAttribute("carts", carts);
//            String urlHistory = (String) session.getAttribute("urlHistory");
//            if (urlHistory == null) {
//                urlHistory = "home";
//            }
            
            if (user != null && key ==null) {
                response.sendRedirect("detail?id="+id+"&user=" + user);
              

            }else{
                   response.sendRedirect("home");
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
        processRequest(request, response);
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
