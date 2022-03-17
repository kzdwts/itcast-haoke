package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 广告
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
public interface AdService extends IService<TbAd> {

    /**
     * 分页查询广告列表
     *
     * @param tbAd     {@link TbAd} 查询条件
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link PageInfo< TbAd>}
     * @author Kang Yong
     * @date 2022/3/17
     */
    PageInfo<TbAd> queryAdList(TbAd tbAd, Integer pageNum, Integer pageSize);

}
