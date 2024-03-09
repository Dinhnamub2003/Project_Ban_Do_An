/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.orderDAO;
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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.account;
import model.Email;
import model.EmailUtils;
import model.newCart;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "CartOrder", urlPatterns = {"/cartOrder"})
public class CartOrder extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
//        String email = request.getParameter("email");
        String email = "kibyhunter99@gmail.com";
        String user = request.getParameter("user");
        AccountDAO a = new AccountDAO();
        account aa = a.acc(user);

        HttpSession session = request.getSession();
        Map<Integer, newCart> carts = (Map<Integer, newCart>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }
//tinh tong tien
        double totalPrice = Double.parseDouble(request.getParameter("total"));

    
        
        
        orderDAO o = new orderDAO();
        o.addOrder(aa, totalPrice, carts);
         session.removeAttribute("carts");
        
request.getRequestDispatcher("cart").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
