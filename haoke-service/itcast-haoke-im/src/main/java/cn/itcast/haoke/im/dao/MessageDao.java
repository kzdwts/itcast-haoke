package cn.itcast.haoke.im.dao;

import cn.itcast.haoke.im.pojo.Message;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * 消息
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
public interface MessageDao {

    /**
     * 查询点对点聊天记录
     *
     * @param fromId {@link Long} 消息来源
     * @param toId   {@link Long}
     * @param page   {@link Integer}
     * @param rows   {@link Integer}
     * @return {@link List< Message>}
     * @author Kang Yong
     * @date 2022/4/9
     */
    List<Message> findListByFromAndTo(Long fromId, Long toId, Integer page, Integer rows);

    /**
     * 根据id查询数据
     *
     * @param id {@link String}
     * @return {@link Message}
     * @author Kang Yong
     * @date 2022/4/9
     */
    Message findMessageById(String id);

    /**
     * 更新消息状态
     *
     * @param id     {@link ObjectId} 消息id
     * @param status {@link Integer}  消息状态：1-未读，2-已读
     * @return {@link UpdateResult}
     * @author Kang Yong
     * @date 2022/4/9
     */
    UpdateResult updateMessageState(ObjectId id, Integer status);

    /**
     * 新增消息数据
     *
     * @param message {@link Message}
     * @return {@link Message}
     * @author Kang Yong
     * @date 2022/4/9
     */
    Message saveMessage(Message message);

    /**
     * 根据消息id删除数据
     *
     * @param id {@link String} 消息id
     * @return {@link DeleteResult}
     * @author Kang Yong
     * @date 2022/4/9
     */
    DeleteResult deleteMessage(String id);

}
