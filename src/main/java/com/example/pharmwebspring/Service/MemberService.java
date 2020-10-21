package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Member;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.User;

public interface MemberService {
    void insertUser(User user);

    void insertPharmacy(Pharmacy pharmacy);

    User checkUser(Login login);

    Pharmacy checkPharmacy(Login login);

    Member checkMember(Login login);

    String getIDList(String id);

    User deleteUser(Login login);

}