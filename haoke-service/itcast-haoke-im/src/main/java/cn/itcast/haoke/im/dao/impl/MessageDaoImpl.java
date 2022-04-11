package cn.itcast.haoke.im.dao.impl;

import cn.itcast.haoke.im.dao.MessageDao;
import cn.itcast.haoke.im.pojo.Message;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 消息crud实现
 *
 * @author Kang Yong
 * @date 2022/4/10
 * @since 1.0.0
 */
@Component
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private MongoTemplate mongoTemplate;

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
        Criteria fromList = Criteria.where("from.id").is(fromId).and("to.id").is(toId);
        Criteria toList = Criteria.where("from.id").is(toId).and("to.id").is(fromId);
        Criteria criteria = new Criteria().orOperator(fromList, toList);

        PageRequest pageRequest = PageRequest.of(page - 1, rows, Sort.by(Sort.Direction.ASC, "send_date"));
        Query query = new Query(criteria).with(pageRequest);

        System.out.println(query);

        return this.mongoTemplate.find(query, Message.class);
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
        return this.mongoTemplate.findById(new ObjectId(id), Message.class);
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
        Query query = Query.query(Criteria.where("id").is(id));

        Update update = Update.update("status", status);
        if (status.intValue() == 1) {
            update.set("send_date", new Date());
        } else if (status.intValue() == 2) {
            update.set("read_date", new Date());
        }
        return this.mongoTemplate.updateFirst(query, update, Message.class);
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
        message.setId(ObjectId.get());
        message.setSendDate(new Date());
        message.setStatus(1);
        return this.mongoTemplate.save(message);
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
        Query query = Query.query(Criteria.where("id").is(id));
        return this.mongoTemplate.remove(query, Message.class);
    }

}
