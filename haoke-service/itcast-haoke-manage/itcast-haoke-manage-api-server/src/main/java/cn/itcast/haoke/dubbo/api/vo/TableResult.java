package cn.itcast.haoke.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页数据
 *
 * @author Kang Yong
 * @date 2022/3/8
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class TableResult<T> {

    private List<T> list;

    private Pagination pagination;
}
