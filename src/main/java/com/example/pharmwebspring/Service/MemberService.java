package com.example.pharmwebspring.Service;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.User;

public interface MemberService {
    void idList(String login_id);

    void insertUser(User user);
    void insertPharmacy(Pharmacy pharmacy);

    User checkUser(Login login);
    Pharmacy checkPharmacy(Login login);

    User deleteUser(Login login);

}