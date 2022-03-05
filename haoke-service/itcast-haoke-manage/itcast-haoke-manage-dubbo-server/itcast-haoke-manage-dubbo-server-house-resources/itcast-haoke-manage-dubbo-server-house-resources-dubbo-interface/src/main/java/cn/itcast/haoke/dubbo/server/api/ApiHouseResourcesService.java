package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;

/**
 * 房源信息 业务接口层
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
}
