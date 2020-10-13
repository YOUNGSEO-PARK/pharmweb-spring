package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.RegisterRes;
import com.example.pharmwebspring.Model.User;
import com.example.pharmwebspring.Service.LoginService;
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
    LoginService loginService;

    @PostMapping("/uregi")
    public RegisterRes regUser(@RequestBody User regUser){
        // validation
        Login login = new Login();
        RegisterRes registerRes = new RegisterRes();

        // validation
        User user = loginService.checkUser(login);

        if(user==null){
            loginService.insertUser(regUser);
            registerRes.setStatus(200);
        }else{
            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @PostMapping("/pregi")
    public RegisterRes regPharmacy(@RequestBody Pharmacy regPharm){

        Login login = new Login();
        Pharmacy pharmRegi = new Pharmacy();
        RegisterRes registerRes = new RegisterRes();

        pharmRegi.setPharm_id(regPharm.getPharm_id());
        pharmRegi.setPharm_pw(regPharm.getPharm_pw());
        pharmRegi.setOpentime(regPharm.getOpentime());
        pharmRegi.setClosetime(regPharm.getClosetime());
        pharmRegi.setPharm_name(regPharm.getPharm_name());
        pharmRegi.setPharm_adr(regPharm.getPharm_adr());
        pharmRegi.setRegi_no(regPharm.getRegi_no());

        // validation
        Pharmacy pharmacy = loginService.checkPharmacy(login);

        if(pharmacy==null){
            loginService.insertPharmacy(regPharm);
            registerRes.setStatus(200);
        }else{
            registerRes.setStatus(400);
        }

        return registerRes;
    }

    @PostMapping("/uidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginUser(@RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        User user = loginService.checkUser(login);

        if(user==null){

            registerRes.setStatus(400);
        }else{

            registerRes.setStatus(200);
        }
        return registerRes;
    }


    @PostMapping("/pidlogin") //sql -> 값 가져와서 성공 실패 보는
    public RegisterRes LoginPharmacy(@RequestBody Login login){

        RegisterRes registerRes = new RegisterRes();
        Pharmacy pharmacy = loginService.checkPharmacy(login);

        if(pharmacy==null){

            registerRes.setStatus(400);
        }else{

            registerRes.setStatus(200);
        }
        return registerRes;
    }

}
