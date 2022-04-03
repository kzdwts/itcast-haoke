package cn.itcast.websocket.spring;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 握手拦截器
 *
 * @author Kang Yong
 * @date 2022/4/3
 * @since 1.0.0
 */
@Component
public class MyHandshakeInterceptor implements HandshakeInterceptor {

    /**
     * 握手之前的业务处理
     * 若返回false，则不建立连接
     *
     * @param request    {@link ServerHttpRequest}
     * @param response   {@link ServerHttpResponse}
     * @param wsHandler  {@link WebSocketHandler}
     * @param attributes {@link Map< String}
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2022/4/3
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 将用户id放入socket处理器的会话（WebSocketSession）中
        attributes.put("uid", 1001);
        System.out.println("===开始握手===");
        return false;
    }

    /**
     * 握手之后的处理逻辑
     *
     * @param serverHttpRequest  {@link ServerHttpRequest}
     * @param serverHttpResponse {@link ServerHttpResponse}
     * @param webSocketHandler   {@link WebSocketHandler}
     * @param e                  {@link Exception}
     * @author Kang Yong
     * @date 2022/4/3
     */
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("===握手成功啦。。。");
    }
}
