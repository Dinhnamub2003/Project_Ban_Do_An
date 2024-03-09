/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.account;
import model.category;
import model.product;
import model.typeproduct;

public class AccountDAO extends DBContext {

    public void register(account a) {
        String sql = "insert into account (id, username , password,role) values(?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getId());
            st.setString(2, a.getUsername());
            st.setString(3, a.getPassword());
            st.setString(4, "user");

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public void updatePro5(account a) {
        String sql = "UPDATE [dbo].[account]\n"
                + "   SET realname = ?"
                + "      ,phone = ?"
                + "      ,email = ?"
                + "      ,address = ?"
                + "      ,avatar =?"
                + " WHERE username=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getRealname());
            st.setString(2, a.getPhone());
            st.setString(3, a.getEmail());
            st.setString(4, a.getAddress());
            st.setString(5, a.getAvatar());
            st.setString(6, a.getUsername());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    public void updatePass(account a) {
        String sql = "UPDATE [dbo].[account]\n"
                + "   SET password = ?"
              
                + " WHERE username=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUsername());
           
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public account acc(String user) {
        String sql = "select * from account where username =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address"),
                        rs.getString("avatar"),
                        rs.getString("role"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<account> forgotPass(String user, String mail, String phone) {
        List<account> list = new ArrayList<>();

        String sql = "select * from account where 1=1 ";

        if (user != null) {
            if (user.equals("")) {

            } else {
                sql += " and username = '" + user + "'";
            }

        }
        if (mail != null) {

            if (mail.equals("")) {

            } else {
                sql += " and email = '" + mail + "'";

            }

        }
        if (phone != null) {

            if (phone.equals("")) {

            } else {
                sql += " and phone = '" + phone + "'";

            }

        }
        if (user.equals("") && phone.equals("") && mail.equals("")) {
            sql = "";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                account b = new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address"),
                        rs.getString("avatar"),
                        rs.getString("role"));
                list.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public account acc1(int id) {
        String sql = "select * from account where id =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address"),
                        rs.getString("avatar"),
                        rs.getString("role"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void change(account a) {
        String sql = "update account set password=? where username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int idincre() {
        List<account> list = new ArrayList<>();
        int a = 10;
        String sql = "select top 1  * from account order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
//                private int id;
//private String username ,password , realname,phone ,email,adress,avatar, role;
                account b = new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address"),
                        rs.getString("avatar"),
                        rs.getString("role"));
                list.add(b);
                a = list.get(0).getId();
                a++;
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }

    public boolean checkexits(String u) {
        String sql = "select * from account where username =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
//                return new account(u, rs.getString("password"), rs.getInt("role"));
                return true;
            }
        } catch (SQLException e) {
        }

        return false;
    }

//    public void highestID(){
//        String sql = "select top 1 * from account order by id desc ";
//        try {
//            PreparedStatement st =connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            if(rs.next()){
//                account a = new account
//            }
//        } catch (Exception e) {
//        }
//    }
    public account check(String u, String p) {
        String sql = "select * from account where username =? and password =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new account(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("realname"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address"),
                        rs.getString("avatar"),
                        rs.getString("role"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

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

    public List<account> getAll() {
        List<account> list = new ArrayList<>();
        String sql = "select a.id as aid , realname, phone, email , a.address as ads , COUNT(o.id) as NumberPurchase from account a join [order] o on o.accountid = a.id \n"
                + "group by  a.id  , realname, phone, email , a.address\n"
                + "order by  COUNT(o.id) desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                account a = new account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String randomPass() {

        int maximum = 122;
        int minimum = 1;

        Random rn = new Random();
        String pass = "";
        int range = maximum - minimum;

      while(true){
          
            int randomNum = rn.nextInt(range) + minimum;
            if (randomNum >= 65 && randomNum <90 || randomNum >= 97 && randomNum <=122) {
                char a = (char) randomNum;
                pass += a;
            } else if (randomNum < 10) {
                pass += randomNum;
            }
            
            if(pass.length()==10){
                break;
            }
        }

      
      
        return pass;
    }

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
//        System.out.println(a.forgotPass("", "kiby@gmaiil.com").size());
System.out.println(a.randomPass());
    }

}
