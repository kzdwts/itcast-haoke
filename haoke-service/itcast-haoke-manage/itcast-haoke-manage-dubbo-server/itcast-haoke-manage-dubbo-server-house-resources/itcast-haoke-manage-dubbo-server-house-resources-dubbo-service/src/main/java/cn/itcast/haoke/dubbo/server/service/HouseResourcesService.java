package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 房源表，业务接口
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
public interface HouseResourcesService extends IService<HouseResources> {

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
     * @return {@link PageInfo < HouseResources>}
     * @author Kang Yong
     * @date 2022/3/8
     */
    PageInfo<HouseResources> queryHouseResourcesList(int pageNum, int pageSize, HouseResources queryCondition);
}
