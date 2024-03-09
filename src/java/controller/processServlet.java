/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.cartDAO;
import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.cart;
import model.item;
import model.product;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "processServlet", urlPatterns = {"/process"})
public class processServlet extends HttpServlet {

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
            out.println("<title>Servlet processServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet processServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        productDAO d = new productDAO();
        List<product> list = d.getAllProductVIP();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        
        
        cart c = new cart(txt, list);
        
        
        
        try {
            
            int num = Integer.parseInt(request.getParameter("num"));
            int id = Integer.parseInt(request.getParameter("id"));
            product p = d.getAllProduct(id);
              int numberStore = p.getQuantity();
            if ((num == -1) && (c.getQuantityByID(id) <= 1)) {
                c.removeItem(id);
            } else {
                if (num == 1 && (c.getQuantityByID(id) >= numberStore)) {
                    num = 0;
                }
                double price = p.getPrice();
                item t = new item(p, num, price);
                c.addItem(t);
            }
            

          
           
        } catch (NumberFormatException e) {
        }
        
         List<item> items = c.getItems();
            txt = "";
            if (items.size() > 0) {
                txt = items.get(0).getProduct().getId()
                        + ":" + items.get(0).getQuantity();

                for (int i = 1; i < items.size(); i++) {
                    txt += "," + items.get(i).getProduct().getId() + ":"
                            + items.get(i).getQuantity();

                }
            }
            Cookie cc = new Cookie("cart", txt);
            cc.setMaxAge(2*60*60*24);
            request.setAttribute("cart", cc);
            request.getRequestDispatcher("cart.jsp").forward(request, response);

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
