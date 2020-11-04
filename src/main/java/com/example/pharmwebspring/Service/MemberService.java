package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.*;

public interface MemberService {
    void insertUser(User user);

    void insertPharmacy(Pharmacy pharmacy);

    void insertRider(Rider rider);

    User checkUser(Login login);

    Pharmacy checkPharmacy(Login login);

    Rider checkRider(Login login);

    String getUserIDList(String id);

    String getPharmIDList(String id);

    String getRiderIDList(String id);

    void deleteUser(Login login);

    void updateUser(User user);

    void updatePharm(Pharmacy pharmacy);

    void updateRider(Rider rider);
}