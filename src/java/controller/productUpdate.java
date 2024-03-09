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
import model.product;
import model.typeproduct;

@WebServlet(urlPatterns = {"/updatep"})
public class productUpdate extends HttpServlet {

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
            out.println("<title>Servlet updateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        DAO d = new DAO();
        List<typeproduct> list = d.getAllcat();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            productDAO c = new productDAO();
            product cc = c.getProductNewWay(id);
            request.setAttribute("allcat", list);

            request.setAttribute("updatepro", cc);
            request.getRequestDispatcher("productUpdate.jsp").forward(request, response);

        } catch (NumberFormatException e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String key = request.getParameter("key1");

        if(key==null){
            key="";
        }
        String images = request.getParameter("images");
        String date = request.getParameter("dateupdate");
//        String page = request.getParameter("dateupdate");
        productDAO d = new productDAO();
//        List<product> list = d.getAllProductVIP();
//        int size = list.size();

        try {
            int idp = Integer.parseInt(request.getParameter("typeproduct"));
            int id = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int viewed = Integer.parseInt(request.getParameter("viewed"));
            double price = Double.parseDouble(request.getParameter("price"));
        int num = ((id-1) % 6 == 0 ? ((id-1) / 6) : (((id-1) / 6) + 1));

//          
            d.updateProduct(id, name, describe, price, images, date, idp, quantity, viewed);
            response.sendRedirect("crudp?page="+num+"&key1="+key);
//            request.getRequestDispatcher("crudp?page="+num+"&key1="+key).forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
