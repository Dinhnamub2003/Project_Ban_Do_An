/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Truong cun
 */
public class account {

    private int id;
    private String username, password, realname, phone, email, address, avatar, role;

    public account() {
    }

    public account(int id, String username, String password, String realname, String phone, String email, String address, String avatar, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.role = role;
    }
    public account(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        
    }
    public account( String username, String password) {
        
        this.username = username;
        this.password = password;
        
    }
    public account(int id, String username, String password, String realname, String phone, String email,String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
                this.address = address;

    }
    public account(int id, String username, String password, String realname, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
                

    }

    public account(String username, String password, String realname, String phone, String email, String address, String avatar, String role) {

        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.role = role;
    }
    public account(String username, String password, String realname, String phone, String email, String address) {

        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
      
    }

    public account(int id, String username, String password, String realname, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}