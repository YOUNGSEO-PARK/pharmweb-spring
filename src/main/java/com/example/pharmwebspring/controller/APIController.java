package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.RegisterRes;
import com.example.pharmwebspring.Model.User;
import com.example.pharmwebspring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIController {
//
//    @PostMapping("/")
//    public String Home(){
//        return "index";
//    }

    @Autowired
    MemberService memberService;

    @PostMapping("/uregi")
    public RegisterRes regUser(@RequestBody User regUser){

        // validation
        Login login = new Login();
        RegisterRes registerRes = new RegisterRes();

        User user = memberService.checkUser(login);

        System.out.print(regUser);
        if(user==null){

            memberService.insertUser(regUser);
            registerRes.setStatus(200);
        }else{

            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @PostMapping("/pregi")
    public RegisterRes regPharmacy(@RequestBody Pharmacy regPharm){

        Login login = new Login();
        RegisterRes registerRes = new RegisterRes();

        // validation
        Pharmacy pharmacy = memberService.checkPharmacy(login);

        if(pharmacy==null){
            memberService.insertPharmacy(regPharm);
            registerRes.setStatus(200);
        }else{
            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginUser(@RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        User user = memberService.checkUser(login);

        if(user==null){

            registerRes.setStatus(400);
        }else{

            registerRes.setStatus(200);
            //session.setAttribute(HttpSessionUtils.USER_SESSSION_KEY, user);
        }
        return registerRes;
    }


    @PostMapping("/pidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginPharmacy(@RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        Pharmacy pharmacy = memberService.checkPharmacy(login);

        if(pharmacy==null){

            registerRes.setStatus(400);
        }else{

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
