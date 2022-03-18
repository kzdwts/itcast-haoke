package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * mock数据控制层
 *
 * @author Kang Yong
 * @date 2022/3/18
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private MockConfig mockConfig;

    /**
     * 菜单
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/index/menu")
    public String indexMenu() {
        return this.mockConfig.getIndexMenu();
    }

    /**
     * 首页资讯
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/index/info")
    public String indexInfo() {
        return this.mockConfig.getIndexInfo();
    }

    /**
     * 首页问答
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/index/faq")
    public String indexFaq() {
        return this.mockConfig.getIndexFaq();
    }

    /**
     * 首页房源信息
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/index/house")
    public String indexHouse() {
        return this.mockConfig.getIndexHouse();
    }

    /**
     * 查询资讯
     *
     * @param type {@link Integer}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/infos/list")
    public String infosList(@RequestParam("type") Integer type) {
        switch (type) {
            case 1:
                return this.mockConfig.getInfosList1();
            case 2:
                return this.mockConfig.getInfosList2();
            case 3:
                return this.mockConfig.getInfosList3();
        }
        return this.mockConfig.getInfosList1();
    }

    /**
     * 我的中心
     *
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @GetMapping("/my/info")
    public String myInfo() {
        return this.mockConfig.getMy();
    }
}
