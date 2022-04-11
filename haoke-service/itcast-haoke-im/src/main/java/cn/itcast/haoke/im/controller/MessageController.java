package cn.itcast.haoke.im.controller;

import cn.itcast.haoke.im.pojo.Message;
import cn.itcast.haoke.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 消息 控制层
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 拉取消息列表
     *
     * @param fromId   {@link Long}
     * @param toId     {@link Long}
     * @param pageNum  {@link Integer}
     * @param pageSize {@link Integer}
     * @return {@link List< Message>}
     * @author Kang Yong
     * @date 2022/4/11
     */
    @GetMapping
    public List<Message> queryMessageList(@RequestParam("fromId") Long fromId,
                                          @RequestParam("toId") Long toId,
                                          @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "rows", defaultValue = "10") Integer pageSize
    ) {
        return this.messageService.queryMessageList(fromId, toId, pageNum, pageSize);
    }


}
