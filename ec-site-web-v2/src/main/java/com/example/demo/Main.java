package com.example.demo;
import java.util.ArrayList;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		// 1. 準備：入力窓口と商品リストの作成
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> itemList = new ArrayList<>();

		itemList.add(new Product("スニーカー", 12800, 10));
		itemList.add(new Product("Tシャツ", 5000, 20));
		itemList.add(new Product("MA-1", 58500, 5));

		System.out.println("=== 簡易ECシステムへようこそ ===");

		while (true) {
			// 1. 商品一覧の表示（ここは今のコードのまま）
			for (int i = 0; i < itemList.size(); i++) {
				System.out.print("[" + i + "] ");
				itemList.get(i).showInfo();
			}

			// 2. ユーザー入力（ここも今のコードのまま）
			System.out.print("\n購入したい商品の番号を選択してください（終了は-1）: ");
			int choice = scanner.nextInt();

			// -1 が入力されたらループを抜ける（終了判定）
			if (choice == -1) {
				System.out.println("お買い物を終了します。");
				break;
			}

			System.out.print("購入個数を入力してください: ");
			int quantity = scanner.nextInt();

			// 3. 購入処理（今のコードのまま）
			if (choice >= 0 && choice < itemList.size()) {
				itemList.get(choice).order(quantity);
			} else {
				System.out.println("❌ 無効な番号です。");
			}

			System.out.println("\n--- 次の注文をどうぞ ---");
		}

		System.out.println("\n=== 本日の最終在庫状況 ===");
		int totalValue = 0;

		
		for (Product p : itemList) {
			p.showInfo();

			int subTotal = p.getPrice() * p.getStock();
			int subTotalTax = (int) (subTotal * 1.1);

			System.out.println("   └ 在庫分税込小計: " + subTotalTax + "円");

			totalValue += subTotal;

			// 在庫警告もここで行う（実用性アピール）
			if (p.getStock() <= 5) {
				System.out.println("　⚠️要補充：" + p.getName() + " の在庫が残りわずかです！");
			}
		}

		System.out.println("--------------------");
		System.out.println("全商品の現在の在庫総額: " + totalValue + "円");

		// 税込総額を計算して表示
		double taxIncluded = totalValue * 1.1;
		System.out.println("（税込総額: " + (int) taxIncluded + "円）");

		scanner.close(); // 使い終わったら閉じる
	}
}