/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class payments {
    private int paymentid;
    private double amount;
    private String paymentmethod;
    private String paymentdate;
    private int idaccount;
    private int orderid;

    public payments() {
    }

    public payments(int paymentid, double amount, String paymentmethod, String paymentdate, int idaccount, int orderid) {
        this.paymentid = paymentid;
        this.amount = amount;
        this.paymentmethod = paymentmethod;
        this.paymentdate = paymentdate;
        this.idaccount = idaccount;
        this.orderid = orderid;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public int getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(int idaccount) {
        this.idaccount = idaccount;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

      
    
    
}
