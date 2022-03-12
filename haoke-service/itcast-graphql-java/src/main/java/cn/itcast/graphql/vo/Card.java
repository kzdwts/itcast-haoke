package cn.itcast.graphql.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * card
 *
 * @author Kang Yong
 * @date 2022/3/12
 * @since 1.0.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private String cardNumber;
    private Long userId;
}
