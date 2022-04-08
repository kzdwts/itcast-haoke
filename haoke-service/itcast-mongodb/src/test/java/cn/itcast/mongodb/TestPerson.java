package cn.itcast.mongodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

    /**
     * 插入多条
     *
     * @author Kang Yong
     * @date 2022/4/8
     */
    @Test
    public void testInserts() {
        List<Person> personList = Arrays.asList(
                new Person(ObjectId.get(), "张三", 20, new Address("人民路", "上海市", "233400")),
                new Person(ObjectId.get(), "李四", 21, new Address("北京西路", "北京市", "233400")),
                new Person(ObjectId.get(), "王五", 24, new Address("东至路", "合肥市", "233400")),
                new Person(ObjectId.get(), "赵六", 23, new Address("新蚌埠路", "蚌埠市", "233400")),
                new Person(ObjectId.get(), "田七", 22, new Address("怀远路", "蚌埠市", "233400"))
        );
        this.personMongoCollection.insertMany(personList);
        System.out.println("插入数据成功");
    }

    /**
     * 查询
     *
     * @author Kang Yong
     * @date 2022/4/8
     */
    @Test
    public void testQuery() {
        this.personMongoCollection.find(
                Filters.eq("name", "张三")
        ).forEach((Consumer<? super Person>) person -> {
            System.out.println(person);
        });
    }

    /**
     * 更新
     *
     * @author Kang Yong
     * @date 2022/4/8
     */
    @Test
    public void testUpdate() {
        UpdateResult updateResult = this.personMongoCollection.updateMany(
                Filters.eq("name", "张三"),
                Updates.set("age", 22)
        );
        System.out.println(updateResult);
    }

    /**
     * 删除
     *
     * @author Kang Yong
     * @date 2022/4/8
     */
    @Test
    public void testDelete() {
        DeleteResult deleteResult = this.personMongoCollection.deleteOne(
                Filters.eq("name", "张三")
        );
        System.out.println(deleteResult);
    }

}
