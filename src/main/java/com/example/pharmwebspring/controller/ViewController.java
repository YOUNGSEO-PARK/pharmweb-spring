package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.DataDao;
import com.example.pharmwebspring.Model.MapapiDto;
import com.example.pharmwebspring.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

//    public String ShopProduct(Model model){
//        List<Product> productList = new ArrayList<>();
//
//        productList.add(new Product("락토핏", 'C', "images/락토핏.jpg", 4000));
//
//        return
//    }

    public void userSession(Model model, HttpSession session){
        String id = (String) session.getAttribute("id");
        String uname= (String) session.getAttribute("uname");
        String uphone = (String) session.getAttribute("uphone");
        String uemail = (String) session.getAttribute("uemail");
        String uadr = (String) session.getAttribute("uadr");

        model.addAttribute("home", "/index");

        if(id!=null){

            model.addAttribute("id", id);
            model.addAttribute("uname", uname);
            model.addAttribute("uphone", uphone);
            model.addAttribute("uemail", uemail);
            model.addAttribute("uadr", uadr);

            model.addAttribute("status", "Logout");
            model.addAttribute("url","/logout");
            model.addAttribute("mypage", "/mypage");
        }else{

            model.addAttribute("status", "Login");
            model.addAttribute("url","/login");
            model.addAttribute("mypage", "/login");
        }
    }

    public void pharmSession(Model model, HttpSession session){
        String id = (String) session.getAttribute("id");
        String pname = (String) session.getAttribute("pname");
        String opentime = (String) session.getAttribute("opentime");
        String closetime = (String) session.getAttribute("closetime");
        String padr = (String) session.getAttribute("padr");
        String regino = (String) session.getAttribute("regino");

        model.addAttribute("home", "/pharmacist");

        if(id!=null){

            model.addAttribute("id", id);
            model.addAttribute("pname", pname);
            model.addAttribute("opentime", opentime);
            model.addAttribute("closetime", closetime);
            model.addAttribute("padr", padr);
            model.addAttribute("regino", regino);

            model.addAttribute("status", "Logout");
            model.addAttribute("url","/logout");
            model.addAttribute("mypage", "/mypage_pharm");
        }else{

            model.addAttribute("status", "Login");
            model.addAttribute("url","/login");
            model.addAttribute("mypage", "/login");
        }
    }

    public void riderSession(Model model, HttpSession session){
        String id = (String) session.getAttribute("id");
        String rname = (String) session.getAttribute("rname");
        String rphone = (String) session.getAttribute("rphone");
        String radr = (String) session.getAttribute("radr");
        String license = (String) session.getAttribute("license");

        model.addAttribute("home", "/rider");

        if(id!=null){

            model.addAttribute("id", id);
            model.addAttribute("rname", rname);
            model.addAttribute("rphone", rphone);
            model.addAttribute("radr", radr);
            model.addAttribute("license", license);

            model.addAttribute("status", "Logout");
            model.addAttribute("url","/logout");
            model.addAttribute("mypage", "/mypage_rider");
        }else{

            model.addAttribute("status", "Login");
            model.addAttribute("url","/login");
            model.addAttribute("mypage", "/login");
        }
    }

    @GetMapping("/")
    public String page(Model model, HttpSession session) {

        userSession(model,session);
        return "index";
    }

    @GetMapping("/index")
    public String indexpage(Model model, HttpSession session) {

       userSession(model,session);
        return "index";
    }

    @GetMapping("/register")
    public String resgisterpage(Model model, HttpSession session) {

        userSession(model,session);
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String loginpage(Model model, HttpSession session) {

        userSession(model,session);
        return "login";
    }

    @GetMapping("/cart")
    public String cartpage(Model model, HttpSession session) {

        userSession(model,session);
        return "cart";
    }

    @GetMapping("/order")
    public String orderpage(Model model, HttpSession session) {

        userSession(model,session);
        return "order";
    }

    @GetMapping("/custom")
    public String custompage(Model model, HttpSession session) {

        userSession(model,session);
        return "custom";
    }

    @Autowired
    private DataDao dataDao;

    @ResponseBody
    @RequestMapping(value = "/loc_location", method = RequestMethod.GET)
    public List<MapapiDto> location(){
        ArrayList<MapapiDto> list = dataDao.getDataAll();
        return list;
    }

    @GetMapping("/location")
    public String locationpage(){
        return "location";
    }

    @GetMapping("/mp_cart")
    public String mp_cartpage(Model model, HttpSession session) {

        userSession(model,session);
        return "mp_cart";
    }

    @GetMapping("/mp_delete")
    public String mp_deletepage(Model model, HttpSession session) {

        userSession(model,session);
        return "mp_delete";
    }

    @GetMapping("/mp_history")
    public String mp_historypage(Model model, HttpSession session) {

        userSession(model,session);
        return "mp_history";
    }

    @GetMapping("/mp_profile")
    public String mp_profilepage(Model model, HttpSession session) {

        userSession(model,session);
        return "mp_profile";
    }

    @GetMapping("/mypage")
    public String mypagepage(Model model, HttpSession session) {

        userSession(model,session);
        return "mypage";
    }

    @GetMapping("/shop")
    public String shoppage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop";
    }

    @GetMapping("/shop_allergy")
    public String shop_allergypage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_allergy";
    }

    @GetMapping("/shop_ent")
    public String shop_entpage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_ent";
    }

    @GetMapping("/shop_etc")
    public String shop_etcpage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_etc";
    }

    @GetMapping("/shop_eye")
    public String shop_eyepage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_eye";
    }

    @GetMapping("/shop_heart")
    public String shop_heartpage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_heart";
    }

    @GetMapping("/shop_single")
    public String shop_singlepage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_single";
    }

    @GetMapping("/shop_tooth")
    public String shop_toothpage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_tooth";
    }

    @GetMapping("/shop_urology")
    public String shop_urologypage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_urology";
    }

    @GetMapping("/shop_vitamin")
    public String shop_vitaminpage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_vitamin";
    }

    @GetMapping("/thankyou")
    public String thankyoupage(Model model, HttpSession session) {

        userSession(model,session);
        return "thankyou";
    }

    @GetMapping("/tips")
    public String tipspage(Model model, HttpSession session) {

        userSession(model,session);
        return "tips";
    }

    @GetMapping("/pharmacist")
    public String pharmacistpage(Model model, HttpSession session) {

        pharmSession(model,session);
        return "pharmacist";
    }

    @GetMapping("/register_pharm")
    public String register_pharmpage(Model model, HttpSession session) {

        pharmSession(model,session);
        return "register_pharm";
    }

    @GetMapping("/register_rider")
    public String register_riderpage(Model model, HttpSession session) {

        riderSession(model,session);
        return "register_rider";
    }

    @GetMapping("/register_button")
    public String register_buttonpage(Model model, HttpSession session) {

        userSession(model,session);
        return "register_button";
    }

    @GetMapping("/mp_profile_pharm")
    public String mp_profile_pharmpage(Model model, HttpSession session) {

        pharmSession(model,session);
        return "mp_profile_pharm";
    }

    @GetMapping("/mp_profile_rider")
    public String mp_profile_riderpage(Model model, HttpSession session) {

        riderSession(model,session);
        return "mp_profile_rider";
    }

    @GetMapping("/mypage_pharm")
    public String mypage_pharmpage(Model model, HttpSession session) {

        pharmSession(model,session);
        return "mypage_pharm";
    }

    @GetMapping("/mypage_rider")
    public String mypage_riderpage(Model model, HttpSession session) {

        riderSession(model,session);
        return "mypage_rider";
    }

    @GetMapping("/rider")
    public String riderpage(Model model, HttpSession session) {

        riderSession(model,session);
        return "rider";
    }

}
