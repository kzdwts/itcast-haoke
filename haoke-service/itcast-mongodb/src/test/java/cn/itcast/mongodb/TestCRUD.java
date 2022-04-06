package cn.itcast.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;

/**
 * crud操作
 *
 * @author Kang Yong
 * @date 2022/4/6
 * @since 1.0.0
 */
public class TestCRUD {

    private MongoCollection<Document> mongoCollection;

    /**
     * 初始化
     *
     * @author Kang Yong
     * @date 2022/4/6
     */
    @Before
    public void init() {
        // 建立连接
        MongoClient mongoClient = MongoClients.create("mongodb://192.168.100.134:27017");

        // 选择数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("testdb");

        // 选择表
        this.mongoCollection = mongoDatabase.getCollection("user");
    }

    /**
     * 查询age<=50并且id>=100的用户信息，
     * 并且按照id倒序排序，
     * 只返回id，age字段，不返回_id字段
     *
     * @author Kang Yong
     * @date 2022/4/6
     */
    @Test
    public void testQuery() {
        this.mongoCollection.find(
                        and(
                                lte("age", 50),
                                gte("id", 100)
                        )
                ).sort(Sorts.descending("id"))
                .projection(
                        Projections.fields(
                                Projections.include("id", "age"),
                                Projections.excludeId()
                        )
                ).forEach((Consumer<? super Document>) document -> {
                    System.out.println(document.toJson());
                });
    }
}
