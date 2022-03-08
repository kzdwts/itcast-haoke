package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.api.vo.TableResult;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 房源管理 控制层
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("/house/resources")
public class HouseResourcesContrlller {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 新增房源
     *
     * @param houseResources {@link HouseResources} 房源信息
     * @return {@link ResponseEntity< Void>}
     * @author Kang Yong
     * @date 2022/3/6
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources) {
        boolean bool = this.houseResourcesService.save(houseResources);
        if (bool) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 分页查询房源列表
     *
     * @param queryCondition {@link HouseResources}
     * @param currentPage    {@link Integer}
     * @param pageSize       {@link Integer}
     * @return {@link ResponseEntity< TableResult>}
     * @author Kang Yong
     * @date 2022/3/8
     */
    @GetMapping
    public ResponseEntity<TableResult> list(HouseResources queryCondition,
                                            @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.houseResourcesService.queryList(queryCondition, currentPage, pageSize));
    }

//    /**
//     * 测试接口
//     *
//     * @return {@link ResponseEntity< String>}
//     * @author Kang Yong
//     * @date 2022/3/6
//     */
//    @GetMapping
//    public ResponseEntity<String> get() {
//        return ResponseEntity.ok("ok");
//    }
}
