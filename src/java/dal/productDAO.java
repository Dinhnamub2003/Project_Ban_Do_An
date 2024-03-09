/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.account;
import model.category;
import model.product;
import model.shipper;
import model.typeproduct;

/**
 *
 * @author Truong cun
 */
public class productDAO extends DBContext {

    public product getAllProduct(int id) {
        String sql = "select * from product where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);

                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<product> getListByPage(List<product> list, int s, int e) {
        ArrayList<product> a = new ArrayList<>();
        for (int i = s; i < e; i++) {
            a.add(list.get(i));
        }
        return a;
    }

    public void updateView(int id) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET [viewed] = viewed +1\n"
                + " WHERE id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("");
        }
    }

    public String viewproduct(int id) {
        String sql = "select viewed  from product where id = ?";
        int a = 0;
        String c = "";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                a = rs.getInt("viewed");
                c = String.format("%06d", a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
    }

//    public 
    public List<product> getAllProductVIP() {
        List<product> list = new ArrayList<>();
        String sql = "select d.id , d.name , describe , price, images, dateupdate , quantity , viewed ,t.id as tid ,  t.name as tname , c.id as cid , c.name as cname   from product d\n"
                + "join typeproduct t on d.idtypeproduct = t.id join category c on t.categoryid=c.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                typeproduct t = new typeproduct(rs.getInt("tid"), rs.getString("tname"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), t, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<product> getAllProductSearch(String key) {
        List<product> list = new ArrayList<>();
        String sql = "select d.id , d.name , describe , price, images, dateupdate , quantity , viewed ,t.id as tid ,  t.name as tname , c.id as cid , c.name as cname   from product d\n"
                + "join typeproduct t on d.idtypeproduct = t.id join category c on t.categoryid=c.id where 1=1";


        if (key.equalsIgnoreCase("giá tăng") || key.equalsIgnoreCase("price asc")) {
            sql += " ORDER BY d.price";
        } else if (key.equalsIgnoreCase("giá giảm") || key.equalsIgnoreCase("price desc")) {
            sql += " ORDER BY d.price DESC";
        } else if (key.equalsIgnoreCase("id giảm") || key.equalsIgnoreCase("id desc")) {
            sql += " ORDER BY d.id DESC";
        } else if (key.equalsIgnoreCase("id tăng") || key.equalsIgnoreCase("id asc")) {
            sql += " ORDER BY d.id";
        } else if (key.equalsIgnoreCase("date tăng") || key.equalsIgnoreCase("date asc")) {
            sql += " ORDER BY dateupdate";
        } else if (key.equalsIgnoreCase("date giảm") || key.equalsIgnoreCase("date desc")) {
            sql += " ORDER BY dateupdate DESC";
        } else if (key.matches("\\D+")) {

            sql += " and d.name like N'%" + key + "%'" + " or d.describe like N'%" + key + "%'";
        } else if (key.matches("\\d+")) {
            double a = Double.parseDouble(key);

            sql += " and d.id = " + a + " or d.price = " + a + " or t.id = " + a 
                    +" or MONTH(d.dateupdate)="+a +" or  year(dateupdate)="+a+" or day(dateupdate)="+a;
        } else if (key.startsWith("<") && key.matches("<\\d+")) {
            key = key.substring(1);
            double a = Double.parseDouble(key);
            sql += " AND d.price <=" + a;

        } else if (key.startsWith(">") && key.matches(">\\d+")) {
            key = key.substring(1);
            double a = Double.parseDouble(key);
            sql += " AND d.price >=" + a;
        }

        try {

            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1,"'%"+key+"%'" );
//            st.setString(2,"'%"+key+"%'" );
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                typeproduct t = new typeproduct(rs.getInt("tid"), rs.getString("tname"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), t, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public int getView(int id) {
        String sql = "select SUM(viewed) as  luotxem from product d join typeproduct t on t.id = d.idtypeproduct\n" +
"where idtypeproduct =?\n" +
"group by idtypeproduct ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public product getProductNewWay(int id) {
        String sql = "select d.id , d.name , describe , price, images, dateupdate , quantity , viewed ,t.id as tid ,  t.name as tname , c.id as cid , c.name as cname   from product d\n"
                + "join typeproduct t on d.idtypeproduct = t.id join category c on t.categoryid=c.id where d.id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                typeproduct t = new typeproduct(rs.getInt("tid"), rs.getString("tname"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), t, rs.getInt("quantity"), rs.getInt("viewed"));

                return p;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public List<shipper> topSeller() {
        List<shipper> list = new ArrayList<>();
        String sql = "select top 8  p.id as pid, p.name as pname , p.images as img , SUM( o.quantity*p.price)  as total from Product p join orderdetail o on o.productid =p.id join [order] o1 on o1.id = o.orderid\n"
                + "group by  p.id , p.name ,o.quantity , p.images\n"
                + "order by o.quantity desc , total desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                double a = rs.getDouble("total");
                String b = df.format(a);
                shipper d = new shipper(rs.getInt("pid"), rs.getString("pname"), b, rs.getString("img"));
                list.add(d);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<account> getList1ByPage1(List<account> list, int s, int e) {
        ArrayList<account> a = new ArrayList<>();
        for (int i = s; i < e; i++) {
            a.add(list.get(i));
        }
        return a;
    }

    public List<account> OrderRecent() {
        List<account> list = new ArrayList<>();
        String sql = "select o.id as oid,  orderdate ,realname, a.address, total \n"
                + "               from [order] o join account a on a.id = o.accountid order by o.id desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                double a = rs.getDouble("total");
                String b = df.format(a);
                account ac = new account(rs.getInt("oid"), rs.getString("orderdate"), rs.getString("realname"), rs.getString("address"), b);
                list.add(ac);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<String> thongke() {
        List<String> list = new ArrayList<>();
        String sql = "select COUNT(o1.id) as totalOrder ,SUM( o.quantity*p.price) as totalSale , SUM( o.quantity*p.price)*0.3 as totalProfit , sum(o.quantity) as totalProductSold\n"
                + "from Product p join orderdetail o on o.productid =p.id join [order] o1 on o1.id = o.orderid";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                double a = rs.getDouble("totalOrder");

                double b = rs.getDouble("totalSale");
//                String formattedNumber = df.format(b);

                double c = rs.getDouble("totalProfit");
                double d = rs.getDouble("totalProductSold");
                list.add(df.format(a));
                list.add(df.format(b));
                list.add(df.format(c));
                list.add(df.format(d));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addProduct(int id, String name, String describe, double price, String images,
            String dateupdate, int idtypeproduct, int quantity, int viewed) {
        String sql = "INSERT INTO [dbo].[product]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[describe]\n"
                + "           ,[price]\n"
                + "           ,[images]\n"
                + "           ,[dateupdate]\n"
                + "           ,[idtypeproduct]\n"
                + "           ,[quantity]\n"
                + "           ,[viewed])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "            ,?\n"
                + "           ,?\n"
                + "			 ,?\n"
                + "			 ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, describe);
            st.setDouble(4, price);
            st.setString(5, images);
            st.setString(6, dateupdate);
            st.setInt(7, idtypeproduct);
            st.setInt(8, quantity);
            st.setInt(9, viewed);
            st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<product> getAll() {
        List<product> list = new ArrayList<>();
        String sql = "select * from product";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);

                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));
                list.add(p);

//                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void deleteProduct(int id) {
        String sql = "delete product \n"
                + "where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

//    public 
    public void updateProduct(int id, String name, String describe, double price, String images,
            String dateupdate, int idtypeproduct, int quantity, int viewed) {
        String sql = "UPDATE [dbo].[product]\n"
                + "   SET \n"
                + "     [name] =?\n"
                + "      ,[describe] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[images] =?\n"
                + "      ,[dateupdate] =?\n"
                + "      ,[idtypeproduct] = ?\n"
                + "      ,[quantity] =?\n"
                + "      ,[viewed] =?\n"
                + "	  where id =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, describe);
            st.setDouble(3, price);
            st.setString(4, images);
            st.setString(5, dateupdate);
            st.setObject(6, idtypeproduct);
            st.setInt(7, quantity);
            st.setInt(8, viewed);
            st.setInt(9, id);

            st.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getHighestID() {
        List<product> list = new ArrayList<>();
        int a = 10;
        String sql = "select top 1  * from product order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
//                private int id;
//private String username ,password , realname,phone ,email,adress,avatar, role;
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);

                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));
                list.add(p);

                list.add(p);
                a = list.get(0).getId();
                a++;
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }

    public static void main(String[] args) {
        productDAO d = new productDAO();
//        System.out.println(d.getAllProductVIP().get(93).getName());
//        d.updateProduct(109, "cun", "cun", 2, "hmm", "10-10-2023", 2, 3, 4);
//        System.out.println(d.getAll().get(0).getName());
//        System.out.println(d.getAllProductSearch("ngon").get(0).getName());
//        System.out.println(d.getAllProductSearch("").size());
//        System.out.println(d.OrderRecent().get(0).getPhone());
        System.out.println(d.getView(1));

    }

}
