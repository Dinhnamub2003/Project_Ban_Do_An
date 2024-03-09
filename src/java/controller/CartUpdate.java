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
@WebServlet(name = "CartUpdate", urlPatterns = {"/cartupdate"})
public class CartUpdate extends HttpServlet {

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
            String user = request.getParameter("user");

            int id = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            productDAO d = new productDAO();
            product p = d.getAllProduct(id);
            HttpSession session = request.getSession();
            Map<Integer, newCart> carts = (Map<Integer, newCart>) session.getAttribute("carts"); //lấy giá trị map đã lưu trong session trước đó
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }

            if (carts.containsKey(id)) {
                if (quantity <= 0) {
                    carts.remove(id);
                } else {
                    if (quantity > p.getQuantity()) {
                        carts.get(id).setQuantity(1);

                    } else {
                        carts.get(id).setQuantity(quantity);
                    }

// set lại số lượng
                }
            }
            //Tự động Map trên session set lại
            session.setAttribute("carts", carts);
            if (user != null) {
            response.sendRedirect("cart?user="+user);

            } else {
                response.sendRedirect("cart");
//
            }
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
        processRequest(request, response);
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
