package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.mapper.HouseResourcesMapper;
import cn.itcast.haoke.dubbo.server.pojo.BasePojo;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 房源表，业务实现层
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@Service // 这里编写的Service是Spring的service，不是dubbo服务，因为需要控制一级一些逻辑
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
        // 其他校验
        boolean save = this.save(houseResources);
        return save ? 1 : 0;
    }

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
    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int pageNum, int pageSize, HouseResources queryCondition) {
        // 查询条件
        LambdaQueryWrapper<HouseResources> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(BasePojo::getUpdated);

        // 执行查询
        IPage<HouseResources> page = this.page(new Page<HouseResources>(pageNum, pageSize), queryWrapper);

        // 返回分页数据
        return new PageInfo<HouseResources>(Long.valueOf(page.getTotal()).intValue(), pageNum, pageSize, page.getRecords());
    }
}
