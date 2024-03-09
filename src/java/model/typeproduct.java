/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class typeproduct {
    private int id;
    private String name;
    private category categoryid;

    public typeproduct() {
    }

    public typeproduct(int id, String name, category categoryid) {
        this.id = id;
        this.name = name;
        this.categoryid = categoryid;
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

    public category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(category categoryid) {
        this.categoryid = categoryid;
    }
    
    
        
}
