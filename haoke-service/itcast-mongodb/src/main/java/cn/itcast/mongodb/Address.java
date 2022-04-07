package cn.itcast.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Address {

    private String street;
    private String city;
    private String zip;

}
