package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.DataDao;
import com.example.pharmwebspring.Model.MapapiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    public void test(Model model, HttpSession session){
        String id = (String) session.getAttribute("id");
//        int category=(int)session.getAttribute("category");
//        switch (category){
//            case 1:
//                //유저에 대한 바인딩
//                break;
//            case 2:
//                //약사에대한 바인딩
//                break;
//
//        }
        if(id!=null){

            model.addAttribute("id", id);
            model.addAttribute("status", "Logout");
            model.addAttribute("url","/logout");
            model.addAttribute("mypage", "/mypage");
        }else{

            model.addAttribute("status", "Login");
            model.addAttribute("url","/login");
            model.addAttribute("mypage", "/login");
        }
    }

    @GetMapping("/")
    public String page(Model model, HttpSession session) {

        test(model,session);
        return "index";
    }

    @GetMapping("/index")
    public String indexpage(Model model, HttpSession session) {

        test(model,session);
        return "index";
    }

    @GetMapping("/register")
    public String resgisterpage(Model model, HttpSession session) {

        test(model,session);
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String loginpage(Model model, HttpSession session) {

        test(model,session);
        return "login";
    }

    @GetMapping("/cart")
    public String cartpage(Model model, HttpSession session) {

        test(model,session);
        return "cart";
    }

    @GetMapping("/order")
    public String orderpage(Model model, HttpSession session) {

        test(model,session);
        return "order";
    }

    @GetMapping("/custom")
    public String custompage(Model model, HttpSession session) {

        test(model,session);
        return "custom";
    }

    @GetMapping("/location")
    public String locationpage(Model model, HttpSession session) {

        test(model,session);
        return "location";
    }

    @GetMapping("/mp_cart")
    public String mp_cartpage(Model model, HttpSession session) {

        test(model,session);
        return "mp_cart";
    }

    @GetMapping("/mp_delete")
    public String mp_deletepage(Model model, HttpSession session) {

        test(model,session);
        return "mp_delete";
    }

    @GetMapping("/mp_history")
    public String mp_historypage(Model model, HttpSession session) {

        test(model,session);
        return "mp_history";
    }

    @GetMapping("/mp_profile")
    public String mp_profilepage(Model model, HttpSession session) {

        test(model,session);
        return "mp_profile";
    }

    @GetMapping("/mypage")
    public String mypagepage(Model model, HttpSession session) {

        test(model,session);
        return "mypage";
    }

    @GetMapping("/shop")
    public String shoppage(Model model, HttpSession session) {

        test(model,session);
        return "shop";
    }

    @GetMapping("/shop_allergy")
    public String shop_allergypage(Model model, HttpSession session) {

        test(model,session);
        return "shop_allergy";
    }

    @GetMapping("/shop_ent")
    public String shop_entpage(Model model, HttpSession session) {

        test(model,session);
        return "shop_ent";
    }

    @GetMapping("/shop_etc")
    public String shop_etcpage(Model model, HttpSession session) {

        test(model,session);
        return "shop_etc";
    }

    @GetMapping("/shop_eye")
    public String shop_eyepage(Model model, HttpSession session) {

        test(model,session);
        return "shop_eye";
    }

    @GetMapping("/shop_heart")
    public String shop_heartpage(Model model, HttpSession session) {

        test(model,session);
        return "shop_heart";
    }

    @GetMapping("/shop_single")
    public String shop_singlepage(Model model, HttpSession session) {

        test(model,session);
        return "shop_single";
    }

    @GetMapping("/shop_tooth")
    public String shop_toothpage(Model model, HttpSession session) {

        test(model,session);
        return "shop_tooth";
    }

    @GetMapping("/shop_urology")
    public String shop_urologypage(Model model, HttpSession session) {

        test(model,session);
        return "shop_urology";
    }

    @GetMapping("/shop_vitamin")
    public String shop_vitaminpage(Model model, HttpSession session) {

        test(model,session);
        return "shop_vitamin";
    }

    @GetMapping("/thankyou")
    public String thankyoupage(Model model, HttpSession session) {

        test(model,session);
        return "thankyou";
    }

    @GetMapping("/tips")
    public String tipspage(Model model, HttpSession session) {

        test(model,session);
        return "tips";
    }

    @GetMapping("/pharmacist")
    public String pharmacistpage(Model model, HttpSession session) {

        test(model,session);
        return "pharmacist";
    }

    @GetMapping("/register_pharm")
    public String register_pharmpage(Model model, HttpSession session) {

        test(model,session);
        return "register_pharm";
    }

    @GetMapping("/register_rider")
    public String register_riderpage(Model model, HttpSession session) {

        test(model,session);
        return "register_rider";
    }

    @GetMapping("/register_button")
    public String register_buttonpage(Model model, HttpSession session) {

        test(model,session);
        return "register_button";
    }

    @Autowired
    private DataDao dataDao;

    // private static Logger logger = LoggerFactory.getLogger(ViewController.class);
    @ResponseBody
    @RequestMapping(value = "/loc_location", method = RequestMethod.GET)
    public List<MapapiDto> location(){
        ArrayList<MapapiDto> list = dataDao.getDataAll();
        return list;
    }
}