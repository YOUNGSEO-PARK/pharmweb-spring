package com.example.pharmwebspring.Model;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class MapapiDto {

    private String name;
    private String adr;
    private String tell;
    private Float wgs84Lat;
    private Float wgs84Lon;
    private String opentime;
    private String closetime;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdr(){return adr;}

    public void setAdr(){this.adr = adr;}

    public String getTell(){return tell;}

    public void setTell(){this.tell = tell;}

    public float getLat(){ return wgs84Lat; }

    public String getOpentime() {return opentime;}
    public void setOpentime(String opentime){this. opentime = opentime;}

    public String getClosetime() {return closetime;}
    public void setClosetime(String closetime){this.closetime = closetime;}

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