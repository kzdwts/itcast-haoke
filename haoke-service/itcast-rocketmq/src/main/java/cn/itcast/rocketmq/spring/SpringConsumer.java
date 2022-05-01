package cn.itcast.rocketmq.spring;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author Kang Yong
 * @date 2022/5/1
 * @since 1.0.0
 */
@Component
@RocketMQMessageListener(topic = "my-topic", consumerGroup = "haoke-consumer", selectorExpression = "*")
public class SpringConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        System.out.println("接收到消息-》" + msg);
    }
}
