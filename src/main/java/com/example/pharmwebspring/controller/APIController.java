package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.DAO.CartDAO;
import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.CartService;
import com.example.pharmwebspring.Service.MemberService;
import com.example.pharmwebspring.Service.OrderService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController

@RequestMapping("/api")
public class APIController {

    @Autowired
    MemberService memberService;
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    @PostMapping("/udup")
    public StatusRes dupUser(@RequestBody User dupUser) {

        // validation
        StatusRes statusRes = new StatusRes();
        String users = memberService.getUserIDList(dupUser.getUser_id());

        if (users == null) {

            statusRes.setStatus(100); // 유저 회원가입 성공
        } else {

            statusRes.setStatus(101); // 유저 회원가입 실패
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
    public StatusRes insertOrder(@RequestBody Order order) {


        StatusRes statusRes = new StatusRes();
        orderService.insertOrder(order);

        String orders = order.getOrder_name();
        System.out.println(orders);

        if (orders == null) {

            statusRes.setStatus(601);
        } else {

            statusRes.setStatus(600);
        }

        return statusRes;
    }

    @PostMapping("/pregi")
    public StatusRes regPharmacy(@RequestBody Pharmacy regPharmacy) {

        // validation\
        StatusRes statusRes = new StatusRes();
        String pharms = memberService.getPharmIDList(regPharmacy.getPharm_id());

        if (pharms == null) {

            memberService.insertPharmacy(regPharmacy);
            statusRes.setStatus(200); // 약사 회원가입 성공
        } else {

            statusRes.setStatus(201); // 약사 회원가입 실패
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
            session.setAttribute("id", user.getUser_id());
            session.setAttribute("uname", user.getUser_name());
            session.setAttribute("uphone", user.getUser_phone());
            session.setAttribute("uemail", user.getUser_email());
            session.setAttribute("uadr", user.getUser_adr());
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

    @PostMapping("/ucart")
    public StatusRes InsertCart(HttpSession session, @ModelAttribute Cart cart){

        String uid = (String) session.getAttribute("id");
        cart.setUser_id(uid);

        int count = cartService.countCart(cart.getCart_prod_name(), uid);

        StatusRes statusRes = new StatusRes();

        if(count == 0) {

            cartService.insertCart(cart);
            statusRes.setStatus(104);
        }
        else if(count > 0){

            cartService.updateCart(cart);
            statusRes.setStatus(105);

        }
        else{

            statusRes.setStatus(106);
        }

        return statusRes;
    }

}
