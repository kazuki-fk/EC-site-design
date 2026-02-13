import java.util.ArrayList;
import java.util.Scanner; // ←【解決1】これが必要！

public class Main {

    public static void main(String[] args) {
        // 1. 準備：入力窓口と商品リストの作成
        Scanner scanner = new Scanner(System.in); // ←【解決2】これが必要！
        ArrayList<Product> itemList = new ArrayList<>();

        itemList.add(new Product("スニーカー", 12800, 10));
        itemList.add(new Product("Tシャツ", 5000, 20));
        itemList.add(new Product("MA-1", 58500, 5));

        System.out.println("=== 簡易ECシステムへようこそ ===");

        // 2. 商品一覧の表示（番号付き）
        for (int i = 0; i < itemList.size(); i++) {
            System.out.print("[" + i + "] "); // インデックスを表示
            itemList.get(i).showInfo();
        }

        // 3. ユーザーからの入力
        System.out.print("\n購入したい商品の番号を選択してください: ");
        int choice = scanner.nextInt();

        System.out.print("購入個数を入力してください: ");
        int quantity = scanner.nextInt();

        // 4. 購入処理の実行
        if (choice >= 0 && choice < itemList.size()) {
            // 選んだ番号の商品に対して注文メソッドを呼ぶ
            itemList.get(choice).order(quantity);
        } else {
            System.out.println("❌ 無効な番号です。");
        }

        // 5. 最終的な在庫状況と在庫総額の表示
        System.out.println("\n=== 更新後の在庫状況（在庫総額の確認） ===");
        int totalValue = 0;
        
        
        for (Product p : itemList) {
            p.showInfo();
//            totalValue += (p.getPrice() * p.getStock());
         // その商品の「在庫分すべて」の小計を出す
            int subTotal = p.getPrice() * p.getStock();
         // 小計に対する税込を計算
            int subTotalTax = (int)(subTotal * 1.1);
            
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
        System.out.println("（税込総額: " + (int)taxIncluded + "円）");
        
        scanner.close(); // 使い終わったら閉じる
    }
}