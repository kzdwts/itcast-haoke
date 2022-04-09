package cn.itcast.haoke.im.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造用户数据
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
public class UserData {

    public static final Map<Long, User> USER_MAP = new HashMap<>();

    /**
     * 静态块，最先加载
     */
    static {
        USER_MAP.put(1001L, User.builder().id(1001L).username("zhangsan").build());
        USER_MAP.put(1002L, User.builder().id(1002L).username("lisi").build());
        USER_MAP.put(1003L, User.builder().id(1003L).username("wangwu").build());
        USER_MAP.put(1004L, User.builder().id(1004L).username("zhaoliu").build());
        USER_MAP.put(1005L, User.builder().id(1005L).username("tianqi").build());
    }

}
