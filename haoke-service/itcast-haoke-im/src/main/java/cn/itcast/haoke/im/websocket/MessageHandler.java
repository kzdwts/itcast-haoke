package cn.itcast.haoke.im.websocket;

import cn.itcast.haoke.im.dao.MessageDao;
import cn.itcast.haoke.im.pojo.Message;
import cn.itcast.haoke.im.pojo.UserData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息处理器
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
@Component
@RocketMQMessageListener(topic = "haoke-im-send-message-topic",
        consumerGroup = "haoke-im-consumer",
        messageModel = MessageModel.BROADCASTING,
        selectorExpression = "SEND_MSG"
)
public class MessageHandler extends TextWebSocketHandler implements RocketMQListener<String> {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final Map<Long, WebSocketSession> SESSION = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long uid = (Long) session.getAttributes().get("uid");
        // 将当前用户的session放置到map中，后面会使用相应的session通信
        SESSION.put(uid, session);

        System.out.println("===afterConnectionEstablished===afterConnectionEstablished");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        Long uid = (Long) session.getAttributes().get("uid");

        JsonNode jsonNode = MAPPER.readTree(textMessage.getPayload());
        long toId = jsonNode.get("toId").asLong();
        String msg = jsonNode.get("msg").asText();

        Message sendMsg = Message.builder()
                .from(UserData.USER_MAP.get(uid))
                .to(UserData.USER_MAP.get(toId))
                .msg(msg)
                .build();

        // 将消息保存到MongoDB
        sendMsg = this.messageDao.saveMessage(sendMsg);

        // 判断to用户是否在线
        WebSocketSession toSession = SESSION.get(toId);
        if (toSession != null && toSession.isOpen()) {
            // 具体格式需要和前端对接 TODO
            toSession.sendMessage(new TextMessage(MAPPER.writeValueAsString(sendMsg)));

            // 更新消息状态为已读
            this.messageDao.updateMessageState(sendMsg.getId(), 2);
        }

    }

    @Override
    public void onMessage(String s) {

    }
}
