package com.example.pharmwebspring.DAO;

import com.example.pharmwebspring.Model.Login;
import com.example.pharmwebspring.Model.Pharmacy;
import com.example.pharmwebspring.Model.Rider;
import com.example.pharmwebspring.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface LoginDAO {

    void setUser(User user);

    void setPharmacy(Pharmacy pharmacy);

    void setRider(Rider rider);


    User getUser(Login login);

    Pharmacy getPharmacy(Login login);

    Rider getRider(Login login);


    String getIDList(String id);

     void deleteUser(Login login);

}
