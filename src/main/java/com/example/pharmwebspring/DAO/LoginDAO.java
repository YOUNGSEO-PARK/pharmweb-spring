package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Member;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LoginDAO {

    void setUser(User user);

    void setPharmacy(Pharmacy pharmacy);

    User getUser(Login login);

    Pharmacy getPharmacy(Login login);

    Member getMember(Login login);

    String getIDList(String id);

    User deleteUser(Login login);

}
