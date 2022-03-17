package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;

/**
 * 广告业务接口层
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
public interface ApiAdService {

    /**
     * 分页查询广告数据
     *
     * @param type     {@link Integer} 广告类型
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link PageInfo< TbAd>}
     * @author Kang Yong
     * @date 2022/3/17
     */
    PageInfo<TbAd> queryAdList(Integer type, Integer pageNum, Integer pageSize);

}
