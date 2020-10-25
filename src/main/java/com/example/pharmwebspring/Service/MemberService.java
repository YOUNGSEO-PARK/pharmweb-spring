package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.*;

public interface MemberService {
    void insertUser(User user);

    void insertPharmacy(Pharmacy pharmacy);

    void insertRider(Rider rider);

    User checkUser(Login login);

    Pharmacy checkPharmacy(Login login);

    Rider checkRider(Login login);

    String getIDList(String id);

    void deleteUser(Login login);

}