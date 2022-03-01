package cn.itcast.dubbo.service.impl;

import cn.itcast.dubbo.pojo.User;
import cn.itcast.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务
 *
 * @author Kang Yong
 * @date 2022/3/1
 * @since 1.0.0
 */
@Service(version = "${dubbo.service.version}") // 声明这是一个dubbo服务
public class UserServiceImpl implements UserService {

    /**
     * 查询所有的用户数据
     *
     * @return {@link List <  User >}
     * @author Kang Yong
     * @date 2022/3/1
     */
    @Override
    public List<User> queryAll() {
        List<User> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setId(Long.valueOf(1 + i));
            user.setUsername("王_" + i);
            user.setPassword("123456");
            resultList.add(user);
        }
        return resultList;
    }
}
