package cn.itcast.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 实现websocket服务
 *
 * @author Kang Yong
 * @date 2022/3/29
 * @since 1.0.0
 */
@ServerEndpoint("/websocket/{uid}")
public class MyWebSocket {

    /**
     * 该方法将在建立连接后执行，会传入session对象，就是客户端与服务端建立的长连接通道
     *
     * @param session {@link Session}
     * @param uid     {@link String}
     * @author Kang Yong
     * @date 2022/3/29
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) throws IOException {
        System.out.println("建立连接成功");
        // 连接成功
        session.getBasicRemote().sendText(uid + "您好，欢迎链接WebSocket！");
    }

    /**
     * 该方法是在连接关闭后执行
     *
     * @author Kang Yong
     * @date 2022/3/29
     */
    @OnClose
    public void onClose() {
        System.out.println(this + "关闭连接");
    }

    /**
     * 该方法用于接收客户端发来的消息
     *
     * @param message {@link String} 发来的消息数据
     * @param session {@link Session} 会话对象（也是通道）
     * @author Kang Yong
     * @date 2022/3/29
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("接收到消息：" + message);
        session.getBasicRemote().sendText("消息已收到。");
    }

    /**
     * 发生错误时执行
     *
     * @param session {@link Session}
     * @param error   {@link Throwable}
     * @author Kang Yong
     * @date 2022/3/29
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
