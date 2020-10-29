package com.example.pharmwebspring.controller;

import com.example.pharmwebspring.Model.Order;
import com.example.pharmwebspring.Model.StatusRes;
import com.example.pharmwebspring.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Component
@ServerEndpoint(value = "/pharmacistWebSocket")
public class PharmacistWebSocketController {
    @Autowired
    static OrderService orderService;

    private int id;
    private Session session;

    private static int loginNumber;
    public static HashMap<Integer, Order> orders;
    public static HashMap<Integer, PharmacistWebSocketController> pharmacist;

    static {
        loginNumber = 0;
        orders = new HashMap<>();
        pharmacist = new HashMap<>();
    }

    @Autowired
    public void setOrderService(OrderService service) {
        orderService = service;
    }

    @OnOpen
    public void onOpen(Session session) {
        id = loginNumber++;
        this.session = session;
        pharmacist.put(id, this);
        requestOrderList();
        System.out.println("Enter : " + id);
    }

    @OnClose
    public void onClose(Session session) {
        pharmacist.remove(id);
        System.out.println("Exit : " + id);
    }

    @OnMessage
    public void onMessage(String message) {
        StringTokenizer tokenizer = new StringTokenizer(message, "/");
        String order_no = tokenizer.nextToken();
        String order_user_id = tokenizer.nextToken();
        String order_name = tokenizer.nextToken();
        String order_adr1 = tokenizer.nextToken();
        String order_adr2 = tokenizer.nextToken();
        String order_prod = tokenizer.nextToken();
        String order_status = tokenizer.nextToken();
//        String msg = tokenizer.nextToken();

        Order order = new Order();
        order.setOrder_no(order_no);
        order.setOrder_user_id(order_user_id);
        order.setOrder_name(order_name);
        order.setOrder_adr1(order_adr1);
        order.setOrder_adr2(order_adr2);
        order.setOrder_status(order_status);

        // status 업데이트하는 쿼리
        order.setOrder_status("1");
        orderService.updateStatus(order);
        //

        updateOrderList();

        //order.setOrder_prod(prod);
        RiderWebSocketController.orders.put(order_no, order);
        RiderWebSocketController.updateOrderList();
        System.out.println(message);
    }

    public void requestOrderList() {
        orders = getOrders();
        StatusRes statusRes = new StatusRes();

        System.out.println("PASS");
        try {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<Integer, Order> e : orders.entrySet()) {
                result.append("<div class=\"container\">\n" +
                        "                    <form name = \" pdeliverform\">\n" +
                        "                    <div class=\" form-group row\" style=\"margin-bottom:20px; padding:20px; border:3px solid #75b239;\">\n" +
                        "                        <div>\n" +
                        "                            <image src=\"images/person_1.jpg\" width=\"200px\" height=\"200px\"></image>\n" +
                        "                        </div>\n" +
                        "                        <div style=\"padding-left: 100px;\">\n" +
                        "                            <h4 class=\"text-black\"><b>주문번호 : " + e.getValue().getOrder_no() +"</b></h4>\n" +
                        "                            <br>\n" +
                        "                            <p class=\"text-black\">주문자 아이디 : " + e.getValue().getOrder_user_id() + "</p>\n" +
                        "                            <p class=\"text-black\">주문자 이름 : " + e.getValue().getOrder_name() + "</p>\n" +
                        "                            <p class=\"text-black\">주문자 주소 : " + e.getValue().getOrder_adr1() + " " + e.getValue().getOrder_adr2() + " </p>\n" +
                        "                            <p class=\"text-black\">주문내역 <br> " + e.getValue().getOrder_prod() + " </p>\n" +
                        "                            <div class=\"form-group\">\n" +
                        "                                <label for=\"p_order_note1\" class=\"text-black\">약사의 한 마디</label>\n" +
                        "                                <textarea id=\"" + e.getValue().getOrder_no() +"\" name=\"p_order_note1\" id=\"p_order_note1\" cols=\"80\" rows=\"5\"\n" +
                        "                                          class=\"form-control\"\n" +
                        "                                          placeholder=\"환자에게 전할 말이 있으시면 작성해주세요.\"></textarea>\n" +
                        "                            </div>\n");

                                                    if(e.getValue().getOrder_status().equals("0")){

                                                        String str =
                        "                            <div class=\"form-group row\" style=\"float: right\">\n" +
                        "                                <div class=\"col-lg-6\">\n" +
                        "                                    <input type=\"button\" id=\"deliveryBtn\" class=\"btn btn-primary btn-lg btn-block\" value=\"라이더 호출\" onclick=\"sendToRider(\'"
                                                                                                                        + e.getValue().getOrder_no() + "\'"
                                                                                                                        + " ," + " \'" + e.getValue().getOrder_user_id()
                                                                                                                        + "\' , \'" + e.getValue().getOrder_name()
                                                                                                                        + "\', \'" + e.getValue().getOrder_adr1()
                                                                                                                        + "\', \'" + e.getValue().getOrder_adr2()
                                                                                                                        + "\',\'" + e.getValue().getOrder_prod() + "\')\">\n" +
                        "                                </div>\n"+
                                "<div class=\"col-lg-6\">\n" +
                                "                                    <input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"배달 불가\">\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                   </form>\n" +
                                "                </div>";
                                                        result.append(str);

                                                            } else {
                                                        String str = "<div class=\"col-lg-6\">\n" +
                                                                "                                    " +
                                                                "<input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" value=\"배달 대기\">\n"+
                                                                "</div>" +
                                                                "</div>" +
                                                                "</div>" +
                                                                "</form>" +
                                                                "</div>";
                                                        result.append(str);
                                                    }

                //statusRes.setStatus(700);
            }
            session.getBasicRemote().sendText(result.toString());
        } catch (Exception e) {
            System.out.println("Exception ID : " + id);
            e.printStackTrace();
        }
    }

    public static void updateOrderList() {
        orders = getOrders();
        for (PharmacistWebSocketController pharmacistWebSocketController : pharmacist.values()) {
            pharmacistWebSocketController.requestOrderList();
        }
    }

    public static HashMap<Integer, Order> getOrders() {
        List<Order> list = orderService.getOrderList();
        System.out.println(list.toString());
        HashMap<Integer, Order> hashMap = new HashMap<>();

        for (int i = 0;i < list.size();++i) {
            hashMap.put(i, list.get(i));
        }
        return hashMap;
    }
}