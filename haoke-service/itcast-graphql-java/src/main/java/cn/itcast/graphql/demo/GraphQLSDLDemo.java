package cn.itcast.graphql.demo;

import cn.itcast.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * graphql-sdl java实现
 *
 * @author Kang Yong
 * @date 2022/3/11
 * @since 1.0.0
 */
public class GraphQLSDLDemo {

    /**
     * 定义schema
     * <p>
     * schema { # 定义查询
     * query: userQuery
     * }
     *
     * @param typeDefinitionRegistry {@link TypeDefinitionRegistry}
     * @param wiring                 {@link RuntimeWiring}
     * @return {@link GraphQLSchema}
     * @author Kang Yong
     * @date 2022/3/11
     */
    public static GraphQLSchema createGraphqlSchema(TypeDefinitionRegistry typeDefinitionRegistry, RuntimeWiring wiring) {
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, wiring);
    }

    /**
     * 定义类型的注册器
     *
     * @param fileContent {@link String}
     * @return {@link TypeDefinitionRegistry}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public static TypeDefinitionRegistry createTypeDefinitionRegistry(String fileContent) {
        SchemaParser schemaParser = new SchemaParser();
        return schemaParser.parse(fileContent);
    }

    /**
     * 读取文件内容
     *
     * @param fileName {@link String}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public static String readFileToString(String fileName) {
        try {
            return IOUtils.toString(GraphQLSDLDemo.class.getClassLoader().getResourceAsStream(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RuntimeWiring createRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("UserQuery", typeWiring -> typeWiring
                        .dataFetcher("user", environment -> {
                            Long id = environment.getArgument("id");
                            return new User(id, "张三_" + id, 20 + id.intValue());
                        })
                )
                .build();
    }

    public static void main(String[] args) {
        String fileName = "user.graphqls";
        TypeDefinitionRegistry registry = createTypeDefinitionRegistry(readFileToString(fileName));
        RuntimeWiring runtimeWiring = createRuntimeWiring();

        GraphQL graphQL = GraphQL.newGraphQL(createGraphqlSchema(registry, runtimeWiring)).build();
        String query = "{user(id:1){id,name,age}}";
        ExecutionResult executionResult = graphQL.execute(query);

        System.out.println("查询字符串：" + query);
        // 打印错误
        System.out.println("错误：" + executionResult.getErrors());
        // 打印数据
        System.out.println("结果：" + executionResult.getData());
    }
}
