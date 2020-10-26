package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.MemberService;
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

    @PostMapping("/uregi")
    public RegisterRes regUser(@RequestBody User regUser) {

        // validation
        RegisterRes registerRes = new RegisterRes();

        String users = memberService.getUserIDList(regUser.getUser_id());

        System.out.print(regUser);
        if (users == null) {

            memberService.insertUser(regUser);
            registerRes.setStatus(100); // 유저 회원가입 성공
        } else {

            registerRes.setStatus(101); // 유저 회원가입 실패
        }

        return registerRes;
    }

    @PostMapping("/pregi")
    public RegisterRes regPharmacy(@RequestBody Pharmacy regPharmacy) {

        // validation\
        RegisterRes registerRes = new RegisterRes();
        System.out.println(regPharmacy);

        String pharms = memberService.getPharmIDList(regPharmacy.getPharm_id());

        if (pharms == null) {

            memberService.insertPharmacy(regPharmacy);
            registerRes.setStatus(200); // 약사 회원가입 성공
        } else {

            registerRes.setStatus(201); // 약사 회원가입 실패
        }
        return registerRes;
    }

    @PostMapping("/rregi")
    public RegisterRes regPharmacy(@RequestBody Rider regRider) {

        // validation\
        RegisterRes registerRes = new RegisterRes();
        String pharms = memberService.getRiderIDList(regRider.getRider_id());

        System.out.print(regRider);
        if (pharms == null) {

            memberService.insertRider(regRider);
            registerRes.setStatus(300); // 라이더 회원가입 성공
        } else {

            registerRes.setStatus(301); // 라이더 회원가입 실패
        }

        return registerRes;
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginUser(HttpServletRequest request, @RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.checkUser(login);
        HttpSession session = request.getSession();

        if (user == null) {

            registerRes.setStatus(103);
        } else {
            session.setAttribute("uid", user.getUser_id());
            session.setAttribute("uname", user.getUser_name());
            session.setAttribute("uphone", user.getUser_phone());
            session.setAttribute("uemail", user.getUser_email());
            session.setAttribute("uadr", user.getUser_adr());
//            session.setAttribute("category",1);
            System.out.println(user.getUser_adr());
            registerRes.setStatus(102);
        }
        return registerRes;
    }

    @PostMapping("/pidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginPharmacy(HttpServletRequest request, @RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        Pharmacy pharmacy = memberService.checkPharmacy(login);
        HttpSession session = request.getSession();

        if (pharmacy == null) {

            registerRes.setStatus(203);
        } else {

            session.setAttribute("id", pharmacy.getPharm_id());
            registerRes.setStatus(202);
        }
        return registerRes;
    }

    @PostMapping("/ridlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginRider(HttpServletRequest request, @RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        Rider rider = memberService.checkRider(login);
        HttpSession session = request.getSession();

        if (rider == null) {

            registerRes.setStatus(303);
        } else {

            session.setAttribute("id", rider.getRider_id());
            registerRes.setStatus(302);
        }
        return registerRes;
    }

    @PostMapping("/udelete")
    public RegisterRes DeleteUser(HttpSession session, @RequestBody String pw) throws JSONException {

        Login login = new Login();

        login.setLogin_id((String) session.getAttribute("id"));

        JSONObject jObject = new JSONObject(pw);
        String login_pw = jObject.getString("login_pw");
        login.setLogin_pw(login_pw);

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.checkUser(login);

        if (user == null) {

            registerRes.setStatus(401);
        } else {

            memberService.deleteUser(login);
            registerRes.setStatus(400);
            session.invalidate();
        }

        return registerRes;
    }
}
