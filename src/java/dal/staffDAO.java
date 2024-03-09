/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.account;
import model.staff;

/**
 *
 * @author Truong cun
 */
public class staffDAO extends DBContext {

    public List<staff> getAll() {
        List<staff> list = new ArrayList<>();
        String sql = "select * from staff";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                staff s = new staff(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"),
                        rs.getString("birthDate"), rs.getString("country"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<account> getAll1() {
        List<account> list = new ArrayList<>();
        String sql = "select s.id as sid , s.name , email , birthDate , country , COUNT(o.id) as NumberOrder ,phone  from staff s left join [order] o on s.id = o.staffid\n" +
"           group by  s.id  , s.name , email , birthDate , country,phone\n" +
"                order by  COUNT(o.id) desc";
        try {
             PreparedStatement st = connection.prepareStatement(sql);
           
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                account a = new account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getString(6),rs.getString(7));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public account getStaffID(int id) {
        String sql = "select s.id as sid , s.name , email , birthDate , country , COUNT(o.id) as NumberOrder ,phone  from staff s left join [order] o on s.id = o.staffid\n" +
"           group by  s.id  , s.name , email , birthDate , country,phone\n" +
" having s.id=?";
        try {
             PreparedStatement st = connection.prepareStatement(sql);
           st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                account a = new account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getString(6),rs.getString(7));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    

    public int gethightestIdstaff() {
        List<staff> list = new ArrayList<>();
        String sql = "select top 1 * from staff order by id desc";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                staff s = new staff(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"),
                        rs.getString("birthDate"), rs.getString("country"));
                list.add(s);
                a = list.get(0).getId();
                a++;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return a;
    }

    public void updateStaff(staff s) {
        String sql = "UPDATE [dbo].[staff]\n"
                + "   SET\n"
                + "      [name] = ?\n"
                + "      ,[phone] =? \n"
                + "      ,[email] = ?\n"
                + "      ,[birthDate] =?\n"
                + "      ,[country] = ?\n"
                + " WHERE id =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getName());
            st.setString(2, s.getPhone());
            st.setString(3, s.getEmail());
            st.setString(4, s.getBirthDate());
            st.setString(5, s.getCountry());
            st.setInt(6, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteStaff(int id) {
        String sql = "delete from staff where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addStaff(staff s) {
        String sql = "INSERT INTO [dbo].[staff]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[birthDate]\n"
                + "           ,[country])\n"
                + "     VALUES\n"
                + "          (?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s.getId());
            st.setString(2, s.getName());
            st.setString(3, s.getPhone());
            st.setString(4, s.getEmail());
            st.setString(5, s.getBirthDate());
            st.setString(6, s.getCountry());

            st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        staffDAO d = new staffDAO();
//        System.out.println(d.getAll().size());
        staff s = new staff(4, "Peter", "05664", "peter@gmuial.com", "2000-09-02", "France");
//        d.updateStaff(s);
//          d.addStaff(s);
//System.out.println(d.gethightestIdstaff());
//d.deleteStaff(7);

        System.out.println(d.getAll1().get(0).getPhone());
d.updateStaff(s);
    }

}
