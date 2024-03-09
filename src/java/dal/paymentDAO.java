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
import model.payments;

/**
 *
 * @author Truong cun
 */
public class paymentDAO extends DBContext {

    public List<payments> getAll() {
        List<payments> list = new ArrayList<>();
        String sql = "select * from payments";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                payments p = new payments(rs.getInt("paymentid"), rs.getDouble("amount"),
                        rs.getString("paymentmethod"), rs.getString("paymentdate"), rs.getInt("idaccount"), rs.getInt("orderid"));
                list.add(p);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public payments getPayMentID(int id) {
//        List<payments> list = new ArrayList<>();
        String sql = "select * from payments where paymentid= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
           st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                payments p = new payments(rs.getInt("paymentid"), rs.getDouble("amount"),
                        rs.getString("paymentmethod"), rs.getString("paymentdate"), rs.getInt("idaccount"), rs.getInt("orderid"));
            return p;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public int gethighestID() {
        List<payments> list = new ArrayList<>();
        String sql = "select top 1 *  from payments order by paymentid desc";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                payments p = new payments(rs.getInt("paymentid"), rs.getDouble("amount"),
                        rs.getString("paymentmethod"), rs.getString("paymentdate"), rs.getInt("idaccount"), rs.getInt("orderid"));
                list.add(p);
                a = list.get(0).getPaymentid();
                a++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return a;
    }

    public void updatePayment(payments p) {
        String sql = "UPDATE [dbo].[Payments]\n"
                + "   SET [amount] = ?\n"
                + "      ,[paymentmethod] = ?\n"
                + "      ,[paymentdate] = ?\n"
                + "      ,[idaccount] = ?\n"
                + "      ,[orderid] =?\n"
                + "where paymentid =?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, p.getAmount());
            st.setString(2, p.getPaymentmethod());
            st.setString(3, p.getPaymentdate());
            st.setInt(4, p.getIdaccount());
            st.setInt(5, p.getOrderid());
            st.setInt(6, p.getPaymentid());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addPayment(payments p) {
        String sql = "INSERT INTO [dbo].[Payments]\n"
                + "           ([paymentid]\n"
                + "           ,[amount]\n"
                + "           ,[paymentmethod]\n"
                + "           ,[paymentdate]\n"
                + "           ,[idaccount]\n"
                + "           ,[orderid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getPaymentid());
            st.setDouble(2, p.getAmount());
            st.setString(3, p.getPaymentmethod());
            st.setString(4, p.getPaymentdate());
            st.setInt(5, p.getIdaccount());
            st.setInt(6, p.getOrderid());

            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deletePayment(int id){
        String sql ="delete from Payments where paymentid=?";
        try {
            PreparedStatement st= connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeQuery();
                    
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        paymentDAO d = new paymentDAO();
        payments p = new payments(6, 50000, "Chuyển khoản", "2023-10-24", 5, 5);
//        d.deletePayment(6);
System.out.println(d.getAll().get(0).getPaymentid());
    }

}
