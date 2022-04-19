package cn.itcast.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * 发送消息 异步
 *
 * @author Kang Yong
 * @date 2022/4/19
 * @since 1.0.0
 */
public class AsyncProducer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test-group");
        producer.setNamesrvAddr("192.168.100.134:9876");
        // 发送失败的重试次数
        producer.setRetryTimesWhenSendAsyncFailed(0);

        // 启动
        producer.start();

        String msgStr = "用户A发送消息给用户B";
        Message msg = new Message("haoke_im_topic", "SEND_MSG", msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));

        // 异步发送消息
        producer.send(msg, new SendCallback() {

            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息状态：" + sendResult.getSendStatus());
                System.out.println("消息id：" + sendResult.getMsgId());
                System.out.println("消息queue：" + sendResult.getMessageQueue());
                System.out.println("消息offset：" + sendResult.getQueueOffset());
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });

        // 一步发送，这里不能shutdown，否则还未来得及发送，就被关闭了
//        producer.shutdown();
    }

}
