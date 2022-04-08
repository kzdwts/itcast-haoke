package cn.itcast.mongodb.dao;

import cn.itcast.mongodb.Address;
import cn.itcast.mongodb.Person;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void savePerson() {
        Person person = new Person(ObjectId.get(), "张三", 28, new Address("人民路", "上海市", "233000"));
        this.personDao.savePerson(person);
    }

    @Test
    public void queryPersonListByName() {
        List<Person> personList = this.personDao.queryPersonListByName("张三");
        personList.forEach(System.out::println);
    }

    @Test
    public void testQueryPersonListByName() {
        List<Person> personList = this.personDao.queryPersonListByName(1, 2);
        personList.forEach(System.out::println);
    }

    @Test
    public void queryById() {
        Person person = this.personDao.queryById("6250424c2d66197bb2940352");
        System.out.println(person);
    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId(new ObjectId("6250424c2d66197bb2940352"));
        person.setAge(18);
        person.setName("王丽丽");
        UpdateResult updateResult = this.personDao.update(person);
        System.out.println(updateResult);
    }

    @Test
    public void deleteById() {
        DeleteResult deleteResult = this.personDao.deleteById("6250424c2d66197bb2940352");
        System.out.println(deleteResult);
    }
}