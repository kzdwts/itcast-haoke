package cn.itcast.haoke.im.controller;

import cn.itcast.haoke.im.pojo.Message;
import cn.itcast.haoke.im.pojo.User;
import cn.itcast.haoke.im.pojo.UserData;
import cn.itcast.haoke.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 控制层
 *
 * @author Kang Yong
 * @date 2022/4/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private MessageService messageService;

    /**
     * 拉取用户列表
     *
     * @param fromId {@link Long}
     * @return {@link List< Map< String, Object>>}
     * @author Kang Yong
     * @date 2022/4/11
     */
    @GetMapping
    public List<Map<String, Object>> queryUserList(@RequestParam("fromId") Long fromId) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Map.Entry<Long, User> userEntry : UserData.USER_MAP.entrySet()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", userEntry.getValue().getId());
            map.put("avatar", "https://gd1.alicdn.com/imgextra/i1/63986519/O1CN01PbT6Mz1y1kh5ZF7FN_!!63986519.jpg");
            map.put("from_user", fromId);
            map.put("info_type", null);
            map.put("to_user", map.get("id"));
            map.put("username", userEntry.getValue().getUsername());

            // 获取最后一条消息
            List<Message> messages = this.messageService.queryMessageList(fromId, userEntry.getValue().getId(), 1, 1);
            if (messages != null && !messages.isEmpty()) {
                Message message = messages.get(0);
                map.put("chat_msg", message.getMsg());
                map.put("chat_time", message.getSendDate().getTime());
            }
            resultList.add(map);
        }

        return resultList;
    }

}
