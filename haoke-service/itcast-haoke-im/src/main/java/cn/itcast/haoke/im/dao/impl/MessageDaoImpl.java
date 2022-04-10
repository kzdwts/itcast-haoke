package cn.itcast.haoke.im.dao.impl;

import cn.itcast.haoke.im.dao.MessageDao;
import cn.itcast.haoke.im.pojo.Message;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * 消息crud实现
 *
 * @author Kang Yong
 * @date 2022/4/10
 * @since 1.0.0
 */
public class MessageDaoImpl implements MessageDao {

    /**
     * 查询点对点聊天记录
     *
     * @param fromId {@link Long} 消息来源
     * @param toId   {@link Long}
     * @param page   {@link Integer}
     * @param rows   {@link Integer}
     * @return {@link List <  Message >}
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Override
    public List<Message> findListByFromAndTo(Long fromId, Long toId, Integer page, Integer rows) {
        return null;
    }

    /**
     * 根据id查询数据
     *
     * @param id {@link String}
     * @return {@link Message}
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Override
    public Message findMessageById(String id) {
        return null;
    }

    /**
     * 更新消息状态
     *
     * @param id     {@link ObjectId} 消息id
     * @param status {@link Integer}  消息状态：1-未读，2-已读
     * @return {@link UpdateResult}
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Override
    public UpdateResult updateMessageState(ObjectId id, Integer status) {
        return null;
    }

    /**
     * 新增消息数据
     *
     * @param message {@link Message}
     * @return {@link Message}
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Override
    public Message saveMessage(Message message) {
        return null;
    }

    /**
     * 根据消息id删除数据
     *
     * @param id {@link String} 消息id
     * @return {@link DeleteResult}
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Override
    public DeleteResult deleteMessage(String id) {
        return null;
    }
}
