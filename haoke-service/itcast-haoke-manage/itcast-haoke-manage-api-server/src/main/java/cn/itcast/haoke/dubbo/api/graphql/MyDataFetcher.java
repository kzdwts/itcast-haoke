package cn.itcast.haoke.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

/**
 * graphql查询接口层
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
public interface MyDataFetcher {

    /**
     * 查询名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/12
     */
    String fieldName();

    /**
     * 具体实现数据查询的逻辑
     *
     * @param environment {@link DataFetchingEnvironment}
     * @return {@link Object}
     * @author Kang Yong
     * @date 2022/3/12
     */
    Object dataFetcher(DataFetchingEnvironment environment);

}
