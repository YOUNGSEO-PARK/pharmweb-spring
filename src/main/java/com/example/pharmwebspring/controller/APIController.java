package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.RegisterRes;
import com.example.pharmwebspring.Model.User;
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

    @PostMapping("/uregi")
    public RegisterRes regUser(@RequestBody User regUser){

        // validation\
        RegisterRes registerRes = new RegisterRes();

        String users = memberService.getIDList(regUser.getUser_id());

        System.out.print(regUser);
        if(users==null){

            memberService.insertUser(regUser);
            registerRes.setStatus(200);
        }else{

            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @GetMapping("/session")
    public String getSession(HttpServletRequest request,HttpSession session){
        return (String)session.getAttribute("id");
    }

    @PostMapping("/pregi")
    public RegisterRes regPharmacy(@RequestBody Pharmacy regPharm){

        // validation\
        RegisterRes registerRes = new RegisterRes();

        String pharms = memberService.getIDList(regPharm.getPharm_id());

        System.out.print(regPharm);
        if(pharms==null){

            memberService.insertPharmacy(regPharm);
            registerRes.setStatus(200);
        }else{

            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginUser(HttpServletRequest request, @RequestBody Login login){


        RegisterRes registerRes = new RegisterRes();
        User user = memberService.checkUser(login);
        HttpSession session = request.getSession();

        if(user==null){

            registerRes.setStatus(400);
        }else{
            session.setAttribute("id", user.getUser_id());

            registerRes.setStatus(200);
        }
        return registerRes;
    }


    @PostMapping("/pidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginPharmacy(HttpServletRequest request, @RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        Pharmacy pharmacy = memberService.checkPharmacy(login);
        HttpSession session = request.getSession();

        if(pharmacy==null){

            registerRes.setStatus(400);
        }else{

            session.setAttribute("id", pharmacy.getPharm_id());
            registerRes.setStatus(200);
        }
        return registerRes;
    }

    @PostMapping("/udelete")
    public RegisterRes DeleteUser(@RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.deleteUser(login);

        if(user==null){

            registerRes.setStatus(400);
        }else{

            registerRes.setStatus(200);
        }
        return registerRes;
    }
}
