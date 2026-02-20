
package com.example.demo;

public class ProductVariant {
    private String color;
    private String size;
    private int stock;

    public ProductVariant(String color, String size, int stock) {
        this.color = color;
        this.size = size;
        this.stock = stock;
    }

    // Getter（HTMLで表示するために必要）
    public String getColor() { return color; }
    public String getSize() { return size; }
    public int getStock() { return stock; }
    
 // 在庫を減らすメソッド（子クラス側でも管理できるように）
    public void reduceStock(int quantity) {
        this.stock -= quantity;
    }
}
