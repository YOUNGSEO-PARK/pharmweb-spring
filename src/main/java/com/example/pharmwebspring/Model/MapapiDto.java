package com.example.pharmwebspring.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapapiDto {

    private Float wgs84Lat;
    private Float wgs84Lon;

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
