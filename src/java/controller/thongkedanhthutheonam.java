package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dal.DAO;
import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.shipper;

/**
 *
 * @author Truong cun
 */
@WebServlet(urlPatterns={"/doanhthutheonam"})
public class thongkedanhthutheonam extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet thongkedanhthutheonam</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet thongkedanhthutheonam at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       DAO dao = new DAO();
               double a= dao.totalMoneyYear(2023);
               double b= dao.totalMoneyYear(2022);
               double c= dao.totalMoneyYear(2021);
               double d= dao.totalMoneyYear(2020);
               double e= dao.totalMoneyYear(2019);
               double f= dao.totalMoneyYear(2018);
               
               request.setAttribute("a", a);
               request.setAttribute("b", b);
               request.setAttribute("c", c);
               request.setAttribute("d", d);
               request.setAttribute("e", e);
               request.setAttribute("f", f);
               
                productDAO d1 = new productDAO();

        List<String> list = d1.thongke();
        List<shipper> list1 = d1.topSeller();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
               request.getRequestDispatcher("thongkedoanhthutheonam.jsp").forward(request, response);
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
         DAO dao = new DAO();
               double a= dao.totalMoneyYear(2023);
               double b= dao.totalMoneyYear(2022);
               double c= dao.totalMoneyYear(2021);
               double d= dao.totalMoneyYear(2020);
               double e= dao.totalMoneyYear(2019);
               double f= dao.totalMoneyYear(2018);
               
               request.setAttribute("a", a);
               request.setAttribute("b", b);
               request.setAttribute("c", c);
               request.setAttribute("d", d);
               request.setAttribute("e", e);
               request.setAttribute("f", f);
               
        
          productDAO d1 = new productDAO();

        List<String> list = d1.thongke();
        List<shipper> list1 = d1.topSeller();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);

        String chart = request.getParameter("chart");
        if (chart == null) {
            chart = "line";
        }
     
        request.setAttribute("chart", chart);
                       request.getRequestDispatcher("thongkedoanhthutheonam.jsp").forward(request, response);

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
