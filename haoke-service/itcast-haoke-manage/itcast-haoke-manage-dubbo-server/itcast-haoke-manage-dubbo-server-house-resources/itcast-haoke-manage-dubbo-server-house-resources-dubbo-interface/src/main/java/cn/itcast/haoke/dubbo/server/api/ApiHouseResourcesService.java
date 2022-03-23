package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;

/**
 * 房源信息 业务接口层 gegnxin
 *
 * @author Kang Yong
 * @date 2022/3/5
 * @since 1.0.0
 */
public interface ApiHouseResourcesService {

    /**
     * 保存房源信息
     *
     * @param houseResources {@link HouseResources}
     * @return {@link int} -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     * @author Kang Yong
     * @date 2022/3/5
     */
    int saveHouseResources(HouseResources houseResources);

    /**
     * 分页查询房源列表
     *
     * @param pageNum        {@link int} 当前页
     * @param pageSize       {@link int} 每页条数
     * @param queryCondition {@link HouseResources} 查询条件
     * @return {@link PageInfo< HouseResources>}
     * @author Kang Yong
     * @date 2022/3/8
     */
    PageInfo<HouseResources> queryHouseResourcesList(int pageNum, int pageSize, HouseResources queryCondition);

    /**
     * 根据id查找房源数据
     *
     * @param id {@link Long} 房源id
     * @return {@link HouseResources}
     * @author Kang Yong
     * @date 2022/3/12
     */
    HouseResources queryHouseResourcesById(Long id);

    /**
     * 修改房源信息
     *
     * @param houseResources {@link HouseResources}
     * @return {@link Boolean}
     * @author Kang Yong
     * @date 2022/3/23
     */
    Boolean updateHouseResources(HouseResources houseResources);

}
