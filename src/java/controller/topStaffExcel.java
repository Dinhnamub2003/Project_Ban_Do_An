/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.staffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import model.account;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Truong cun
 */
@WebServlet(name="topStaffExcel", urlPatterns={"/topstaff"})
public class topStaffExcel extends HttpServlet {
   
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
            out.println("<title>Servlet topStaffExcel</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet topStaffExcel at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        
         Date ngayHienTai = new Date();
        
        // Định dạng ngày theo dạng bạn muốn (ví dụ: "dd/MM/yyyy")
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String ngayxuat = sdf.format(ngayHienTai);
        
        
         staffDAO d1=  new staffDAO();
        List<account> list = d1.getAll1();
          int maximum=2147483647;
        int minimum=1;
        
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;

        
//        ExcelMyWeb
        
         FileOutputStream file=new FileOutputStream("C:\\ExcelMyWeb\\"+"Excellent-top-Staff-"+ngayxuat+"-"+Integer.toString(randomNum)+".xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
       
          row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("Name");
        cell1=row.createCell(1);
        cell1.setCellValue("Email");
        cell2=row.createCell(2);
        cell2.setCellValue("BirthDate");
        cell3=row.createCell(3);
        cell3.setCellValue("Country");
        cell4=row.createCell(4);
        cell4.setCellValue("Number Order");
               int i=0;

               
               
//                this.id = id;
//        this.username = username;
//        this.password = password;
//        this.realname = realname;
//        this.phone = phone;
//        this.email = email;
               
               
         for (account pro : list) {
        	i=i+1;
        			 row=workSheet.createRow(i);
        			 cell0=row.createCell(0);
        		     cell0.setCellValue(pro.getUsername());
        		     cell1=row.createCell(1);
        		     cell1.setCellValue(pro.getPassword());
        		     cell2=row.createCell(2);
        		     cell2.setCellValue(pro.getRealname());
        		     cell3=row.createCell(3);
        		     cell3.setCellValue(pro.getPhone());	
        		     cell4=row.createCell(4);
        		     cell4.setCellValue(pro.getEmail());	
        		    
        }
               
        workbook.write(file);
        workbook.close();
        file.close();
          request.setAttribute("mess", "Dowload file successed");
        request.getRequestDispatcher("top3satff").forward(request, response); 
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
