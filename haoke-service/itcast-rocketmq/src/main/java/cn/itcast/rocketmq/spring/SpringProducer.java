package cn.itcast.rocketmq.spring;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者发送消息
 *
 * @author Kang Yong
 * @date 2022/5/1
 * @since 1.0.0
 */
@Component
public class SpringProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     *
     * @param topic {@link String}
     * @param msg   {@link String} 消息内容
     * @author Kang Yong
     * @date 2022/5/1
     */
    public void sendMsg(String topic, String msg) {
        this.rocketMQTemplate.convertAndSend(topic, msg);
    }
}
