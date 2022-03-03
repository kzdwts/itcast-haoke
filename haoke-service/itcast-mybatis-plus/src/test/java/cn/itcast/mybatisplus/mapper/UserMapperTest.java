package cn.itcast.mybatisplus.mapper;


import cn.itcast.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * user 测试
 *
 * @author Kang Yong
 * @date 2022/3/3
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = this.userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectByLike() {
        List<User> userList = this.userMapper.selectList(Wrappers.<User>lambdaQuery()
                .like(User::getName, "o")
        );

        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectByLe() {
        List<User> userList = this.userMapper.selectList(Wrappers.<User>lambdaQuery()
                .le(User::getAge, 20) // 年龄小于等于20的用户
        );

        userList.forEach(System.out::println);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setAge(25);
        user.setEmail("zhangsan@qq.com");
        user.setName("zhangsan");
        int row = this.userMapper.insert(user);
        System.out.println("新增数据，row=" + row);
    }

    @Test
    public void testDelete() {
        int row = this.userMapper.deleteById(7L);
        System.out.println("删除，row=" + row);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setAge(25);
        user.setEmail("lisi@qq.com");
        user.setName("lisi");
        int row = this.userMapper.updateById(user);
        System.out.println("更新数据，row=" + row);
    }

}