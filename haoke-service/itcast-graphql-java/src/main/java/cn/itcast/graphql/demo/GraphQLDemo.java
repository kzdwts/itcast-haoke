package cn.itcast.graphql.demo;

import cn.itcast.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.*;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
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
     * query: userQuery
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
     * user : User # 指定对象
     * }
     *
     * @param userType {@link GraphQLObjectType}
     * @return {@link GraphQLFieldDefinition}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public static GraphQLFieldDefinition createUserDefinition(GraphQLObjectType userType) {
        return newFieldDefinition()
                .name("User")
                .type(userType)
//                .dataFetcher(new StaticDataFetcher(new User(1L, "张三", 20))) // 静态数据
                .argument(newArgument().name("id").type(GraphQLLong).build()) // 设置参数
                .dataFetcher(environment -> {
                    Long id = environment.getArgument("id");
                    return new User(id, "张三" + id, 20 + id.intValue());
                })
                .build();
    }

    /**
     * 定义User对象类型
     * <p>
     * type User { # 定义对象
     * id:Long! # ！标识该属性是非空项
     * name:String
     * age:Int
     * }
     *
     * @return {@link GraphQLObjectType}
     * @author Kang Yong
     * @date 2022/3/12
     */
    public static GraphQLObjectType createUserObjectType() {
        return newObject()
                .name("User")
                .field(newFieldDefinition().name("id").type(GraphQLLong))
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("age").type(GraphQLInt))
                .build();
    }

    public static void main(String[] args) {
        GraphQLObjectType userObjectType = createUserObjectType();
        GraphQLFieldDefinition userDefinition = createUserDefinition(userObjectType);

        GraphQL graphQL = GraphQL.newGraphQL(createGraphqlSchema(userDefinition)).build();
        String query = "{User(id:1){id,name,age}}";
        ExecutionResult executionResult = graphQL.execute(query);

        // 打印错误
        System.out.println("错误：" + executionResult.getErrors());
        // 打印数据
        System.out.println("结果：" + executionResult.getData());
    }
}
