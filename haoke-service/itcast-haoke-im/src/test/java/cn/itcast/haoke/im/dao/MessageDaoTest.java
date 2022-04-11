package cn.itcast.haoke.im.dao;

import cn.itcast.haoke.im.pojo.Message;
import cn.itcast.haoke.im.pojo.User;
import junit.framework.TestCase;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 消息测试
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageDaoTest extends TestCase {

    @Autowired
    private MessageDao messageDao;

    public void testFindListByFromAndTo() {
    }

    /**
     * 根据id查询消息
     *
     * @author Kang Yong
     * @date 2022/4/11
     */
    @Test
    public void testFindMessageById() {
        Message message = this.messageDao.findMessageById("625435d63b30240fdc254fb9");
        System.out.println(message);
    }

    public void testUpdateMessageState() {
    }

    /**
     * 保存聊天消息
     *
     * @author Kang Yong
     * @date 2022/4/11
     */
    @Test
    public void testSaveMessage() {
        Message message = Message.builder().id(ObjectId.get()).msg("你好").sendDate(new Date()).status(1).from(new User(1001L, "zhangsan")).to(new User(1002L, "lisi")).build();
        this.messageDao.saveMessage(message);
        message = Message.builder().id(ObjectId.get()).msg("你也好").sendDate(new Date()).status(1).to(new User(1001L, "zhangsan")).from(new User(1002L, "lisi")).build();
        this.messageDao.saveMessage(message);
        message = Message.builder().id(ObjectId.get()).msg("我在学习开发IM").sendDate(new Date()).status(1).from(new User(1001L, "zhangsan")).to(new User(1002L, "lisi")).build();
        this.messageDao.saveMessage(message);
        message = Message.builder().id(ObjectId.get()).msg("那很好啊！").sendDate(new Date()).status(1).to(new User(1001L, "zhangsan")).from(new User(1002L, "lisi")).build();
        this.messageDao.saveMessage(message);

        System.out.println("保存消息成功");
    }

    public void testDeleteMessage() {
    }
}