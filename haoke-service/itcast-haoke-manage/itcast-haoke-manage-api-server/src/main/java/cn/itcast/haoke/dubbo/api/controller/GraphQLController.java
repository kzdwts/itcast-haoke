package cn.itcast.haoke.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * 房源查询
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@CrossOrigin // 允许跨域
@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * graphql-java 动态查询信息
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

    /**
     * graphql-java 动态查询信息(post)
     *
     * @param json {@link String}
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @PostMapping
    public Map<String, Object> postGraphql(@RequestBody String json) throws IOException {
        JsonNode jsonNode = MAPPER.readTree(json);
        if (jsonNode.has("query")) {
            String query = jsonNode.get("query").asText();
            return this.graphQL.execute(query).toSpecification();
        }
        return null;
    }
}
