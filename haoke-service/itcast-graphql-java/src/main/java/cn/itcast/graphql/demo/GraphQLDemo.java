package cn.itcast.graphql.demo;

import cn.itcast.graphql.vo.User;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;

import static graphql.schema.GraphQLObjectType.newObject;

/**
 * graphql java实现
 *
 * @author Kang Yong
 * @date 2022/3/11
 * @since 1.0.0
 */
public class GraphQLDemo {

    /**
     * 定义schema
     * <p>
     * schema { # 定义查询
     *      query: userQuery
     * }
     *
     * @param userDefinition {@link GraphQLFieldDefinition}
     * @return {@link GraphQLSchema}
     * @author Kang Yong
     * @date 2022/3/11
     */
    public static GraphQLSchema createGraphqlSchema(GraphQLFieldDefinition userDefinition) {
        GraphQLObjectType userQuery = newObject().name("userQuery").field(userDefinition).build();
        return GraphQLSchema.newSchema().query(userQuery).build();
    }

    /**
     * 定义查询的类型
     * <p>
     * type UserQuery {
     *      user : User # 指定对象
     * }
     *
     * @param userType {@link GraphQLObjectType}
     * @return {@link GraphQLFieldDefinition}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public static GraphQLFieldDefinition createuserDefinition(GraphQLObjectType userType) {
        return GraphQLFieldDefinition.newFieldDefinition()
                .name("user")
                .type(userType)
                // 静态数据
                .dataFetcher(new StaticDataFetcher(new User(1L, "张三", 20)))
                .build();
    }
}
