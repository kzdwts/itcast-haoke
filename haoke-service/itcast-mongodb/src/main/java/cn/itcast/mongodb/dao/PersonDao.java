package cn.itcast.mongodb.dao;

import cn.itcast.mongodb.Person;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * mongodb PersonDao
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
@Component
public class PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存
     *
     * @param person {@link Person}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public void savePerson(Person person) {
        this.mongoTemplate.save(person);
    }

    /**
     * 根据id查询
     *
     * @param id {@link String}
     * @return {@link Person}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public Person queryById(String id) {
        List<Person> personList = this.mongoTemplate.find(
                Query.query(Criteria.where("id").is(id))
                , Person.class
        );

        if (CollectionUtils.isEmpty(personList)) {
            return null;
        }
        return personList.get(0);
    }

    /**
     * 根据name查询
     *
     * @param name {@link String}
     * @return {@link List< Person>}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public List<Person> queryPersonListByName(String name) {
        Query query = Query.query(Criteria.where("name").is(name));
        return this.mongoTemplate.find(query, Person.class);
    }

    /**
     * 分页查询
     *
     * @param page {@link Integer}
     * @param rows {@link Integer}
     * @return {@link List< Person>}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public List<Person> queryPersonListByName(Integer page, Integer rows) {
        Query query = new Query().limit(rows).skip((page - 1) * rows);
        return this.mongoTemplate.find(query, Person.class);
    }

    /**
     * 更新
     *
     * @param person {@link Person}
     * @return {@link UpdateResult}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public UpdateResult update(Person person) {
        Query query = Query.query(Criteria.where("id").is(person.getId()));
        Update update = Update.update("age", person.getAge());
        return this.mongoTemplate.updateFirst(query, update, Person.class);
    }

    /**
     * 根据id删除
     *
     * @param id {@link String}
     * @return {@link DeleteResult}
     * @author Kang Yong
     * @date 2022/4/8
     */
    public DeleteResult deleteById(String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return this.mongoTemplate.remove(query, Person.class);
    }

}
