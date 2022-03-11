package cn.itcast.graphql.demo;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

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
}
