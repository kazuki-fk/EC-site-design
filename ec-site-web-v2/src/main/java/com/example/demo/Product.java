package com.example.demo;
public class Product {
	// 商品の情報を保持する変数（フィールド）
	private String name; // 商品名
	private int price; // 価格
	private int stock; // 在庫数

	// コンストラクタ（商品を作るときに情報をセットする役割）
	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	// 値を「計算」に使うための窓口（Getter）
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void order(int quantity) {
		if (this.stock >= quantity) {
			this.stock -= quantity; // 在庫を減らす
			System.out.println(this.name + " を " + quantity + " 個注文しました。");
		} else {
			System.out.println("⚠️ エラー：" + this.name + " の在庫が足りません！");
		}
	}

	// 値を「画面に表示」するための機能（既存のメソッド）
	public void showInfo() {
		System.out.println("商品名: " + name);
		System.out.println("価格: " + price + "円");
		System.out.println("在庫: " + stock + "個");
		System.out.println("--------------------");
	}
}