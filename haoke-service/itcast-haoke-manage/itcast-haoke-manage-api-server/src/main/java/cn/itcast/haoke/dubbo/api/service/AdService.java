package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.vo.WebResult;
import cn.itcast.haoke.dubbo.server.api.ApiAdService;
import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * 广告
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    /**
     * 获取广告分页列表
     *
     * @param type     {@link Integer} 广告类型
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link WebResult}
     * @author Kang Yong
     * @date 2022/3/17
     */
    public PageInfo<TbAd> queryAdList(Integer type, Integer pageNum, Integer pageSize) {
        PageInfo<TbAd> adPageInfo = this.apiAdService.queryAdList(type, pageNum, pageSize);
        return adPageInfo;
    }

}
