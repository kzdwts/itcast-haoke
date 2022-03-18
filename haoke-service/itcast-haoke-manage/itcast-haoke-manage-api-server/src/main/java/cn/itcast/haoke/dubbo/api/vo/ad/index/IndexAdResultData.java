package cn.itcast.haoke.dubbo.api.vo.ad.index;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 首页广告数据
 *
 * @author Kang Yong
 * @date 2022/3/18
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexAdResultData implements Serializable {

    private String original;
}
