package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.mapper.TbAdMapper;
import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.service.AdService;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 广告业务
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@Service
public class AdServiceImpl extends ServiceImpl<TbAdMapper, TbAd> implements AdService {

    /**
     * 分页查询广告列表
     *
     * @param tbAd     {@link TbAd} 查询条件
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link PageInfo < TbAd>}
     * @author Kang Yong
     * @date 2022/3/17
     */
    @Override
    public PageInfo<TbAd> queryAdList(TbAd tbAd, Integer pageNum, Integer pageSize) {
        // 查询条件
        LambdaQueryWrapper<TbAd> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbAd::getType, tbAd.getType());

        // 查询
        IPage<TbAd> page = this.page(new Page<>(pageNum, pageSize), queryWrapper);
        // 封装查询结果

        PageInfo pageInfo = new PageInfo(page.getTotal(), pageNum, pageSize, page.getRecords());
        return pageInfo;
    }
}
