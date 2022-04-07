package cn.itcast.mongodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

/**
 * 面向对象操作
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
public class TestPerson {

    MongoCollection<Person> personMongoCollection;

    @Before
    public void init() {
        System.out.println("===init method exec===");

        // 定义对象的解码注册器
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        // 建立连接
        MongoClient mongoClient = MongoClients.create("mongodb://192.168.100.134:27017");

        // 选择数据库 并且注册解码器
        MongoDatabase mongoDatabase = mongoClient.getDatabase("testdb").withCodecRegistry(pojoCodecRegistry);

        // 选择表
        this.personMongoCollection = mongoDatabase.getCollection("person", Person.class);
    }

    /**
     * 新增
     *
     * @author Kang Yong
     * @date 2022/4/7
     */
    @Test
    public void testInsert() {
        Person person = new Person(ObjectId.get(), "张三", 20, new Address("人民路", "上海市", "666666"));
        this.personMongoCollection.insertOne(person);
        System.out.println("插入数据成功");
    }

}
