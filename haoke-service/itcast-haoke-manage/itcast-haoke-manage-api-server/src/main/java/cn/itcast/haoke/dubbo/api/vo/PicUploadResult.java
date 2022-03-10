package cn.itcast.haoke.dubbo.api.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 图片上传返回实体
 *
 * @author Kang Yong
 * @date 2022/3/7
 * @since 1.0.0
 */
@Data
@ToString
public class PicUploadResult implements Serializable {

    /**
     * 文件唯一标识
     */
    private String uid;

    /**
     * 文件名
     */
    private String name;

    /**
     * 状态： uploading、done、error、removed
     *
     * @see cn.itcast.haoke.dubbo.api.cusEnum.FileUploadStatusEnum
     */
    private String status;

    /**
     * 服务器响应内容
     */
    private String response;
}
