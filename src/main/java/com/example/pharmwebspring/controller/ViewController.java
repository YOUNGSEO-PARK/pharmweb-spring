package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Cart;
import com.example.pharmwebspring.Model.DataDao;
import com.example.pharmwebspring.Model.MapapiDto;
import com.example.pharmwebspring.Model.StatusRes;
import com.example.pharmwebspring.Service.CartService;
import com.example.pharmwebspring.Service.OrderService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.pharmwebspring.Service.ProductService;

@Controller
public class ViewController {

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
    public String locationpage(Model model, HttpSession session){

        userSession(model,session);
        return "location";
    }
    @Inject
    ProductService productService;
    @RequestMapping("/shop") //세부적인 url mapping
    public ModelAndView shoppage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("/shop"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productService.listProduct());  //데이터 저장

        //서비스에서 상품 리스트를 받아와 list라는 이름의 변수에 저장

        //service -> model -> mybatis -> 리스트를 받아옴

        return mav; //페이지 이동
    }


    @Inject
    CartService cartService;

    @RequestMapping("list.do")
    public ModelAndView list(HttpSession session, ModelAndView mav){
        String user_id = (String) session.getAttribute("user_id");
        Map<String, Object>map = new HashMap<String, Object>();
        List<Cart> list = cartService.listCart(user_id);
        int sumMoney = cartService.sumMoney(user_id);
        map.put("list", list);
        map.put("count_p", list.size());
        map.put("sumMoney", sumMoney);
        mav.setViewName("/mp_cart");
        mav.addObject("map",map);
        return mav;
    }

    @RequestMapping("delete.do")
    public String delete(@RequestParam int cart_no){
        cartService.delete(cart_no);
        return "/mp_cart";
    }

    @RequestMapping("update.do")
    public String update(@RequestParam int[] count_p, @RequestParam String[] prod_name, HttpSession session){
        String user_id = (String)session.getAttribute("user_id");
        for(int i = 0; i<prod_name.length; i++){
            Cart cart = new Cart();
            cart.setUser_id(user_id);
            cart.setCount_p(count_p[i]);
            cart.setCart_prod_name(prod_name[i]);
            cartService.modifyCart(cart);
        }
        return "/mp_cart";
    }

    /*@RequestMapping("/cart")
    public ModelAndView list(HttpSession session, ModelAndView mav){
        Map<String, Object> map=new HashMap<>();
        String user_id=(String)session.getAttribute("user_id");

        if(user_id!= null){
            List<Cart> list = CartService.listCart(user_id);
            int sumMoney=CartService.sumMoney(user_id);

            map.put("sumMoney", sumMoney);
            map.put("list", list);
            map.put("count_p", list.size());

            mav.setViewName("/cart");
            mav.addObject("map", map);

            return mav;
        }else{
            return new ModelAndView("/index","",null);
        }
    }
    */
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

    @RequestMapping("/{prod_name}")
    public ModelAndView shop_singlepage(
            @PathVariable("prod_name")
                    String prod_name,
            ModelAndView mav, Model model, HttpSession session) {

        userSession(model, session);
        mav.setViewName("/shop_single");
        mav.addObject("dto",productService.product(prod_name));

        return mav;
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

    @GetMapping("/shop_flu")
    public String shop_flupage(Model model, HttpSession session) {

        userSession(model,session);
        return "shop_flu";
    }

    @GetMapping("/thankyou")
    public String thankyoupage(Model model, HttpSession session) {

        PharmacistWebSocketController.updateOrderList();
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

    @GetMapping("/contents_01")
    public String contents_01page(Model model, HttpSession session) {

        userSession(model, session);
        return "contents_01";
    }

    @GetMapping("/contents_02")
    public String contents_02page(Model model, HttpSession session) {

        userSession(model, session);
        return "contents_02";
    }

    @GetMapping("/contents_03")
    public String contents_03page(Model model, HttpSession session) {

        userSession(model, session);
        return "contents_03";
    }

    @GetMapping("/contents_04")
    public String contents_04page(Model model, HttpSession session) {

        userSession(model, session);
        return "contents_04";
    }

    @GetMapping("/contents_05")
    public String contents_05page(Model model, HttpSession session) {

        userSession(model, session);
        return "contents_05";
    }
}