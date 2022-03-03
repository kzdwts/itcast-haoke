package cn.itcast.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户
 *
 * @author Kang Yong
 * @date 2022/3/3
 * @since 1.0.0
 */
@Data
@ToString
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
