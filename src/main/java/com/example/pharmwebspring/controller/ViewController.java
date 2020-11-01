package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Cart;
import com.example.pharmwebspring.Model.DataDao;
import com.example.pharmwebspring.Model.MapapiDto;
import com.example.pharmwebspring.Service.CartService;
import com.example.pharmwebspring.Model.StatusRes;
import com.example.pharmwebspring.Service.*;
import com.example.pharmwebspring.Service.ProductServiceN;
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

//    @Autowired
//    OrderService orderService;
//
//    public void orderPharmList(Model model){
//        orderService.getOrderPharmList();
//
//
//    }
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
    @GetMapping("/custom_flu")
    public String custom_flupage(Model model, HttpSession session) {

        userSession(model,session);
        return "custom_flu";
    }
    @GetMapping("/custom_home")
    public String custom_homepage(Model model, HttpSession session) {

        userSession(model,session);
        return "custom_home";
    }
    @GetMapping("/custom_period")
    public String custom_periodpage(Model model, HttpSession session) {

        userSession(model,session);
        return "custom_period";
    }
    @GetMapping("/custom_vitamin")
    public String custom_vitaminpage(Model model, HttpSession session) {

        userSession(model,session);
        return "custom_vitamin";
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

    @Inject
    ProductServiceB productServiceB;
    @RequestMapping("/shop_allergy")
    public ModelAndView shop_allergypage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_allergy"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceB.listProductB());  //데이터 저장
        return mav; //페이지 이동
    }

    @Inject
    ProductServiceN productServiceN;
    @RequestMapping("/shop_ent")
    public ModelAndView shop_entpage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_ent"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceN.listProductN());  //데이터 저장
        return mav; //페이지 이동
    }

    @Inject
    ProductServiceZ productServiceZ;
    @RequestMapping("/shop_etc")
    public ModelAndView shop_etcpage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_etc"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceZ.listProductZ());  //데이터 저장
        return mav; //페이지 이동
    }

    @Inject
    ProductServiceE productServiceE;
    @RequestMapping("/shop_eye")
    public ModelAndView shop_eyepage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_eye"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceE.listProductE());  //데이터 저장
        return mav; //페이지 이동
    }

    @Inject
    ProductServiceH productServiceH;
    @RequestMapping("/shop_heart")
    public ModelAndView shop_heartpage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_heart"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceH.listProductH());  //데이터 저장
        return mav; //페이지 이동
    }


    @Inject
    ProductServiceT productServiceT;
    @RequestMapping("/shop_tooth")
    public ModelAndView shop_toothpage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_tooth"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceT.listProductT());  //데이터 저장
        return mav; //페이지 이동
    }

    @GetMapping("/shop_urology")
    public String shop_urologypage(Model model, HttpSession session) {

    @Inject
    ProductServiceU productServiceU;
    @RequestMapping("/shop_urology")
    public ModelAndView shop_urologypage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_urology"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceU.listProductU());  //데이터 저장
        return mav; //페이지 이동
    }

    @Inject
    ProductServiceF productServiceF;
    @RequestMapping("/shop_flu")
    public ModelAndView shop_flupage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop_flu"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productServiceF.listProductF());  //데이터 저장
        return mav; //페이지 이동
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


    @Inject
    CartService cartService;


    @PostMapping("/list")
    public ModelAndView list(HttpSession session, ModelAndView mav,
                             Model model){
        //user_id = (String) session.getAttribute("user_id");
        //userSession(model, session);
        //Map<String, Object>map = new HashMap<>();
        //userSession(model, session);
        String user_id = (String)session.getAttribute("user_id");
            //List<Cart> list = cartService.listCart(user_id);

            //map.put("list", list);
            //map.put("count", list.size());

            mav.setViewName("mp_cart");
            mav.addObject("map", cartService.listCart(user_id));

            return mav;
    }



    @RequestMapping("/update")
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

    @GetMapping("/mp_cart")
    public ModelAndView mp_cartpage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        String user_id = (String)session.getAttribute("user_id");
        mav.setViewName("mp_cart");
        mav.addObject("map", cartService.listCart(user_id));
        return mav;
    }

    @Inject
    ProductService productService;

    @RequestMapping("/shop") //세부적인 url mapping
    public ModelAndView shoppage(ModelAndView mav, Model model, HttpSession session) {
        userSession(model,session);
        mav.setViewName("shop"); //이동할 페이지 이름 (product_list.jsp 파일로 이동)
        mav.addObject("list", productService.listProduct());  //데이터 저장
        return mav; //페이지 이동
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

//    @RequestMapping("/{prod_name}")
//    public ModelAndView shop_singlepage(
//            @PathVariable("prod_name")
//                    String prod_name,
//            ModelAndView mav, Model model, HttpSession session) {
//
//        userSession(model, session);
//        mav.setViewName("shop_single");
//        mav.addObject("dto",productService.product(prod_name));
//
//        return mav;
//    }

}