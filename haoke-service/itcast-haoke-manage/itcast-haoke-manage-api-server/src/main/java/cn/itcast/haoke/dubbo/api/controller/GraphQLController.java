package cn.itcast.haoke.dubbo.api.controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 房源查询
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    /**
     * graphql-java 动态查询房源信息
     *
     * @param query {@link String}
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @GetMapping
    public Map<String, Object> graphql(@RequestParam("query") String query) {
        return this.graphQL.execute(query).toSpecification();
    }
}
