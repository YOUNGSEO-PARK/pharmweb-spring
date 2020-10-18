package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.LoginDAO;
import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.User;
import com.example.pharmwebspring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private LoginDAO dao;

    @Override
    public void idList(String login_id) { dao.idList(login_id); }

    @Override
    public void insertUser(User user) { dao.setUser(user); }

    @Override
    public void insertPharmacy(Pharmacy pharmacy) { dao.setPharmacy(pharmacy); }

    @Override
    public User checkUser(Login login) { return dao.getUser(login); }

    @Override
    public Pharmacy checkPharmacy(Login login) { return dao.getPharmacy(login); }

    @Override
    public User deleteUser(Login login) { return dao.deleteUser(login); }
}
