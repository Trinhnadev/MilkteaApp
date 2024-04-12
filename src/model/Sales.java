/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Nguyen Anh Trinh
 */
public class Sales implements Serializable {

    private Integer saleID;
    private Milk milk;
//    private String Name;
    private String Topping;
    private Double Price;

    public Sales(Integer saleID,Milk milk, String Topping, Double Price) {

        this.saleID = saleID;
//this.Name = Name;
        this.milk = milk;
        this.Topping = Topping;
        this.Price = Price;

    }

    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    public String getTopping() {
        return Topping;
    }

    public void setTopping(String Topping) {
        this.Topping = Topping;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

}
