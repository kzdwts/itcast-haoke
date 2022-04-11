package cn.itcast.haoke.im.service.impl;

import cn.itcast.haoke.im.dao.MessageDao;
import cn.itcast.haoke.im.pojo.Message;
import cn.itcast.haoke.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息处理
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    /**
     * 查询消息列表
     *
     * @param fromId   {@link Long}
     * @param toId     {@link Long}
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link List <  Message >}
     * @author Kang Yong
     * @date 2022/4/11
     */
    @Override
    public List<Message> queryMessageList(Long fromId, Long toId, Integer pageNum, Integer pageSize) {
        // 查询
        List<Message> messageList = this.messageDao.findListByFromAndTo(fromId, toId, pageNum, pageSize);

        // 修改状态为已读
        for (Message message : messageList) {
            if (message.getStatus().intValue() == 1) {
                // 修改状态为已读
                this.messageDao.updateMessageState(message.getId(), 2);
            }
        }

        // 返回消息
        return messageList;
    }
}
