package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    // カート全体の合計金額（税込）を計算
    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : items) {
            total += item.getSubTotal();
        }
        return (int) (total * 1.1); // 消費税10%
    }
}