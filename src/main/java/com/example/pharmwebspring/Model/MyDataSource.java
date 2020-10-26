package com.example.pharmwebspring.Model;
import org.springframework.jdbc.datasource.DriverManagerDataSource; //BasicDataSource
import org.springframework.stereotype.Repository;

@Repository("dataSource")
public class MyDataSource extends DriverManagerDataSource {
    public MyDataSource() {
        setDriverClassName("com.mysql.cj.jdbc.Driver");
        setUrl("jdbc:mysql://52.197.31.102:3306/parmdb?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false");
        setUsername("parm");
        setPassword("1234");
    }
}
