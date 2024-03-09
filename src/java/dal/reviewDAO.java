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
import model.review;

/**
 *
 * @author Truong cun
 */
public class reviewDAO extends DBContext {

    public List<review> getReviewByProductID(int id) {
        List<review> list = new ArrayList<>();
        String sql = "select reviewid, content , rating, review_date, "
                + "a.id as idaccount , productid , realname , avatar from Reviews r"
                + " join account a on r.idaccount = a.id where productid =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                account a = new account(rs.getInt("idaccount"), sql, sql, rs.getString("realname"), sql, sql, sql, rs.getString("avatar"), sql);
                review v = new review(rs.getInt("reviewid"), rs.getString("content"), rs.getInt("rating"),
                        rs.getString("review_date"), a, rs.getInt("productid"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public review getID(int id) {
//        List<review> list = new ArrayList<>();
        String sql = "select * from Reviews where reviewid =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                account a = new account();
                review v = new review(rs.getInt("reviewid"), rs.getString("content"), rs.getInt("rating"),
                        rs.getString("review_date"), a, rs.getInt("productid"));
                return v;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getIDreview() {
        String sql = "select top 1 * from Reviews order by reviewid desc";
        List<review> list = new ArrayList<>();
        int b = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                account a = new account();
                review v = new review(rs.getInt("reviewid"), rs.getString("content"), rs.getInt("rating"),
                        rs.getString("review_date"), a, rs.getInt("productid"));
                list.add(v);
                b = list.get(0).getReviewid();
                b++;
            }
        } catch (SQLException e) {
        }
        return b;
    }

    public void deleteReview(int id, int ac) {
        String sql = "delete from Reviews where reviewid=? and idaccount=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, ac);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateReview(review a) {
        String sql = "UPDATE [dbo].[Reviews]\n"
                + "   SET [content] =?\n"
                + " WHERE reviewid=? and idaccount=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getContent());
            st.setInt(2, a.getReviewid());
            st.setInt(3, a.getIdaccount().getId());
           
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addReview(review a) {
        String sql = "INSERT INTO [dbo].[Reviews]\n"
                + "           ([reviewid]\n"
                + "           ,[content]\n"
                + "           ,[idaccount]\n"
                + "           ,[productid])\n"
                + "     VALUES\n"
                + "          (?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int c = getIDreview();
            st.setInt(1, c);
            st.setString(2, a.getContent());
            st.setObject(3, a.getIdaccount().getId());
            st.setInt(4, a.getProductid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        reviewDAO d = new reviewDAO();
//        System.out.println(d.getIDreview());
        account a = new account(4, "hihi", "123", "xinchao", "099999999", "hello@gmail.com", "Quang Ninh", "con meo", "user");
       
        review v = new review(5, "qua ngon", a
                , 53);
//        d.addReview(v);

d.updateReview(v);
//        System.out.println(d.getReviewByProductID(55).size());
    }
}
