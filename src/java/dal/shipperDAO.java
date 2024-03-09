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
import model.shipper;

/**
 *
 * @author Truong cun
 */
public class shipperDAO extends DBContext {

    public List<shipper> getAll() {
        List<shipper> list = new ArrayList<>();

        String sql = "select * from shipper";
        try {
//    private int id;
//    private String name;
//    private String phone;
//    private String email;

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                shipper s = new shipper(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public shipper getshipperID(int id) {
//        List<shipper> list = new ArrayList<>();

        String sql = "select * from shipper where id =?";
        try {
//    private int id;
//    private String name;
//    private String phone;
//    private String email;

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                shipper s = new shipper(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int gethighestShipperID() {
        List<shipper> list = new ArrayList<>();
        int a = 0;
        String sql = "select top 1 * from shipper order by id desc";
        try {
//    private int id;
//    private String name;
//    private String phone;
//    private String email;

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                shipper s = new shipper(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"));
                list.add(s);
                a = list.get(0).getId();
                a++;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }

    public List<shipper> Count() {
        List<shipper> list = new ArrayList<>();
        String sql = "select s.id, count(o.id) as number from shipper s  join [order] o on o.shipperid= s.id\n"
                + "group by s.id  ";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                shipper s = new shipper(rs.getInt(1), rs.getString(2));
                list.add(s);
                
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(shipper s) {
        String sql = "UPDATE [dbo].[shipper]\n"
                + "   SET\n"
                + "      [name] =?\n"
                + "      ,[phone] =? \n"
                + "      ,[email] =?\n"
                + " WHERE id= ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getName());
            st.setString(2, s.getPhone());
            st.setString(3, s.getEmail());
            st.setInt(4, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteShipper(int id) {
        String sql = "delete from shipper where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addShipper(shipper s) {
        String sql = "INSERT INTO [dbo].[shipper]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[phone]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "          (?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getId());

            st.setString(2, s.getName());
            st.setString(3, s.getPhone());
            st.setString(4, s.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        shipperDAO d = new shipperDAO();
//        System.out.println(d.getAll().size());
        shipper s = new shipper(4, "Nguyen Van G", "04584354", "shipper2@gmail.com");
//        d.update(s);
//        d.addShipper(s);
//        System.out.println(d.gethighestShipperID());
//d.deleteShipper(4);

    }

}
