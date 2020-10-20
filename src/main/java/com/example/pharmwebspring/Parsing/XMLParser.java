package com.example.pharmwebspring.Parsing;

import java.io.BufferedInputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;


public class XMLParser {
    public final static String PHARM_URL = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
    public final static String KEY = "hKyEVkCoDXA2F8YRMshfBtDUTrs7QSbgYJ%2FiiR11pb%2FqeaLKuTC1%2F6LgUkKOHW5eMi8EDmwUeEwi0RMEtAMM8Q%3D%3D&pageNO=1&numOfRows=22953&";

    public XMLParser() {
        try {
            apiParserSearch();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     *
     * @throws Exception
     */
    public void apiParserSearch() throws Exception {
        URL url = new URL(getURLParam(null));

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        xpp.setInput(bis, "utf-8");

        String tag = null;
        int event_type = xpp.getEventType();

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list_lat = new ArrayList<String>();

        String addr = null;
        String wgs84Lat = null;

        while (event_type != XmlPullParser.END_DOCUMENT) {
            if (event_type == XmlPullParser.START_TAG) {
                tag = xpp.getName();
            } else if (event_type == XmlPullParser.TEXT) {
                /**
                 * 약국의 주소만 가져와본다.
                 */
                if(tag.equals("dutyAddr")){
                    addr = xpp.getText();
                }
                else if(tag.equals("wgs84Lat")){
                    wgs84Lat = xpp.getText();
                }
            } else if (event_type == XmlPullParser.END_TAG) {
                tag = xpp.getName();
                if (tag.equals("item")) {
                    list.add(addr);
                    list_lat.add(wgs84Lat);
                }

            }

            event_type = xpp.next();
        }
        printList(list, list_lat);


    }

    /**
     * 결과 값을 출력해본다.
     * @param list
     */

    private void printList(ArrayList<String> list, ArrayList<String> list_lat){
        for(String entity : list){
            System.out.println(entity);
        }
        for(String entity_lat : list_lat){
            System.out.println(entity_lat);
        }
    }



    private String getURLParam(String search){
        String url = PHARM_URL+"?ServiceKey="+KEY;
        if(search != null){
            url = url+"&yadmNm"+search;
        }
        return url;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new XMLParser();
    }

}
