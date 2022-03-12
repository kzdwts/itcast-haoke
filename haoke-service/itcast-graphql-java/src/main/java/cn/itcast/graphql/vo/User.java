package cn.itcast.graphql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * user
 *
 * @author Kang Yong
 * @date 2022/3/10
 * @since 1.0.0
 */
@Data
@ToString
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Card card;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(Long id, String name, Integer age, Card card) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.card = card;
    }
}
