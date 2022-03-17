package cn.itcast.haoke.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页信息
 *
 * @author Kang Yong
 * @date 2022/3/8
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class Pagination implements Serializable {
    private Integer current;
    private Integer pageSize;
    private Long total;
}
