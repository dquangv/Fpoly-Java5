package com.poly.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    Integer id;
    String name;
    String image;
    double price;
    int qty = 1;
    double amount;

    public Laptop(Integer id, String name, String image, double price, int qty) {
    	this.id = id;
    	this.name = name;
    	this.image = image;
    	this.price = price;
    	this.qty = qty;
    }
    
    public double getAmount() {
        return price * qty;
    }
}

