package cn.itcast.haoke.im.service;

import cn.itcast.haoke.im.pojo.Message;

import java.util.List;

/**
 * 消息业务
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
public interface MessageService {

    /**
     * 查询消息列表
     *
     * @param fromId   {@link Long}
     * @param toId     {@link Long}
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link List< Message>}
     * @author Kang Yong
     * @date 2022/4/11
     */
    List<Message> queryMessageList(Long fromId, Long toId, Integer pageNum, Integer pageSize);
}
