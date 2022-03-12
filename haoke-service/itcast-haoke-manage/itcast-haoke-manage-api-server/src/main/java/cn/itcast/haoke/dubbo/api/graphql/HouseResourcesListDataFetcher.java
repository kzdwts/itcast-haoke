package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 房源列表查询
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@Component
public class HouseResourcesListDataFetcher implements MyDataFetcher {

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
        return "HouseResourcesList";
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
        Integer page = environment.getArgument("page");
        if (page == null) {
            page = 1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if (pageSize == null) {
            pageSize = 3;
        }
        return this.houseResourcesService.queryList(null, page, pageSize);
    }
}
