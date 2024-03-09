/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class review {
    private int reviewid;
    private String content;
    private int rating;
    private String review_date;
    private account idaccount;
    private int productid;

    public review() {
    }

    public review(int reviewid, String content, int rating, String review_date, account idaccount, int productid) {
        this.reviewid = reviewid;
        this.content = content;
        this.rating = rating;
        this.review_date = review_date;
        this.idaccount = idaccount;
        this.productid = productid;
    }
    public review(int reviewid, String content, account idaccount, int productid) {
        this.reviewid = reviewid;
        this.content = content;
    
        this.idaccount = idaccount;
        this.productid = productid;
    }
    public review(String content,  account idaccount, int productid) {
      
        this.content = content;
    
        this.idaccount = idaccount;
        this.productid = productid;
    }

    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
    }

    public account getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(account idaccount) {
        this.idaccount = idaccount;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    
    
}
