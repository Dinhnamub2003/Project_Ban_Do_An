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
import model.account;
import model.category;
import model.product;
import model.typeproduct;

/**
 *
 * @author Truong cun
 */
public class cartDAO extends DBContext {

    public account getAccount(String user, String pass) {
        String sql = "select * from account where username=? and password =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
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

    public List<product> getAllProduct() {
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

    public product getAllProductById(int id) {
//        List<product> list = new ArrayList<>();
        String sql = "select d.id , d.name , describe , price, images, dateupdate , quantity , viewed ,t.id as tid ,  t.name as tname , c.id as cid , c.name as cname   from product d\n"
                + "join typeproduct t on d.idtypeproduct = t.id join category c on t.categoryid=c.id where d.id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                category c = new category(rs.getInt("cid"), rs.getString("cname"));
                typeproduct t = new typeproduct(rs.getInt("tid"), rs.getString("tname"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), t, rs.getInt("quantity"), rs.getInt("viewed"));
//
//                list.add(p);
                return p;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) {
        cartDAO d = new cartDAO();
        System.out.println(d.getAccount("admin", "123").getRealname());

    }

}
