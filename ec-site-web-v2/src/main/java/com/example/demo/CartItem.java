package com.example.demo;

public class CartItem {
    private Product product;        // 商品（名前や価格用）
    private ProductVariant variant; // バリエーション（色やサイズ用）
    private int quantity;           // 数量

    public CartItem(Product product, ProductVariant variant, int quantity) {
        this.product = product;
        this.variant = variant;
        this.quantity = quantity;
    }

    // 小計を計算するメソッド
    public int getSubTotal() {
        return product.getPrice() * quantity;
    }

    // ゲッター
    public Product getProduct() { return product; }
    public ProductVariant getVariant() { return variant; }
    public int getQuantity() { return quantity; }
}