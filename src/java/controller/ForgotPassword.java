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
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.account;

/**
 *
 * @author Truong cun
 */
@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgot"})
public class ForgotPassword extends HttpServlet {

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
            out.println("<title>Servlet ForgotPassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPassword at " + request.getContextPath() + "</h1>");
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

        String user = request.getParameter("user");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (user.isEmpty() && email.isEmpty() && phone.isEmpty()) {
            user = "";
            email = "";
            phone = "";
        }

        AccountDAO d = new AccountDAO();
        List<account> list = d.forgotPass(user, email, phone);
        request.setAttribute("list", list);
        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO d = new AccountDAO();
        String user = request.getParameter("user");
         String email = request.getParameter("email");
        String phone = request.getParameter("phone");
       String NewPass =d.randomPass();
       account a = d.acc(user);
        account a1 = new account(a.getUsername(),NewPass );
        d.updatePass(a1);
        
        
            String accountMail = "truongvxhe176609@fpt.edu.vn";
        String pass = "dggb ldmk izqs gkes";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountMail, pass);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session1);
            message.setFrom(new InternetAddress(accountMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(a.getEmail()));
            message.setSubject("Your new password");
            StringBuilder sb = new StringBuilder();
				
				
            message.setContent("<h3 style=\"font-family: cursive; color: green; display :inline\" > New Password </h3> : "+NewPass+"<br>"
                    + "<h2> <a href=\"http://localhost:9999/prj301/ChangePass.jsp\">Click to change password</a> </h2>", "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        String mas = a.getEmail().substring(0,4); 
        String mas1 = a.getEmail().substring(a.getEmail().length()-4);
        String ok ="Check your email "+mas+"********"+mas1;
        request.setAttribute("mas", ok);
       
        
        request.getRequestDispatcher("login.jsp").forward(request, response);

        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
