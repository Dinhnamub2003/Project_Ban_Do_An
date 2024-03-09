/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Truong cun
 */
public class order {

    private int id;
    private double total;
    private String address;
    private String orderdate;
    private String orderdelivery;
    private int accountid;
    private int staff;
    private int shipper;

    public order() {
    }

    public order(int id, double total, String address, String orderdate, String orderdelivery, int accountid, int staff, int shipper) {
        this.id = id;
        this.total = total;
        this.address = address;
        this.orderdate = orderdate;
        this.orderdelivery = orderdelivery;
        this.accountid = accountid;
        this.staff = staff;
        this.shipper = shipper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderdelivery() {
        return orderdelivery;
    }

    public void setOrderdelivery(String orderdelivery) {
        this.orderdelivery = orderdelivery;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public int getShipper() {
        return shipper;
    }

    public void setShipper(int shipper) {
        this.shipper = shipper;
    }
    
    
    
    
}
