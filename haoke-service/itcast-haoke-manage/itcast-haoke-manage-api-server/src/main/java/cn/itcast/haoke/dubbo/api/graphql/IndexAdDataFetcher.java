package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.ad.index.IndexAdResult;
import cn.itcast.haoke.dubbo.api.vo.ad.index.IndexAdResultData;
import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询
 *
 * @author Kang Yong
 * @date 2022/3/18
 * @since 1.0.0
 */
@Component
public class IndexAdDataFetcher implements MyDataFetcher {

    @Autowired
    private AdService adService;

    /**
     * 查询名称
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @Override
    public String fieldName() {
        return "IndexAdList";
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
        // 查询
        PageInfo<TbAd> pageInfo = this.adService.queryAdList(1, 1, 3);
        List<TbAd> adList = pageInfo.getRecords();

        // 结果集
        List<IndexAdResultData> list = new ArrayList<>();
        for (TbAd ad : adList) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }
        return new IndexAdResult(list);
    }
}
