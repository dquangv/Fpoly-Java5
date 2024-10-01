package com.poly.lab4.service;

import com.poly.lab4.model.Laptop;
import com.poly.lab4.util.DB;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	Map<Integer, Laptop> items = new HashMap<>();

    public void add(Integer id) {
        Laptop item = DB.items.get(id);
        if (items.containsKey(id)) {
//            item = items.get(id);
            item.setQty(item.getQty() + 1);
        } else {
            item.setQty(1);
            items.put(id, item);
        }
        item.setAmount(item.getPrice() * item.getQty());
       
    }

    public void update(Integer id, int qty) {
    	Laptop item = items.get(id);

        if (item != null) {
            item.setQty(qty);
            item.setAmount(item.getPrice() * item.getQty()); 
        }
    }

    public void remove(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public int getCount() {
        return items.values().stream().mapToInt(Laptop::getQty).sum();
    }

    public double getAmount() {
    	double totalAmount = items.values().stream().mapToDouble(Laptop::getAmount).sum();
        BigDecimal roundedAmount = new BigDecimal(totalAmount).setScale(2, RoundingMode.HALF_UP);
        return roundedAmount.doubleValue();
    }

	public Map<Integer, Laptop> getItems() {
        return items;
    }
	/*
	 * public Map<Integer, Laptop> getItems() { return items; }
	 */
}
