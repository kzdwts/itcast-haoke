package cn.itcast.rocketmq.spring;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author Kang Yong
 * @date 2022/5/1
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringRocketMQ extends TestCase {

    @Autowired
    private SpringProducer springProducer;

    @Test
    public void testSendMsg() {
        this.springProducer.sendMsg("my-topic", "第一个spring消息");
    }
}