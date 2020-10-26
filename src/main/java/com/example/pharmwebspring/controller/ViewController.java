package com.example.pharmwebspring.controller;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class ViewController {

    @GetMapping("/index")
    public String indexpage(){
        return "index";
    }

    @GetMapping("/register")
    public String resgisterpage(){
        return "register";
    }

    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }

    @GetMapping("/about")
    public String aboutpage(){
        return "about";
    }

    @GetMapping("/cart")
    public String cartpage(Model model){
        return "cart";
    }

    @GetMapping("/order")
    public String orderpage(){
        return "order";
    }

    @GetMapping("/custom")
    public String custompage(){
        return "custom";
    }

    @GetMapping("/footer")
    public String footerpage(){
        return "footer";
    }

    @GetMapping("/header")
    public String headerpage(){
        return "header";
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

    @GetMapping("/location")
    public String locationpage(){
        return "location";
    }

    @GetMapping("/main")
    public String mainpage(){
        return "main";
    }

    @GetMapping("/mp_cart")
    public String mp_cartpage(){
        return "mp_cart";
    }

    @GetMapping("/mp_delete")
    public String mp_deletepage(){
        return "mp_delete";
    }

    @GetMapping("/mp_history")
    public String mp_historypage(){
        return "mp_history";
    }

    @GetMapping("/mp_profile")
    public String mp_profilepage(Model model){
        return "mp_profile";
    }

    @GetMapping("/mypage")
    public String mypagepage(){
        return "mypage";
    }

    @GetMapping("/shop")
    public String shoppage(){
        return "shop";
    }

    @GetMapping("/shop_allergy")
    public String shop_allergypage(){
        return "shop_allergy";
    }

    @GetMapping("/shop_ent")
    public String shop_entpage(){
        return "shop_ent";
    }

    @GetMapping("/shop_etc")
    public String shop_etcpage(){
        return "shop_etc";
    }

    @GetMapping("/shop_eye")
    public String shop_eyepage(){
        return "shop_eye";
    }

    @GetMapping("/shop_heart")
    public String shop_heartpage(){
        return "shop_heart";
    }

    @GetMapping("/shop_single")
    public String shop_singlepage(){
        return "shop_single";
    }

    @GetMapping("/shop_tooth")
    public String shop_toothpage(){
        return "shop_tooth";
    }

    @GetMapping("/shop_urology")
    public String shop_urologypage(){
        return "shop_urology";
    }

    @GetMapping("/shop_vitamin")
    public String shop_vitaminpage(){
        return "shop_vitamin";
    }

    @GetMapping("/thankyou")
    public String thankyoupage(){
        return "thankyou";
    }

    @GetMapping("/tips")
    public String tipspage(){
        return "tips";
    }
}
