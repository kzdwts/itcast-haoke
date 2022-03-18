package cn.itcast.haoke.dubbo.api.vo.ad.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 首页广告结果集
 *
 * @author Kang Yong
 * @date 2022/3/18
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexAdResult implements Serializable {

    private List<IndexAdResultData> list;

}
