package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.MongoHouseService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 地图数据查询
 *
 * @author Kang Yong
 * @date 2022/5/11
 * @since 1.0.0
 */
@Component
public class MapHouseDataFetcher implements MyDataFetcher {

    @Autowired
    private MongoHouseService mongoHouseService;

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
        Float lng = ((Double) environment.getArgument("lng")).floatValue();
        Float lat = ((Double) environment.getArgument("lat")).floatValue();

        Integer zoom = environment.getArgument("zoom");

        System.out.println("lng->" + lng + ",lat->" + lat + ",zoom->" + zoom);

        return this.mongoHouseService.queryHouseData(lng, lat, zoom);
    }
}
