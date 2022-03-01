package cn.itcast.dubbo.consumer;

import cn.itcast.dubbo.pojo.User;
import cn.itcast.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试
 *
 * @author Kang Yong
 * @date 2022/3/1
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Test
    public void testQueryAll() {
        List<User> userList = this.userService.queryAll();
        userList.forEach(System.out::println);
    }
}
