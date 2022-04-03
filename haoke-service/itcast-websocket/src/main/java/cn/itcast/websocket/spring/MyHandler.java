package cn.itcast.websocket.spring;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * websocket 处理
 *
 * @author Kang Yong
 * @date 2022/4/2
 * @since 1.0.0
 */
public class MyHandler extends TextWebSocketHandler {

    /**
     * 处理文本消息
     *
     * @param session {@link WebSocketSession}
     * @param message {@link TextMessage}
     * @author Kang Yong
     * @date 2022/4/2
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("获取到消息》》" + message.getPayload());

        session.sendMessage(new TextMessage("消息已收到"));

        if (message.getPayload().equals("10")) {
            for (int i = 0; i < 10; i++) {
                session.sendMessage(new TextMessage("消息 -》 " + i));

                Thread.sleep(100);
            }
        }
    }

    /**
     * 建立连接
     *
     * @param session {@link WebSocketSession}
     * @author Kang Yong
     * @date 2022/4/2
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("uid => " + session.getAttributes().get("uid"));
        session.sendMessage(new TextMessage("欢迎连接到ws服务"));
    }

    /**
     * 断开连接
     *
     * @param session {@link WebSocketSession}
     * @param status  {@link CloseStatus}
     * @author Kang Yong
     * @date 2022/4/2
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("断开链接");
    }
}
