/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import model.account;
import model.newCart;
import model.order;
import model.orderdetail;

/**
 *
 * @author Truong cun
 */
public class orderDAO extends DBContext {

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public List<account> getOrder(int id) {
        List<account> list = new ArrayList<>();
        String sql = "select o.orderdate , a.realname , p.name as namep , p.price as pricep, o1.quantity as quantityOrder ,o1.total\n"
                + ",a.phone ,a.address from [order] o join orderdetail o1 on o.id =o1.orderid "
                + "join product p on o1.productid = p.id join account a on a.id = o.accountid where o.id = ?";
//        double money = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                double a1 = rs.getDouble("total");
                String b = df.format(a1);
                double a2 = rs.getDouble("pricep");
//                money += a2;

                String b2 = df.format(a2);

                account g = new account(id, rs.getString("orderdate"), rs.getString("realname"), rs.getString("namep"), b2,
                        rs.getString("quantityOrder"), b, rs.getString("phone"), rs.getString("address"));

                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<account> getOrderAccount(int id) {
        List<account> list = new ArrayList<>();
        String sql = "select p.images, p.name as namep, p.price as pricep, o1.quantity as numberOrder , o1.total , o.orderdate  from [order] o join orderdetail o1 on o.id =o1.orderid \n"
                + "join product p on o1.productid = p.id join account a on a.id = o.accountid where a.id =?";
//        double money = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                double a1 = rs.getDouble("total");
                String b = df.format(a1);
                double a2 = rs.getDouble("pricep");
//                money += a2;

                String b2 = df.format(a2);

                account g = new account(rs.getString("images"), rs.getString("namep"), b2, rs.getString("numberOrder"),
                        b, rs.getString("orderdate"));

                list.add(g);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int gethighestID() {
        List<order> list = new ArrayList<>();
        String sql = "select top 1 * from [order]\n"
                + "order by id desc";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                order p = new order(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                list.add(p);
                a = list.get(0).getId();
                a++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return a;
    }

    public int gethighestOrderDetailID() {
        List<orderdetail> list = new ArrayList<>();
        String sql = "select top 1 * from orderdetail\n"
                + "order by id desc";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                orderdetail p = new orderdetail(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7));

                list.add(p);

                a = list.get(0).getId();
                a++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return a;
    }

    public void addOrder(account a, double total, Map<Integer, newCart> carts) {
        String sql = "INSERT INTO [dbo].[order]\n"
                + "           ([id]\n"
                + "           ,[total]\n"
                + "           ,[address]\n"
                + "           ,[orderdate]\n"
                + "           ,[orderdelivery]\n"
                + "           ,[accountid]\n"
                + "           ,[staffid]\n"
                + "           ,[shipperid])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        staffDAO sf= new staffDAO();
        int maximum = sf.gethightestIdstaff()-1;
        int maximum2 = 3;
        int minimum = 1;
        LocalDate cur = LocalDate.now();
        String date = cur.toString();
        orderDAO d = new orderDAO();
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int range2 = maximum2 - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        int randomNum2 = rn.nextInt(range2) + minimum;
        int orderid = d.gethighestID();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderid);
            st.setDouble(2, total);
            st.setString(3, a.getAddress());
            st.setString(4, date);
            st.setString(5, date);
            st.setInt(6, a.getId());
            st.setInt(7, randomNum);
            st.setInt(8, randomNum2);
            st.executeUpdate();

            String sql2 = "INSERT INTO [dbo].[orderdetail]\n"
                    + "           ([id]\n"
                    + "           ,[productid]\n"
                    + "           ,[orderid]\n"
                    + "           ,[quantity]\n"
                    + "           ,[price]\n"
                    + "           ,[total]\n"
                    + "           ,[note])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
                   PreparedStatement st2 = connection.prepareStatement(sql2);
                   st2.setInt(3, orderid);
            for (Map.Entry<Integer, newCart> entry : carts.entrySet()) {
//                Integer productId = entry.getKey();
                newCart c = entry.getValue();
                st2.setInt(1, d.gethighestOrderDetailID());
                st2.setInt(2, c.getProduct().getId());
                st2.setInt(4, c.getQuantity());
                st2.setDouble(5, c.getProduct().getPrice());
                st2.setDouble(6, c.getQuantity()*c.getProduct().getPrice());
                st2.setString(7, "okhaha");
                
                d.updateQuantity(c.getProduct().getId(), c.getProduct().getQuantity()-c.getQuantity());
                
                st2.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public void updateQuantity(int id , int quantity){
        String sql = "update product set quantity = ? where id =?";
        try {
            PreparedStatement st= connection.prepareCall(sql);
            st.setInt(1, quantity);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    } 
    
    
    
    public static void main(String[] args) {
        orderDAO d = new orderDAO();
//        System.out.println(d.getOrder(3).get(0).getRole());

        System.out.println(d.gethighestOrderDetailID());
    }

}
