package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Order;
import com.example.pharmwebspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.InterruptedNamingException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.pharmwebspring.controller.PharmacistWebSocketController.orderService;

@Component
@ServerEndpoint(value = "/riderWebSocket")
public class RiderWebSocketController {
    private int id;
    private Session session;

    private static int loginNumber;
    public static HashMap<String, Order> orders;
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
        if (message.charAt(0) == ':') {

            String realMessage = message.substring(1);

            Order order = new Order();
            order.setOrder_no(Integer.parseInt(realMessage));

            order.setOrder_status("3");
            orders.get(realMessage).setOrder_status("3");
            orderService.updateStatus(order);

            PharmacistWebSocketController.updateOrderList();
            UserWebSocketController.updateOrderList();
            return;
        }

        Order order = new Order();
        // status 업데이트하는 쿼리
        order.setOrder_no(Integer.parseInt(message));
        order.setOrder_status("2");
        orders.get(message).setOrder_status("2");

        orderService.updateStatus(order);
        updateOrderList();

        PharmacistWebSocketController.updateOrderList();
        UserWebSocketController.updateOrderList();
        requestOrderList();
    }

    public void requestOrderList() {
        try {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Order> e : orders.entrySet()) {
                result.append("<div class=\"container\">\n" +
                        "                    <div class=\" form-group row\" style=\"margin-bottom:20px; padding:20px; border:3px solid #75b239;\">\n" +

                        "                        <div>\n" +
                        "                            <image src=\"images/person_1.jpg\" width=\"200px\" height=\"200px\"></image>\n" +
                        "                        </div>\n" +

                        "                        <div style=\"padding-left: 100px;\">\n" +
                        "                            <p class=\"text-black\"><b>주문번호 : " + e.getValue().getOrder_no() +"</b></p>\n" +
                        "                            <br>\n" +
                        "                            <p class=\"text-black\">주문자 아이디 : " + e.getValue().getOrder_user_id() + "</p>\n" +
                        "                            <p class=\"text-black\">주문자 휴대폰 번호 : " + e.getValue().getOrder_phone() +" </p>\n"  +
                        "                            <h6 class=\"text-black\">주문자 메세지 : " + e.getValue().getOrder_msg() + " </h6><br>\n"  +
                        "                            <h5 class=\"text-black\">수령인 이름 : " + e.getValue().getOrder_name() + "</h5>\n" +
                        "                            <h4 class=\"text-black\"><b>수령인 주소 : " + e.getValue().getOrder_adr1() + " " + e.getValue().getOrder_adr2() + " </b></h4><br>\n"+
                        "                            <p class=\"text-black\">상품명 <br> " + e.getValue().getOrder_prod() + " </p>\n" +

                "                            <h6 class=\"text-black\">약사의 한 마디 : " + e.getValue().getOrder_pmsg() + "</h6><br>\n");

                if(e.getValue().getOrder_status().equals("1")){

                    String str =
                        "<div \"width:150px; margin-right: 40px;\">"+

                        "<input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"수거완료\" style=\"width:150px;\" onclick=\"func(\'"+e.getValue().getOrder_no()+"\')\">"+
                        "</div>"+
                                "</div>\n"+
                                "</div>\n"+
                                "</div>\n";
                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("2")){
                    String str = "<div \"width:150px; margin-right: 40px;\">"+
                            "<input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"배달완료\" style=\"width:150px;\" onclick=\"fin(" +
                            + e.getValue().getOrder_no() +
                    ")\">"+
                            "</div>"+
                            "                </div>"+
                            "                </div>"+
                            "                </div>";
                    result.append(str);
                }


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

    public static HashMap<String, Order> getOrders() {
        return orders;
    }
}