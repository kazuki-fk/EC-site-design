public class Product {
    // 商品の情報を保持する変数（フィールド）
    private String name;  // 商品名
    private int price;    // 価格
    private int stock;    // 在庫数

    // コンストラクタ（商品を作るときに情報をセットする役割）
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // 商品情報を表示するメソッド
    public void showInfo() {
        System.out.println("商品名: " + name);
        System.out.println("価格: " + price + "円");
        System.out.println("在庫: " + stock + "個");
        System.out.println("--------------------");
    }
}