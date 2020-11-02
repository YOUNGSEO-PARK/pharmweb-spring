package com.example.pharmwebspring.controller;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmwebspring.Model.Cart;
import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Order;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.Rider;
import com.example.pharmwebspring.Model.StatusRes;
import com.example.pharmwebspring.Model.User;
import com.example.pharmwebspring.Service.CartService;
import com.example.pharmwebspring.Service.MemberService;
import com.example.pharmwebspring.Service.OrderService;

@RestController

@RequestMapping("/api")
public class APIController {

    @Autowired
    MemberService memberService;
    @Inject
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    StatusRes statusRes = new StatusRes();

    @PostMapping("/udup")
    public StatusRes dupUser(@RequestBody User dupUser) {

        // validation
        StatusRes statusRes = new StatusRes();
        String users = memberService.getUserIDList(dupUser.getUser_id());

        if (users == null) {

            statusRes.setStatus(100);
        } else {

            statusRes.setStatus(101);
        }

        return statusRes;
    }

    @PostMapping("/pdup")
    public StatusRes dupPharm(@RequestBody User dupPharm) {

        // validation
        StatusRes statusRes = new StatusRes();
        String users = memberService.getUserIDList(dupPharm.getUser_id());

        if (users == null) {

            statusRes.setStatus(200);
        } else {

            statusRes.setStatus(201);
        }

        return statusRes;
    }

    @PostMapping("/rdup")
    public StatusRes dupRider(@RequestBody User dupRider) {

        // validation
        StatusRes statusRes = new StatusRes();
        String users = memberService.getUserIDList(dupRider.getUser_id());

        if (users == null) {

            statusRes.setStatus(300);
        } else {

            statusRes.setStatus(301);
        }

        return statusRes;
    }

    @PostMapping("/uregi")
    public StatusRes regUser(@RequestBody User regUser) {

        // validation
        StatusRes statusRes = new StatusRes();
        String users = memberService.getUserIDList(regUser.getUser_id());

        if (users == null) {

            memberService.insertUser(regUser);
            statusRes.setStatus(100); // 유저 회원가입 성공
        } else {

            statusRes.setStatus(101); // 유저 회원가입 실패
        }

        return statusRes;
    }

    @PostMapping("/insertorder")
    public StatusRes insertOrder(HttpSession session, @RequestBody Order order) {
        StatusRes statusRes = new StatusRes();

        String user_id = (String) session.getAttribute("id");
        order.setOrder_user_id(user_id);
        order.setOrder_status("0");

        StringBuilder sb = new StringBuilder();

        AtomicInteger sum = new AtomicInteger();

        cartService.listCart(user_id)
                   .stream()
                   .filter(cart -> cart.getUser_id().equals(user_id))
                   .forEach(cart -> {
                       sb.append(cart.getCart_prod_name())
                         .append(" x")
                         .append(cart.getCount_p())
                         .append(' ');
                       sum.addAndGet(cart.getSummoney());
                   });

        order.setOrder_prod(sb.toString());
        order.setOrder_sum(sum.get());
        cartService.deleteAll(user_id);
        orderService.insertOrder(order);

        String orders = order.getOrder_name();

        if (orders == null) {

            statusRes.setStatus(601);
        } else {

            statusRes.setStatus(600);
        }

        return statusRes;
    }

    @PostMapping("/getorder")
    public StatusRes getOrder(HttpServletRequest request, @RequestBody Order order) {


        StatusRes statusRes = new StatusRes();

        orderService.getOrderList();
        HttpSession session = request.getSession();

        session.setAttribute("ono", order.getOrder_no());
        session.setAttribute("oid", order.getOrder_user_id());

        return statusRes;
    }

    @PostMapping("/pregi")
    public StatusRes regPharmacy(@RequestBody Pharmacy regPharmacy) {

        // validation\
        StatusRes statusRes = new StatusRes();
        String pharms = memberService.getPharmIDList(regPharmacy.getPharm_id());

        if (pharms == null) {

            memberService.insertPharmacy(regPharmacy);
            statusRes.setStatus(200);
        } else {

            statusRes.setStatus(201);
        }

        return statusRes;
    }

