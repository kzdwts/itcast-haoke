package cn.itcast.haoke.dubbo.server.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基类，所有的pojo类都要继承该类
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@Data
public class BasePojo implements Serializable {

    private Date created;
    private Date updated;
}
