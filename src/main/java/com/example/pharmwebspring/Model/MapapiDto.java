package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapapiDto {

    private String name;
    private Float wgs84Lat;
    private Float wgs84Lon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLat(){ return wgs84Lat; }

    public void setLat(float wgs84Lat){
        this.wgs84Lat = wgs84Lat;
    }

    public float getLon(){
        return wgs84Lon;
    }

    public void setLon(float wgs84Lon){
        this.wgs84Lon = wgs84Lon;
    }

}