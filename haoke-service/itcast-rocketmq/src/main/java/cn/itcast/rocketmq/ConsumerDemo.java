package cn.itcast.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 消费消息
 *
 * @author Kang Yong
 * @date 2022/4/20
 * @since 1.0.0
 */
public class ConsumerDemo {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("HAOKE_IM");
        consumer.setNamesrvAddr("192.168.100.134:9876");

        // 订阅topic，接受此Topic下的所有消息
//        consumer.subscribe("haoke_im_topic", "*");
        consumer.subscribe("my-test-topic", "*");

        // 其它订阅方式
        // 完整匹配
        consumer.subscribe("haoke_im_topic", "SEND_MSG");

        // 或匹配
        consumer.subscribe("haoke_im_topic", "SEND_MSG || SEND_MSG1");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg :
                        msgs) {
                    try {
                        System.out.println(new String(msg.getBody(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("收到消息-》" + msgs);

                if (msgs.get(0).getReconsumeTimes() >= 3) {
                    // 重试3次后，不再进行重试
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }

                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });

        consumer.start();
    }

}
