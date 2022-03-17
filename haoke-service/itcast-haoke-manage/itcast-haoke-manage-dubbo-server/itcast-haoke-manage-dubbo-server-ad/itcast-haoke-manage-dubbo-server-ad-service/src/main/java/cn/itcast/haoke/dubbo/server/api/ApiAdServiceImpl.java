package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.service.AdService;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 广告业务
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {

    @Autowired
    private AdService adService;

    /**
     * 分页查询广告数据
     *
     * @param type     {@link Integer} 广告类型
     * @param pageNum  {@link Integer} 页码
     * @param pageSize {@link Integer} 每页条数
     * @return {@link PageInfo <  TbAd >}
     * @author Kang Yong
     * @date 2022/3/17
     */
    @Override
    public PageInfo<TbAd> queryAdList(Integer type, Integer pageNum, Integer pageSize) {
        // 设置查询条件
        TbAd ad = new TbAd();
        ad.setType(type);

        // 调用业务查询
        return this.adService.queryAdList(ad, pageNum, pageSize);
    }
}
