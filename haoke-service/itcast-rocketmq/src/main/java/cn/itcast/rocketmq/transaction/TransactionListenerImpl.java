package cn.itcast.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地事务
 *
 * @author Kang Yong
 * @date 2022/4/28
 * @since 1.0.0
 */
public class TransactionListenerImpl implements TransactionListener {

    private static Map<String, LocalTransactionState> STATE_MAP = new HashMap<>();

    /**
     * 执行具体的业务逻辑
     *
     * @param msg {@link Message}
     * @param o   {@link Object}
     * @return {@link LocalTransactionState}
     * @author Kang Yong
     * @date 2022/4/28
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object o) {
        System.out.println("===executeLocalTransaction===执行具体的业务逻辑===");
        try {
            System.out.println("用户A转账减500元");
            Thread.sleep(500);

//            System.out.println(1/0);

            System.out.println("用户B账户加500元");
            Thread.sleep(800);

            STATE_MAP.put(msg.getTransactionId(), LocalTransactionState.COMMIT_MESSAGE);

            // 二次提交确认
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        STATE_MAP.put(msg.getTransactionId(), LocalTransactionState.ROLLBACK_MESSAGE);
        // 回滚
        return LocalTransactionState.ROLLBACK_MESSAGE;

    }

    /**
     * 消息回查
     *
     * @param messageExt {@link MessageExt}
     * @return {@link LocalTransactionState}
     * @author Kang Yong
     * @date 2022/4/28
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        System.out.println("===checkLocalTransaction===消息回查===");

        return STATE_MAP.get(messageExt.getTransactionId());
    }
}
