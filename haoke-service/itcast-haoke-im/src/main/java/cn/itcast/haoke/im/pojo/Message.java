package cn.itcast.haoke.im.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 消息实体
 *
 * @author Kang Yong
 * @date 2022/4/8
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "message")
@Builder
public class Message {

    @Id
    @JsonSerialize(using = ToStringSerializer.class) // 让系统序列化时保留相关精度
    private ObjectId id;

    private String msg;

    /*** 消息状态，1-未读，2-已读 */
    @Indexed
    private Integer status;

    @Field("send_date")
    @Indexed
    private Date sendDate;

    @Field("read_date")
    private Date readDate;

    @Indexed
    private User from;

    @Indexed
    private User to;

}
