package cn.itcast.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * topic demo
 *
 * @author Kang Yong
 * @date 2022/4/17
 * @since 1.0.0
 */
public class TopicDemo {

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("HAOKE_IM");
        producer.setNamesrvAddr("192.168.100.134:9876");
        // 启动
        producer.start();

        producer.createTopic("broker_haoke_im", "haoke_im_topic", 8);
        System.out.println("创建topic成功：");

        producer.shutdown();
    }

}
