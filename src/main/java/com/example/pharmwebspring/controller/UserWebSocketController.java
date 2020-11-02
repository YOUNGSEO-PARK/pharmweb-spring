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

    public static String userId;
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
        if (message.charAt(0) == '#') {
            String orderNo = message.substring(1);
            Order order = new Order();
            order.setOrder_no(Integer.parseInt(orderNo));
            order.setOrder_status("6");
            orderService.updateStatus(order);
            updateOrderList();
            PharmacistWebSocketController.updateOrderList();
            return;
        }
        System.out.println("Message is " + message);
        if (message.charAt(0) == ':') {
            userID = message.substring(1);
            System.out.println("ENTER : " + userID);
            return;
        }

        Order order = new Order();
        order.setOrder_no(Integer.parseInt(message));


        order.setOrder_status("4");

        orderService.updateStatus(order);
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
                                "                                    <p>주문번호 : " + e.getValue().getOrder_no() + " </p>\n" +
                                "                                    <p>주문자 아이디 : " + e.getValue().getOrder_user_id() + " </p>\n" +
                        "                                            <p>상품명 : " + e.getValue().getOrder_prod() + " </p>\n" +
                        "                                            <p>가격 : 29000원</p>\n" +
                        "                                            <p>일시 : " + e.getValue().getOrder_time() + "</p>\n" +
                        "                                            <br>\n" +
                        "                                            <div class=\"border mb-2\">\n" +
                        "                                                <h3 class=\"h6 mb-0\"><a class=\"d-block\" style=\"padding:20px;\" data-toggle=\"collapse\" href=\"#"+ e.getValue().getOrder_user_id() +e.getValue().getOrder_no() +"\" role=\"button\"\n" +
                        "                                                                       aria-expanded=\"false\" aria-controls="+ e.getValue().getOrder_user_id() + e.getValue().getOrder_no() +">약사의 말 한마디</a></h3>\n" +
                        "\n" +
                        "                                                <div class=\"collapse\" id="+ e.getValue().getOrder_user_id() + e.getValue().getOrder_no() +">\n" +
                        "                                                    <div class=\"py-2 px-4\">\n" +
                        "                                                        <p class=\"mb-0\">" + e.getValue().getOrder_pmsg() + "</p>\n" +
                        "                                                    </div>\n" +
                        "                                                </div>\n" +
                        "                                            </div>\n");

                if(e.getValue().getOrder_status().equals("0")){

                    String str =
                            "</p>\n" +
                                    "                                  </div>\n" +
                                    "                                </div>\n" +
                                    "                              </div>\n" +
                                    "                            </td>\n" +
                                    "                            <td>\n" +
                                    "                              <h5>주문 완료</h5>\n" +
                                    "                              <br> \n" +
                                    "                              <input type=\"button\" style=\"font-size:medium;\"class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"refund('" + e.getValue().getOrder_no() + "')\">\n" +
                                    "                            </input>\n" +
                                    "                            </td>\n" +
                                    "                          </tr>         ";
                    result.append(str);
                }else if(e.getValue().getOrder_status().equals("1")){

                    String str =
                            "</p>\n" +
                                    "                                  </div>\n" +
                                    "                                </div>\n" +
                                    "                              </div>\n" +
                                    "                            </td>\n" +
                                    "                            <td>\n" +
                                    "                              <h5>배송 대기</h5>\n" +
                                    "                              <br> \n" +
                                    "                              <input type=\"button\" style=\"font-size:medium;\"class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"refund('" + e.getValue().getOrder_no() + "')\">\n" +
                                    "                            </input>\n" +
                                    "                            </td>\n" +
                                    "                          </tr>         ";
                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("2")){
                    String str =  "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>배송 중</h5>\n"+
                            "                            </td>\n" +
                            "                          </tr>         ";
                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("3")) {
                    String str = "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>배송 완료</h5>\n" +
                            "                              <br> \n" +
                            "                              <input type=\"button\" style=\"font-size:medium;\"class=\"btn btn-primary btn-lg btn-block\" value=\"구매 확정\" onclick=\"youngseo('" +e.getValue().getOrder_no()+ "')\">" +
                            "                            </input>\n" +
                            "                            </td>\n" +
                            "                          </tr>         ";

                    result.append(str);

                } else if(e.getValue().getOrder_status().equals("4")) {
                    String str = "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>구매 확정</h5>\n" +
                            "                            </td>\n" +
                            "                          </tr>         ";

                    result.append(str);
                } else if(e.getValue().getOrder_status().equals("5")) {
                    String str = "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>구매 불가</h5>\n"  +
                            "                              <input type=\"button\" style=\"font-size:medium;\"class=\"btn btn-primary btn-lg btn-block\" value=\"환불 신청\" onclick=\"refund('" + e.getValue().getOrder_no() + "')\">\n" +
                            "                            </input>\n" +
                            "                            </td>\n" +
                            "                          </tr>         ";

                    result.append(str);
                } else if (e.getValue().getOrder_status().equals("6")) {
                    String str = "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>환불 대기</h5>\n" +
                            "                            </td>\n" +
                            "                          </tr>         ";

                    result.append(str);
                } else if (e.getValue().getOrder_status().equals("7")) {
                    String str = "</p>\n" +
                            "                                  </div>\n" +
                            "                                </div>\n" +
                            "                              </div>\n" +
                            "                            </td>\n" +
                            "                            <td>\n" +
                            "                              <h5>환불 완료</h5>\n" +
                            "                            </td>\n" +
                            "                          </tr>         ";

                    result.append(str);
                }
            }

            session.getBasicRemote().sendText(result.toString());
        } catch (Exception e) {
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

        List<Order> list = orderService.getOrderByIdList(userId);
        System.out.println(list.toString());
        HashMap<Integer, Order> hashMap = new HashMap<>();

        for (Order o : list) {
            hashMap.put(o.getOrder_no(), o);
        }
        return hashMap;
    }
}

