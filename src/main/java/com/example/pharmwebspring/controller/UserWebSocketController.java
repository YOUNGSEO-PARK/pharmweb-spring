package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Order;
import org.springframework.stereotype.Component;

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
@ServerEndpoint(value = "/userWebSocket")
public class UserWebSocketController {

    private int id;
    private String userID;
    private Session session;

    private static int loginNumber;
    public static HashMap<Integer, Order> orders;
    public static HashMap<Integer, UserWebSocketController> users;

    static {
        loginNumber = 0;
        orders = new HashMap<>();
        users = new HashMap<>();
    }

    @OnOpen
    public void onOpen(Session session) {
        id = loginNumber++;
        this.session = session;
        users.put(id, this);
        requestOrderList();
        System.out.println("Enter : " + id);
    }

    @OnClose
    public void onClose(Session session) {
        users.remove(id);
        System.out.println("Exit : " + id);
    }

    @OnMessage
    public void onMessage(String message) {
        if (message.charAt(0) == ':') {
            userID = message.substring(1);
            System.out.println("ENTER : " + userID);
            return;
        }

        Order order = new Order();
        order.setOrder_no(Integer.parseInt(message));


        //remove query
        orderService.deleteOrder(order);
        updateOrderList();

        PharmacistWebSocketController.updateOrderList();
        RiderWebSocketController.orders.remove(message);
        RiderWebSocketController.updateOrderList();
        requestOrderList();
    }

    public void requestOrderList() {
        try {
            orders = getOrders();
            StringBuilder result = new StringBuilder();

            for (Map.Entry<Integer, Order> e : orders.entrySet()) {
                result.append("<tr>\n" +
                        "                                        <td>\n" +
                        "                                            <img src=\"images/product_02.png\" alt=\"Image\" class=\"img-fluid\">\n" +
                        "                                        </td>\n" +
                        "                                        <td>\n" +
                                "                                    <p>주문자 아이디 :" + e.getValue().getOrder_user_id() + " </p>\n" +
                        "                                            <p>주문번호 :" + e.getValue().getOrder_no() + " </p>\n" +
                        "                                            <p>상품명 :" + e.getValue().getOrder_prod() + " </p>\n" +
                        "                                            <p>가격 : 29000원</p>\n" +
                        "                                            <p>일시 : 2020.10.29 16:05시</p>\n" +
                        "                                            <br>\n" +
                        "                                            <div class=\"border mb-2\">\n" +
                        "                                                <h3 class=\"h6 mb-0\"><a class=\"d-block\" style=\"padding:20px;\" data-toggle=\"collapse\" href=\"#collapsepaypal\" role=\"button\"\n" +
                        "                                                                       aria-expanded=\"false\" aria-controls=\"collapsepaypal\">약사의 말 한마디</a></h3>\n" +
                        "\n" +
                        "                                                <div class=\"collapse\" id=\"collapsepaypal\">\n" +
                        "                                                    <div class=\"py-2 px-4\">\n" +
                        "                                                        <p class=\"mb-0\">" + e.getValue().getOrder_pmsg() + "</p>\n" +
                        "                                                    </div>\n" +
                        "                                                </div>\n" +
                        "                                            </div>\n");

                if(e.getValue().getOrder_status().equals("0")){

                    String str =
                            "</td>\n" +
                                    "                                        <td>주문 완료</td>\n" +
                                    "                                    " +
                                    " <td><input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"youngseo(" +
                                    e.getValue().getOrder_no() +
                                    ")\"> </td></tr>";
                    result.append(str);
                }else if(e.getValue().getOrder_status().equals("1")){

                    String str =
                            "</td>\n" +
                                    "                                        <td>배송 대기</td>\n" +
                                    "                                    " +
                                    " <td><input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"youngseo(" +
                                    e.getValue().getOrder_no() +
                                    ")\"> </td></tr>";
                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("2")){
                    String str =  "</td>\n" +
                            "                                        <td>배송 중</td>\n" +
                            "                                    " +
                            " <td><input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"youngseo(" +
                            e.getValue().getOrder_no() +
                            ")\"> </td></tr>";
                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("3")){
                    String str =  "</td>\n" +
                            "                                        <td>배송 완료</td>\n" +
                            "                                    " +
                            " <td><input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"수령 확인\" onclick=\"youngseo(" +
                            e.getValue().getOrder_no() +
                            ")\"> </td></tr>";
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

        for (UserWebSocketController userWebSocketController : users.values()) {
            userWebSocketController.requestOrderList();
        }
    }
    public static HashMap<Integer, Order> getOrders() {

        List<Order> list = orderService.getOrderList();
        System.out.println(list.toString());
        HashMap<Integer, Order> hashMap = new HashMap<>();

        for (Order o : list) {
            hashMap.put(o.getOrder_no(), o);
        }
        return hashMap;
    }
}

