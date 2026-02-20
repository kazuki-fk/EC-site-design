package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EcController {

    @GetMapping("/")
    public String index(Model model) {
     // メッセージをセット
    	Product vinyl = new Product("限定版アナログレコード", 5500);
    	ProductVariant blackVariant = new ProductVariant("Black", "12inch", 15);
        vinyl.addVariant(blackVariant);
        vinyl.addVariant(new ProductVariant("Clear Blue", "12inch", 10));
        
     // 2. カートを作成し、商品を1つ入れてみる（シミュレーション）
        Cart myCart = new Cart();
        // 「Black / 12inch」を 2枚 カートに入れる
        CartItem item1 = new CartItem(vinyl, blackVariant, 2);
        myCart.addItem(item1);
        
     // 3. モデルに登録
        model.addAttribute("product", vinyl);
        model.addAttribute("cart", myCart); // カート情報をHTMLへ
        model.addAttribute("message", "お買い物をお楽しみください");
          
        
        return "index"; 
    }
}