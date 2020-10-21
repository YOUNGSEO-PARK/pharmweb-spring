package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@SessionAttributes("member")
@RequestMapping("/api")
public class APIController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public void login(Info info) {
        /*
        int oc = select oc from member where id = info.id and pw = info.pw
        switch (oc) {
            case U:

            case P:

            case R:

        }
         */
    }

    @PostMapping("/joinUser")
    public void joinU(User user) {
        /*
        String id = user.id
        String pw = user.pw
        멤버에 id, pw로 값 넣기

        유저에 다른거로 값 넣기
         */
    }

    @PostMapping("/joinPharmacy")
    public void joinP(Pharmacy p) {

    }

    @PostMapping("/joinRider")
    public void joinR(Rider r) {

    }

    @PostMapping("/uregi")
    public RegisterRes regUser(@RequestBody User regUser) {

        // validation
        RegisterRes registerRes = new RegisterRes();

        String users = memberService.getIDList(regUser.getUser_id());

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

        String pharms = memberService.getIDList(regPharmacy.getPharm_id());

        System.out.print(regPharmacy);
        if (pharms == null) {

            memberService.insertPharmacy(regPharmacy);
            registerRes.setStatus(200); // 약사 회원가입 성공
        } else {

            registerRes.setStatus(201); // 약사 회원가입 실패
        }

        return registerRes;
    }

    @GetMapping("/session")
    public String getSession(HttpServletRequest request, HttpSession session) {
        return (String) session.getAttribute("id");
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginUser(HttpServletRequest request, @RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.checkUser(login);
        HttpSession session = request.getSession();

        if (user == null) {

            registerRes.setStatus(103);
        } else {
            session.setAttribute("id", user.getUser_id());

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

    @PostMapping("/midlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginMember(HttpServletRequest request, @RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        Member member = (Member) memberService.checkMember(login);
        HttpSession session = request.getSession();

        if (member == null) {

            registerRes.setStatus(403);
        } else {

            session.setAttribute("id", member.getMember_id());
            registerRes.setStatus(402);
        }
        return registerRes;
    }

    @PostMapping("/udelete")
    public RegisterRes DeleteUser(@RequestBody Login login) {

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.deleteUser(login);

        if (user == null) {

            registerRes.setStatus(400);
        } else {

            registerRes.setStatus(200);
        }
        return registerRes;
    }

    class Info {
        private String id;
        private String pw;

        public String getId() {
            return id;
        }

        public String getPw() {
            return pw;
        }
    }
}
