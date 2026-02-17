package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EcController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "JavaとHTMLの接続に成功しました！");
        model.addAttribute("stock", 25); // ここがJavaで計算した在庫数になります
        return "index"; 
    }
}