package cn.itcast.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/**
 * 面相对象操作类
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private ObjectId id;
    private String name;
    private int age;
    private Address address;

}
