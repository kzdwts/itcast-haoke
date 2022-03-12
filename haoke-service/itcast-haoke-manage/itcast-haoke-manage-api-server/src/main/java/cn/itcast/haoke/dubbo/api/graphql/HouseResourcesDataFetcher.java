package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * graphql查询实现类
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@Component
public class HouseResourcesDataFetcher implements MyDataFetcher {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 查询名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @Override
    public String fieldName() {
        return "HouseResources";
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
        Long id = environment.getArgument("id");
        return this.houseResourcesService.queryById(id);
    }
}
