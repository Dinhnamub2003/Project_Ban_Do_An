/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.cartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.cart;
import model.item;
import model.product;
import model.typeproduct;

@WebServlet(name = "home1Servlet", urlPatterns = {"/home1"})
public class home1Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String[] pp = {"DƯỚI 50k", "TỪ 50K đến 100K", "TỪ 100k ĐẾN 500k", "TRÊN 500k"};

        boolean[] pb = new boolean[pp.length + 1];
        DAO d = new DAO();
        
        
        List<typeproduct> type = d.getAllcat();

        boolean[] chid = new boolean[type.size() + 1];
        List<product> products = new ArrayList<>();

        String key = request.getParameter("key");

        String cid_raw = request.getParameter("cid");
        String[] cidd_raw = request.getParameterValues("cidd");
        String[] price = request.getParameterValues("price");
         int cid = 0;

        int[] cidd = null;
        if (cid_raw != null) {
            cid = Integer.parseInt(cid_raw);
            products = d.getProduct(cid);
            if (cid == 0) {
                chid[0] = true;
            }
        }
        if (cidd_raw != null) {
            cidd = new int[cidd_raw.length];
            for (int i = 0; i < cidd.length; i++) {
                cidd[i] = Integer.parseInt(cidd_raw[i]);
            }
//            products = d.searchByKey(key,cidd);

        }
        products = d.searchByKey(key, cidd);

        String price1 = "";
        if (price != null) {
            double from = 0, to = 0;
            for (int i = 0; i < price.length; i++) {
                List<product> temp = new ArrayList<>();
                if (price[i].equals("0")) {
                    from = 0;
                    to = 500000000;
                    products = d.getProductByPrice(from, to);
                    products.addAll(temp);
                    pb[0] = true;
                    break;
                } else {
                    if (price[i].equals("1")) {
                        from = 0;
                        to = 50000;
                        products = d.getProductByPrice(from, to);
                        products.addAll(temp);
                        pb[1] = true;
                        price1 += "price=1&";
                    }

                    if (price[i].equals("2")) {
                        from = 50000;
                        to = 100000;
                        products = d.getProductByPrice(from, to);
                        products.addAll(temp);
                        pb[2] = true;
                        price1 += "price=2&";
                    }

                    if (price[i].equals("3")) {
                        from = 100000;
                        to = 500000;
                        products = d.getProductByPrice(from, to);
                        products.addAll(temp);
                        pb[3] = true;
                        price1 += "price=3&";
                    }
                    if (price[i].equals("4")) {
                        from = 500000;
                        to = 500000000;
                        products = d.getProductByPrice(from, to);
                        products.addAll(temp);
                        pb[4] = true;
                        price1 += "price=4&";
                    }

                }
            }
        }

        if (price1.endsWith("&")) {
            price1 = price1.substring(0, price1.length() - 1);

        }
        
        if (price == null) {
            pb[0] = true;
        }

        if (cid_raw == null) {
            chid[0] = true;
        }
        String ok = "";
        String ok2 = "";
//        int[] cidd1 = new int[10];
        if ((cidd_raw != null) && (cidd[0] != 0)) {
            chid[0] = false;
            for (int i = 1; i < chid.length; i++) {
                if (ischeck(type.get(i - 1).getId(), cidd)) {
                    chid[i] = true;
                    ok += "cidd=" + i + "&";
//                    cidd1[i-1]=i;
                } else {
                    chid[i] = false;

                }

            }
            if (ok.endsWith("&")) {
                ok2 = ok.substring(0, ok.length() - 1);
            }
        }

        List<product> news = d.getNewProduct();
        List<product> sale = d.getOldProduct();

        int page, numberPage = 9;
        int size = products.size();
        int num = (size % 9 == 0 ? (size / 9) : ((size / 9) + 1));
        String xpage = request.getParameter("page");

        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int e;
        int s;

        s = (page - 1) * numberPage;

        e = Math.min(page * numberPage, size);
        List<product> list1 = d.getListByPage(products, s, e);

//               cartDAO dd = new cartDAO();
//       List<product> list = dd.getAllProduct();
       Cookie[] arr=request.getCookies();
       String txt ="";
       if(arr!=null){
           for (Cookie o : arr) {
               if(o.getName().equals("cart")){
                   txt+=o.getValue();
               }
           }
       }
       cart c5 = new cart(txt, list1);
       List<item> listItem = c5.getItems();
       int n;
        if(listItem!=null){
            n = listItem.size();
        }else{
        n=0;
        }
        request.setAttribute("size", n);
        
        
        
        
        request.setAttribute("listPhanTrang", list1);
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("news", news);
        request.setAttribute("sale", sale);
        request.setAttribute("price", price1);
        request.setAttribute("home1", "home1");

        request.setAttribute("data", type);
        request.setAttribute("ok", ok2);
        request.setAttribute("products", products);
        request.setAttribute("pp", pp);
        request.setAttribute("key", key);
        request.setAttribute("pb", pb);
        request.setAttribute("cid", cid);
        request.setAttribute("chid", chid);
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    private boolean ischeck(int d, int[] id) {
        if (id == null) {
            return false;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == d) {
                    return true;
                }
            }
            return false;
        }
    }

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
