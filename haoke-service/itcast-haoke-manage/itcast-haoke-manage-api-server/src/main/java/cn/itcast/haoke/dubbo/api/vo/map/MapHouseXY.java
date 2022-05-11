package cn.itcast.haoke.dubbo.api.vo.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 地图上的点
 *
 * @author Kang Yong
 * @date 2022/5/11
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapHouseXY implements Serializable {

    private Float x;
    private Float y;

}
