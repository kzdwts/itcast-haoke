package cn.itcast.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * 生产者
 *
 * @author Kang Yong
 * @date 2022/4/15
 * @since 1.0.0
 */
public class SyncProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        producer.setNamesrvAddr("192.168.100.134:9876");
        // 启动
        producer.start();

        // 发送消息
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicTest11",
                    "TagA",
                    ("Hello RoekcetMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );

            SendResult sendResult = producer.send(msg);
            System.out.println("结果： " + sendResult);
        }

        producer.shutdown();
    }

}
