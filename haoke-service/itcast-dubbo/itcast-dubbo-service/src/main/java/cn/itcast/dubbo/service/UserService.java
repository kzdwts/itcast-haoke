package cn.itcast.dubbo.service;

import cn.itcast.dubbo.pojo.User;

import java.util.List;

/**
 * 用户业务
 *
 * @author Kang Yong
 * @date 2022/3/1
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 查询所有的用户数据
     *
     * @return {@link List< User>}
     * @author Kang Yong
     * @date 2022/3/1
     */
    List<User> queryAll();
}