    @PostMapping("/rregi")
    public StatusRes regPharmacy(@RequestBody Rider regRider) {

        // validation\
        StatusRes statusRes = new StatusRes();
        String pharms = memberService.getRiderIDList(regRider.getRider_id());

        if (pharms == null) {

            memberService.insertRider(regRider);
            statusRes.setStatus(300); // 라이더 회원가입 성공
        } else {

            statusRes.setStatus(301); // 라이더 회원가입 실패
        }

        return statusRes;
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public StatusRes LoginUser(HttpServletRequest request, @RequestBody Login login) {

        StatusRes statusRes = new StatusRes();
        User user = memberService.checkUser(login);
        HttpSession session = request.getSession();

        if (user == null) {

            statusRes.setStatus(103);
        } else {

            UserWebSocketController.userId = user.getUser_id();
            session.setAttribute("id", user.getUser_id());
            session.setAttribute("uname", user.getUser_name());
            session.setAttribute("uphone", user.getUser_phone());
            session.setAttribute("uemail", user.getUser_email());
            session.setAttribute("uadr1", user.getUser_adr1());
            session.setAttribute("uadr2", user.getUser_adr2());
//            session.setAttribute("category",1);

            statusRes.setStatus(102);
        }
        return statusRes;
    }

    @PostMapping("/pidlogin") //sql -> 값 가져와서 성공 실패 보는
    public StatusRes LoginPharmacy(HttpServletRequest request, @RequestBody Login login) {

        StatusRes statusRes = new StatusRes();
        Pharmacy pharmacy = memberService.checkPharmacy(login);
        HttpSession session = request.getSession();

        if (pharmacy == null) {

            statusRes.setStatus(203);
        } else {

            session.setAttribute("id", pharmacy.getPharm_id());
            session.setAttribute("pname", pharmacy.getPharm_name());
            session.setAttribute("opentime", pharmacy.getOpentime());
            session.setAttribute("closetime", pharmacy.getClosetime());
            session.setAttribute("padr", pharmacy.getPharm_adr());
            session.setAttribute("regino", pharmacy.getRegi_no());

            statusRes.setStatus(202);
        }
        return statusRes;
    }

    @PostMapping("/ridlogin") //sql -> 값 가져와서 성공 실패 보는
    public StatusRes LoginRider(HttpServletRequest request, @RequestBody Login login) {

        StatusRes statusRes = new StatusRes();
        Rider rider = memberService.checkRider(login);
        HttpSession session = request.getSession();

        if (rider == null) {

            statusRes.setStatus(303);
        } else {

            session.setAttribute("id", rider.getRider_id());
            session.setAttribute("rname", rider.getRider_name());
            session.setAttribute("rphone", rider.getRider_phone());
            session.setAttribute("radr", rider.getRider_adr());
            session.setAttribute("license", rider.getLicense_no());

            statusRes.setStatus(302);
        }
        return statusRes;
    }


    @PostMapping("/udelete")
    public StatusRes DeleteUser(HttpSession session, @RequestBody String pw) throws JSONException {

        Login login = new Login();

        login.setLogin_id((String) session.getAttribute("id"));

        JSONObject jObject = new JSONObject(pw);
        String login_pw = jObject.getString("login_pw");
        login.setLogin_pw(login_pw);

        StatusRes statusRes = new StatusRes();
        User user = memberService.checkUser(login);

        if (user == null) {

            statusRes.setStatus(401);
        } else {

            memberService.deleteUser(login);
            statusRes.setStatus(400);
            session.invalidate();
        }

        return statusRes;
    }

    @PostMapping("/upwcheck")
    public StatusRes UserpwCheck(HttpSession session, @RequestBody String userpw) throws JSONException {

        Login login = new Login();

        login.setLogin_id((String) session.getAttribute("id"));

        JSONObject jObject = new JSONObject(userpw);
        String login_pw = jObject.getString("login_pw");
        login.setLogin_pw(login_pw);

        User user = memberService.checkUser(login);

        if (user == null) {

            statusRes.setStatus(108);
        } else {

            statusRes.setStatus(107);
        }

        return statusRes;
    }

    @PostMapping("/ppwcheck")
    public StatusRes PharmpwCheck(HttpSession session, @RequestBody String pharmpw) throws JSONException {

        Login login = new Login();

        login.setLogin_id((String) session.getAttribute("id"));

        login.setLogin_pw(pharmpw);
        System.out.println(pharmpw);

        Pharmacy pharmacy = memberService.checkPharmacy(login);

        if (pharmacy == null) {

            statusRes.setStatus(208);
        } else {

            statusRes.setStatus(207);
        }

        return statusRes;
    }

    @PostMapping("/rpwcheck")
    public StatusRes RiderpwCheck(HttpSession session, @RequestBody String riderpw) throws JSONException {

        Login login = new Login();

        login.setLogin_id((String) session.getAttribute("id"));

        JSONObject jObject = new JSONObject(riderpw);
        String login_pw = jObject.getString("login_pw");
        login.setLogin_pw(login_pw);

        Rider rider = memberService.checkRider(login);

        if (rider == null) {

            statusRes.setStatus(308);
        } else {

            statusRes.setStatus(307);
        }

        return statusRes;
    }

    @PostMapping("/cartinsert")
    public StatusRes insert(@RequestBody Cart cart){

        if(cart==null){

            statusRes.setStatus(501);
        }

        else if(cart.getCount_p() == 0){

            statusRes.setStatus(502);
        }
//
//        else if(cart.getCart_prod_name().equals())

        else{

            cartService.insert(cart);
            statusRes.setStatus(500);
        }

        return statusRes;
    }


    @PostMapping("/upwupdate")
    public StatusRes UserpwUpdate(HttpSession session, @RequestBody User user) {

        user.setUser_id((String) session.getAttribute("id"));

        memberService.updateUser(user);

        if (user == null) {

            statusRes.setStatus(908);
        } else {

            statusRes.setStatus(907);
        }

        return statusRes;
    }
   /* @RequestMapping("list.do")
    public ModelAndView list(HttpSession session, ModelAndView mav){
        String user_id = (String) session.getAttribute("user_id");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Cart> list = cartService.listCart(user_id);
        int sumMoney = cartService.sumMoney(user_id);
        map.put("list", list);
        map.put("count_p", list.size());
        map.put("sumMoney", sumMoney);
        mav.setViewName("mp_cart");
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
    }*/

}
