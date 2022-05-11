package cn.itcast.haoke.dubbo.api.vo.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 地图数据
 *
 * @author Kang Yong
 * @date 2022/5/11
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapHouseDataResult implements Serializable {

    private List<MapHouseXY> list;

}
