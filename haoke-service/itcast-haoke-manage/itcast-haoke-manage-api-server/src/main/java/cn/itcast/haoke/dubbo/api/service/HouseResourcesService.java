package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.vo.Pagination;
import cn.itcast.haoke.dubbo.api.vo.TableResult;
import cn.itcast.haoke.dubbo.server.api.ApiHouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * 房源 dubbo服务
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    /**
     * 保存房源信息
     *
     * @param houseResources {@link HouseResources}
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2022/3/6
     */
    public boolean save(HouseResources houseResources) {
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

    /**
     * 分页查询房源列表
     *
     * @param queryCondition {@link HouseResources}
     * @param currentPage    {@link Integer}
     * @param pageSize       {@link Integer}
     * @return {@link TableResult}
     * @author Kang Yong
     * @date 2022/3/8
     */
    public TableResult queryList(HouseResources queryCondition, Integer currentPage, Integer pageSize) {
        // 调用查询服务
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, queryCondition);
        // 返回分页数据
        return new TableResult(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    /**
     * 根据id查找房源数据
     *
     * @param id {@link Long} 房源id
     * @return {@link HouseResources}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public HouseResources queryById(Long id) {
        return this.apiHouseResourcesService.queryHouseResourcesById(id);
    }
}
