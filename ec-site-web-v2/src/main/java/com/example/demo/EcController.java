package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EcController {

    @GetMapping("/")
    public String index(Model model) {
     // メッセージをセット
        model.addAttribute("message", "JavaとHTMLの接続に成功しました！");
        
        // 在庫数をセット（ここを書き足せばOK！）
        model.addAttribute("stock", 25);
        
        return "index"; 
    }
}