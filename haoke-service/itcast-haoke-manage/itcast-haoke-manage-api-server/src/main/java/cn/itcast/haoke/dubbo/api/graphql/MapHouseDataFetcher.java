package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.vo.map.MapHouseDataResult;
import cn.itcast.haoke.dubbo.api.vo.map.MapHouseXY;
import graphql.schema.DataFetchingEnvironment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图数据查询
 *
 * @author Kang Yong
 * @date 2022/5/11
 * @since 1.0.0
 */
@Data
public class MapHouseDataFetcher implements MyDataFetcher {

    /**
     * 查询名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @Override
    public String fieldName() {
        return "MapHouseData";
    }

    /**
     * 具体实现数据查询的逻辑
     *
     * @param environment {@link DataFetchingEnvironment}
     * @return {@link Object}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        List<MapHouseXY> list = new ArrayList<>();
        list.add(new MapHouseXY(116.43244f, 39.929986f));
        list.add(new MapHouseXY(116.424355f, 39.92982f));
        list.add(new MapHouseXY(116.423349f, 39.935214f));
        list.add(new MapHouseXY(116.350444f, 39.931645f));
        list.add(new MapHouseXY(116.351684f, 39.91867f));
        list.add(new MapHouseXY(116.353983f, 39.913855f));
        list.add(new MapHouseXY(116.357253f, 39.923152f));
        list.add(new MapHouseXY(116.349168f, 39.923152f));
        list.add(new MapHouseXY(116.36232f, 39.938339f));
        list.add(new MapHouseXY(116.374249f, 39.94625f));
        list.add(new MapHouseXY(116.380178f, 39.953053f));
        return new MapHouseDataResult(list);
    }
}
