package com.example.pharmwebspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/login2")
    public String login2page() {
        return "login2";
    }

    @GetMapping("/index")
    public String indexpage() {
        return "index";
    }

    @GetMapping("/register")
    public String resgisterpage() {
        return "register";
    }

    @GetMapping("/login")
    public String loginpage() {
        return "login";
    }

    @GetMapping("/about")
    public String aboutpage() {
        return "about";
    }

    @GetMapping("/cart")
    public String cartpage(Model model) {
        return "cart";
    }

    @GetMapping("/order")
    public String orderpage() {
        return "order";
    }

    @GetMapping("/custom")
    public String custompage() {
        return "custom";
    }

    @GetMapping("/footer")
    public String footerpage() {
        return "footer";
    }

    @GetMapping("/header")
    public String headerpage() {
        return "header";
    }

    @GetMapping("/location")
    public String locationpage() {
        return "location";
    }

    @GetMapping("/main")
    public String mainpage() {
        return "main";
    }

    @GetMapping("/mp_cart")
    public String mp_cartpage() {
        return "mp_cart";
    }

    @GetMapping("/mp_delete")
    public String mp_deletepage() {
        return "mp_delete";
    }

    @GetMapping("/mp_history")
    public String mp_historypage() {
        return "mp_history";
    }

    @GetMapping("/mp_profile")
    public String mp_profilepage(Model model) {
        return "mp_profile";
    }

    @GetMapping("/mypage")
    public String mypagepage() {
        return "mypage";
    }

    @GetMapping("/shop")
    public String shoppage() {
        return "shop";
    }

    @GetMapping("/shop_allergy")
    public String shop_allergypage() {
        return "shop_allergy";
    }

    @GetMapping("/shop_ent")
    public String shop_entpage() {
        return "shop_ent";
    }

    @GetMapping("/shop_etc")
    public String shop_etcpage() {
        return "shop_etc";
    }

    @GetMapping("/shop_eye")
    public String shop_eyepage() {
        return "shop_eye";
    }

    @GetMapping("/shop_heart")
    public String shop_heartpage() {
        return "shop_heart";
    }

    @GetMapping("/shop_single")
    public String shop_singlepage() {
        return "shop_single";
    }

    @GetMapping("/shop_tooth")
    public String shop_toothpage() {
        return "shop_tooth";
    }

    @GetMapping("/shop_urology")
    public String shop_urologypage() {
        return "shop_urology";
    }

    @GetMapping("/shop_vitamin")
    public String shop_vitaminpage() {
        return "shop_vitamin";
    }

    @GetMapping("/thankyou")
    public String thankyoupage() {
        return "thankyou";
    }

    @GetMapping("/tips")
    public String tipspage() {
        return "tips";
    }

    @GetMapping("/pharmacist")
    public String pharmacistpage() {
        return "pharmacist";
    }

    @GetMapping("/register_pharm")
    public String register_pharmpage() {
        return "register_pharm";
    }

    @GetMapping("/register_rider")
    public String register_riderpage() {
        return "register_rider";
    }

    @GetMapping("/register_button")
    public String register_buttonpage() {
        return "register_button";
    }
}
