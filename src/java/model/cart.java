/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Truong cun
 */
public class cart {

    private List<item> items;

    public cart() {
        items = new ArrayList<>();

    }
  private item getItemID(int id) {
        for (item i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityByID(int id) {
        return getItemID(id).getQuantity();
    }

  
    public void addItem(item i) {
        if (getItemID(i.getProduct().getId()) != null) {
            item m = getItemID(i.getProduct().getId());
            m.setQuantity(m.getQuantity() + i.getQuantity());

        } else {
            items.add(i);
        }
    }

    public void removeItem(int id) {
        if (getItemID(id) != null) {
            items.remove(getItemID(id));
        }
    }

    public double getTotlaMoney() {
       double t =0;
        for (item o : items) {
            t+=o.getPrice()*o.getQuantity();
        }
        return t;
    }
    
   public product getProductById(int id , List<product> list){
       for (product i : list) {
           if(i.getId()==id){
               return i;
           }
       }
       return null;
   }
   
   public cart(String txt, List<product> list){
       items = new ArrayList<>();

       try {
           if(txt!=null && txt.length()!=0){
               String[] s =txt.split(",");
               for (String o : s) {
                   String[] n = o.split(":");
                   int id = Integer.parseInt(n[0]);
                   int quantity =Integer.parseInt(n[1]);
                   product p = getProductById(id, list);
                   item t = new item(p, quantity, p.getPrice());
                   addItem(t);
               }
           }
       } catch (Exception e) {
           System.out.println(e);
       }
   }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }
   
   
   
   
   
}
