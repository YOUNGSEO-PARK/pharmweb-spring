package com.example.pharmwebspring.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Autowired
    private DataSource dataSource;
    public DataDao(){

    }

    public ArrayList<MapapiDto> getDataAll() {
        ArrayList<MapapiDto> list = new ArrayList<MapapiDto>();
        try {
            String sql = "select * from parmdb.pharmacyapi";
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MapapiDto dto = new MapapiDto();
                dto.setName(rs.getString("dutyName"));
                dto.setAdr(rs.getString("dutyAddr"));
                dto.setTell(rs.getString("dutyTel1"));
                dto.setLat(rs.getFloat("wgs84Lat"));
                dto.setLon(rs.getFloat("wgs84Lon"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("getDataAll err:" + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {

            }
        }
        return list;
    }
}
