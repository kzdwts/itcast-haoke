package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.WebResult;
import cn.itcast.haoke.dubbo.server.pojo.TbAd;
import cn.itcast.haoke.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告业务 控制层
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@RestController
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdService adService;

    /**
     * app首页广告
     *
     * @return {@link WebResult}
     * @author Kang Yong
     * @date 2022/3/17
     */
    @GetMapping
    public WebResult queryIndexAd() {
        // 加载数据
        PageInfo<TbAd> adPageInfo = this.adService.queryAdList(1, 1, 3);
        List<TbAd> adList = adPageInfo.getRecords();

        // 封装结果集
        List<Map<String, Object>> data = new ArrayList<>();
        for (TbAd ad : adList) {
            Map<String, Object> map = new HashMap<>();
            map.put("original", ad.getUrl());
            data.add(map);
        }
        return WebResult.ok(data);
    }
}
