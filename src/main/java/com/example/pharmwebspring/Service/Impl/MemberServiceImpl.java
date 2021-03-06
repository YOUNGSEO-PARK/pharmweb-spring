package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.LoginDAO;
import com.example.pharmwebspring.Model.*;
import com.example.pharmwebspring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private LoginDAO dao;

    @Override
    public void insertUser(User user) {

        dao.setUser(user);
    }

    @Override
    public void insertPharmacy(Pharmacy pharmacy) {

        dao.setPharmacy(pharmacy);
    }

    @Override
    public void insertRider(Rider rider) {

        dao.setRider(rider);
    }

    @Override
    public User checkUser(Login login) {

        return dao.getUser(login);
    }

    @Override
    public Pharmacy checkPharmacy(Login login) {

        return dao.getPharmacy(login);
    }

    @Override
    public Rider checkRider(Login login) {

        return dao.getRider(login);
    }

    @Override
    public String getUserIDList(String id) {

        return dao.getUserIDList(id);
    }

    @Override
    public String getPharmIDList(String id) {

        return dao.getPharmIDList(id);
    }

    @Override
    public String getRiderIDList(String id) {

        return dao.getRiderIDList(id);
    }

    @Override
    public void deleteUser(Login login) {

        dao.deleteUser(login);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void updatePharm(Pharmacy pharmacy) {
        dao.updatePharm(pharmacy);
    }

    @Override
    public void updateRider(Rider rider) {
        dao.updateRider(rider);
    }
}
