package cn.itcast.haoke.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 广告表
 * </p>
 *
 * @author Kang Yong
 * @since 2022-03-17
 */
@Data
@Accessors(chain = true)
@TableName(value = "tb_ad")
public class TbAd extends BasePojo {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 广告类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String title;

    /**
     * 图片URL地址
     */
    private String url;

}
