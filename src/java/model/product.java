/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Truong cun
 */
public class product {
    private int id;
    private String name;
    private String describe;
    private double price;
    private String images;
    private String dateupdate;
    private typeproduct idtypeproduct;
    private int quantity;
    private int viewed;

    public product() {
    }

    public product(int id, String name, String describe, double price, String images, String dateupdate, typeproduct idtypeproduct, int quantity, int viewed) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.images = images;
        this.dateupdate = dateupdate;
        this.idtypeproduct = idtypeproduct;
        this.quantity = quantity;
        this.viewed = viewed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(String dateupdate) {
        this.dateupdate = dateupdate;
    }

    public typeproduct getIdtypeproduct() {
        return idtypeproduct;
    }

    public void setIdtypeproduct(typeproduct idtypeproduct) {
        this.idtypeproduct = idtypeproduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    
    
    
    
}
