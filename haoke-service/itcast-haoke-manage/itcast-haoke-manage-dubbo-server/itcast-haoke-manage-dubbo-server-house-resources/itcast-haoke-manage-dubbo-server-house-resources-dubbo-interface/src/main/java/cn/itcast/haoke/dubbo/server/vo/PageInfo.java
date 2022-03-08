package cn.itcast.haoke.dubbo.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页信息
 *
 * @author Kang Yong
 * @date 2022/3/8
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();

}
