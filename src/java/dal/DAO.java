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
public class DAO extends DBContext {

    public List<typeproduct> getAllcat() {
        String sql = "select * from typeproduct";
        List<typeproduct> list = new ArrayList<>();

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));
                typeproduct a = new typeproduct(
                        rs.getInt("id"),
                        rs.getString("name"),
                        c
                );
                list.add(a);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public double totalMoneyMonth(int thang) {
        String sql = "select SUM(total) as total from [order] group by "
                + "MONTH(orderdate) having MONTH(orderdate) =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, thang);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double totalMoneyYear(int nam) {
        String sql = "select SUM(total) as total from [order] group by "
                + "YEAR(orderdate) having YEAR(orderdate) =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, nam);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    
    
    public double totalMoney7(int day) {
        String sql = "select SUM(total) as total from [order] group by DAY(orderdate)\n"
                + "having DAY(orderdate)=GETDATE()";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, day);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public typeproduct getTypeProduct(int id) {
        String sql = "select * from typeproduct where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct t = new typeproduct(rs.getInt("id"),
                        rs.getString("name"),
                        c);

                return t;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<product> getProduct(int id) {
        List<product> l = new ArrayList<>();
        String sql = "select * from product where 1=1";
        if (id != 0) {
            sql += " and idtypeproduct=" + id;
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                l.add(p);

            }
        } catch (SQLException e) {
        }
        return l;
    }

    public List<product> getAllProduct() {
        List<product> l = new ArrayList<>();
        String sql = "select * from product where 1=1";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                l.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return l;
    }

    public List<product> getListByPage(List<product> list, int s, int e) {
        ArrayList<product> a = new ArrayList<>();
        for (int i = s; i < e; i++) {
            a.add(list.get(i));
        }
        return a;
    }

    public List<product> getNewProduct() {
        List<product> list = new ArrayList<>();
        String sql = "select top 4 * from product order by dateupdate desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);

                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<product> getOldProduct() {
        List<product> list = new ArrayList<>();
        String sql = "select top 4 * from product order by dateupdate ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<category> getall() {
        List<category> list = new ArrayList<>();
        String sql = "select * from category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> searchByKey(String key, int[] cid) {
        List<product> list = new ArrayList<>();
        String sql = "SELECT * FROM product d\n"
                + "WHERE 1=1";
        if (cid != null && cid[0] != 0) {
            sql += " and idtypeproduct in(";
            for (int i = 0; i < cid.length; i++) {
                sql += cid[i] + ",";

            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }

        if (key != null) {
            if (key.equalsIgnoreCase("giá tăng") || key.equalsIgnoreCase("price asc")) {
                sql += " ORDER BY d.price";
            } else if (key.equalsIgnoreCase("giá giảm") || key.equalsIgnoreCase("price desc")) {
                sql += " ORDER BY d.price DESC";
            } else if (key.startsWith("<") && key.matches("<\\d+")) {
                key = key.substring(1);
                double a = Double.parseDouble(key);
                sql += " AND d.price <=" + a;

            } else if (key.startsWith(">") && key.matches(">\\d+")) {
                key = key.substring(1);
                double a = Double.parseDouble(key);
                sql += " AND d.price >=" + a;
            } else if (key.matches("\\d+")) {
                double a = Double.parseDouble(key);

                sql += " AND d.price =" + a;

            } else {
                sql += " and d.name LIKE N'%" + key + "%' OR d.describe LIKE N'%" + key + "%'";

            }
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));
                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<product> getProductByPrice(double from, double to) {
        List<product> list = new ArrayList<>();
        String sql = "SELECT * FROM product\n"
                + "WHERE price between ? and ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, from);
            st.setDouble(2, to);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<product> searchByCheck(int[] cid) {
        List<product> list = new ArrayList<>();
        String sql = "SELECT * FROM product\n"
                + "WHERE 1=1";

        if (cid != null && cid[0] != 0) {
            sql += " and idtypeproduct in(";
            for (int i = 0; i < cid.length; i++) {
                sql += cid[i] + ",";

            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category c = new category(rs.getInt("id"), rs.getString("name"));

                typeproduct h = new typeproduct(rs.getInt("id"), rs.getString("name"), c);
                product p = new product(rs.getInt("id"), rs.getString("name"), rs.getString("describe"), rs.getDouble("price"),
                        rs.getString("images"), rs.getString("dateupdate"), h, rs.getInt("quantity"), rs.getInt("viewed"));

                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        DAO d = new DAO();
//        System.out.println(d.getNewProduct().get(0).getId());
        System.out.println(d.totalMoneyYear(2021));
    }

}
