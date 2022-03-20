package cn.itcast.haoke.dubbo.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
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
     * @param query         {@link String}
     * @param variablesJson {@link String}
     * @param operationName {@link String}
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/12
     */
    @GetMapping
    public Map<String, Object> graphql(@RequestParam("query") String query,
                                       @RequestParam(value = "variables", required = false) String variablesJson,
                                       @RequestParam(value = "operationName", required = false) String operationName) {
        try {
            Map variables = MAPPER.readValue(variablesJson, MAPPER.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class));
            return this.executeGraphqlQuery(query, operationName, variables);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回结果
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 500);
        resultMap.put("msg", "查询错误");
        return resultMap;
    }

    /**
     * 执行graphql查询
     *
     * @param query
     * @param operationName
     * @param variables
     * @return
     */
    private Map<String, Object> executeGraphqlQuery(String query, String operationName, Map variables) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(variables)
                .build();
        return this.graphQL.execute(executionInput).toSpecification();
    }

    /**
     * graphql-java 动态查询信息(post)
     *
     * @param map {@link Map<String, Object>}
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/18
     */
    @PostMapping
    public Map<String, Object> postGraphql(@RequestBody Map<String, Object> map) throws IOException {
        try {
            // 处理参数
            String query = (String) map.get("query");
            if (null == query) {
                query = "";
            }
            String operationName = (String) map.get("operationName");
            Map variables = (Map) map.get("variables");
            if (null == variables) {
                variables = Collections.EMPTY_MAP;
            }

            // 查询
            return this.executeGraphqlQuery(query, operationName, variables);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回结果
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 500);
        resultMap.put("msg", "查询错误");
        return resultMap;
    }
}
