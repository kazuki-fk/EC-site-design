import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 商品を入れるためのリスト（棚）を作る
		ArrayList<Product> itemList = new ArrayList<>();

		// 商品を追加する
		itemList.add(new Product("スニーカー", 12800, 10));
		itemList.add(new Product("Tシャツ", 5000, 20));
		itemList.add(new Product("MA-1", 58500, 5));

		// リストの中身を全部表示する
		System.out.println("=== ECサイト 商品一覧 ===");

		int totalValue = 0; // 合計金額を貯める変数

		for (Product p : itemList) {
			p.showInfo();// 商品ごとの情報を表示

			// Getterを使って価格と在庫を取得し、掛け算して合計に足す
			totalValue += (p.getPrice() * p.getStock());

			//            // 【追加】在庫が少ない（例：5個以下）場合にアラートを出す
			if (p.getStock() <= 5) {
				System.out.println("　⚠️要補充：" + p.getName() + " の在庫が残りわずかです！");
			}
		}
		// 4. 最後に合計を表示
		System.out.println("--------------------");
		System.out.println("全商品の在庫総額: " + totalValue + "円");
	}

}
