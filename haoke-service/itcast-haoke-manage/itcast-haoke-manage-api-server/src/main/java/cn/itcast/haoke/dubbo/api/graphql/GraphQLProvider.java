package cn.itcast.haoke.dubbo.api.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * 将GraphQL对象载入到Spring容器
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

//    @Autowired
//    private HouseResourcesService houseResourcesService;

    // 注入容器中MyDataFetcher所有的实现类
    @Autowired
    private List<MyDataFetcher> myDataFetchers;

    /**
     * 初始化
     *
     * @author Kang Yong
     * @date 2022/3/12
     */
    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:haoke.graphqls");
        GraphQLSchema graphQLSchema = this.buildSchema(file);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    /**
     * 构建schema
     *
     * @param file {@link File}
     * @return {@link GraphQLSchema}
     * @author Kang Yong
     * @date 2022/3/12
     */
    private GraphQLSchema buildSchema(File file) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = this.buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery", builder -> {
                    for (MyDataFetcher myDataFetcher : myDataFetchers) {
                        builder.dataFetcher(myDataFetcher.fieldName(), environment ->
                                myDataFetcher.dataFetcher(environment)
                        );
                    }
                    return builder;
                })
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
