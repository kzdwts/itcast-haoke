package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.mapper.HouseResourcesMapper;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 房源 业务实现层
 *
 * @author Kang Yong
 * @date 2022/3/5
 * @since 1.0.0
 */
@Service
public class HouseResourcesServiceImpl extends ServiceImpl<HouseResourcesMapper, HouseResources> implements HouseResourcesService {
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
        // 编写校验逻辑，如果校验不通过，返回-1
        if (StringUtils.isBlank(houseResources.getTitle())) {
            return -1;
        }

        // 其他校验及逻辑
        boolean save = this.save(houseResources);
        return save ? 1 : 0;
    }
}
