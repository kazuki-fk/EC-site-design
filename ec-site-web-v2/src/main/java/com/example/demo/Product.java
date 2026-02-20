package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private int price;
    private List<ProductVariant> variants = new ArrayList<>();

    // 修正：引数を2つ（name, price）に変更
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public void addVariant(ProductVariant variant) {
        this.variants.add(variant);
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // ★重要：HTML側からリストを読み取るための窓口
    public List<ProductVariant> getVariants() {
        return variants;
    }
    
    public int getStock() {
        int totalStock = 0;
        for (ProductVariant v : variants) {
            totalStock += v.getStock();
        }
        return totalStock;
    }

    public void order(int quantity) {
        if (this.getStock() >= quantity) {
            System.out.println(this.name + " を " + quantity + " 個注文しました。");
        } else {
            System.out.println("⚠️ エラー：" + this.name + " の在庫が足りません！");
        }
    }

    public void showInfo() {
        System.out.println("商品名: " + name);
        System.out.println("価格: " + price + "円");
        System.out.println("総在庫: " + getStock() + "個");
        System.out.println("--- バリエーション内訳 ---");
        for (ProductVariant v : variants) {
            System.out.println("  - " + v.getColor() + " / " + v.getSize() + ": " + v.getStock() + "個");
        }
        System.out.println("--------------------");
    }
}