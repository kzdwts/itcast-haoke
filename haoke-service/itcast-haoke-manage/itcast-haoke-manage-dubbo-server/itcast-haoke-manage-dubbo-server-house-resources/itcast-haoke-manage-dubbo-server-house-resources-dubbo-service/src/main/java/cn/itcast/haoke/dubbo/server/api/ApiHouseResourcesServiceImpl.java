package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * dubbo服务，房源业务
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@Service(version = "1.0.0") // 这是dubbo服务，对外进行暴露
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 保存房源信息
     *
     * @param houseResources {@link HouseResources}
     * @return {@link int} -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     * @author Kang Yong
     * @date 2022/3/5
     */
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return this.houseResourcesService.saveHouseResources(houseResources);
    }
}
