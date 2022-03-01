package cn.itcast.dubbo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户对象
 * 使用dubbo要求传输的对象必须实现序列化接口
 *
 * @author Kang Yong
 * @date 2022/3/1
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer age;
}
