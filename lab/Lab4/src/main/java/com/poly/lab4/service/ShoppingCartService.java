package com.poly.lab4.service;

import com.poly.lab4.model.Laptop;

import java.util.Collection;
import java.util.Map;

public interface ShoppingCartService {
//    Laptop add(Integer id);
	void add(Integer id);
    void remove(Integer id);
//    Laptop update(Integer id, int qty);
    void update(Integer id, int qty);
    void clear();
    Map<Integer, Laptop> getItems();
    int getCount();
    double getAmount();
}
