package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Order;
import com.example.pharmwebspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@Component
@ServerEndpoint(value = "/riderWebSocket")
public class RiderWebSocketController {
    private int id;
    private Session session;

    private static int loginNumber;
    public static HashMap<Integer, Order> orders;
    public static HashMap<Integer, RiderWebSocketController> riders;

    static {
        loginNumber = 0;
        orders = new HashMap<>();
        riders = new HashMap<>();
    }

    @OnOpen
    public void onOpen(Session session) {
        id = loginNumber++;
        this.session = session;
        riders.put(id, this);
        requestOrderList();
        System.out.println("Enter : " + id);
    }

    @OnClose
    public void onClose(Session session) {
        riders.remove(id);
        System.out.println("Exit : " + id);
    }

    @OnMessage
    public void onMessage(String message) {

    }

    public void requestOrderList() {
        try {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<Integer, Order> e : orders.entrySet()) {
                result.append("<div class=\"container\">\n" +
                        "                    <div class=\" form-group row\" style=\"margin-bottom:20px; padding:20px; border:3px solid #75b239;\">\n" +
                        "                        <div>\n" +
                        "                            <image src=\"images/person_1.jpg\" width=\"200px\" height=\"200px\"></image>\n" +
                        "                        </div>\n" +
                        "                        <div style=\"padding-left: 100px;\">\n" +
                        "                            <p class=\"text-black\"><b>주문번호 : " + e.getValue().getOrder_no() +"</b></p>\n" +
                        "                            <br>\n" +
                        "                            <h5 class=\"text-black\">주문자 이름 : " + e.getValue().getOrder_name() + "</h5>\n" +
                        "                            <h4 class=\"text-black\"><b>주문자 주소 : " + e.getValue().getOrder_adr1() + " " + e.getValue().getOrder_adr2() + " </b></h4>\n" +
                        "                            <p class=\"text-black\">주문내역 <br> " + e.getValue().getOrder_prod() + " </p>\n" +
                        "<div class=\"form-group row\" >"+
                        "<div class=\"col-lg-6\">"+
                        "<input type=\"submit\" class=\"btn btn-primary btn-lg btn-block\" value=\"수거완료\">"+
                        "</div>"+
                        "<div class=\"col-lg-6\">"+
                        "<input type=\"submit\" class=\"btn btn-primary btn-lg btn-block\" value=\"배달완료\">"+
                        "</div>"+
                        "</div>"+
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                </div>");
            }

            session.getBasicRemote().sendText(result.toString());
        } catch (Exception e) {
            System.out.println("Exception ID : " + id);
            e.printStackTrace();
        }
    }

    public static void updateOrderList() {
        orders = getOrders();
        for (RiderWebSocketController riderWebSocketController : riders.values()) {
            riderWebSocketController.requestOrderList();
        }
    }

    public static HashMap<Integer, Order> getOrders() {

        return orders;
    }
}