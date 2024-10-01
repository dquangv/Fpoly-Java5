package com.poly.lab4.util;

import com.poly.lab4.model.Laptop;

import java.util.HashMap;
import java.util.Map;

public class DB {
    public static Map<Integer, Laptop> items = new HashMap<>();

    static {
        items.put(1, new Laptop(1, "Dell XPS 13", "/images/dell-xps-13.jpg", 999.99, 10));
        items.put(2, new Laptop(2, "MacBook Pro 2021", "/images/macbook-pro-2021.jpg", 1299.99, 10));
        items.put(3, new Laptop(3, "HP Spectre x360", "/images/hp-spectre-x360.jpg", 1099.49, 0));
        items.put(4, new Laptop(4, "Lenovo ThinkPad X1", "/images/lenovo-thinkpad-x1.jpg", 1249.55, 10));
        items.put(5, new Laptop(5, "Asus ROG Zephyrus", "/images/asus-rog-zephyrus.jpg", 1499.99, 0));
        items.put(6, new Laptop(6, "Microsoft Surface Laptop 4", "/images/surface-laptop-4.jpg", 999.00, 10));
    }
}
