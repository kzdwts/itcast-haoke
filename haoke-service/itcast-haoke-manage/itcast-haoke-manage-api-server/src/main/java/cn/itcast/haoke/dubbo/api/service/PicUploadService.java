package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.api.config.AliyunConfig;
import cn.itcast.haoke.dubbo.api.cusEnum.FileUploadStatusEnum;
import cn.itcast.haoke.dubbo.api.vo.PicUploadResult;
import com.aliyun.oss.OSS;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 文件上传业务实现
 *
 * @author Kang Yong
 * @date 2022/3/7
 * @since 1.0.0
 */
@Service
public class PicUploadService {

    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;

    public PicUploadResult upload(MultipartFile uploadFile) {
        // 结果集
        PicUploadResult fileUploadResult = new PicUploadResult();

        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        // 格式是否合法
        if (!isLegal) {
            // 不合法
            fileUploadResult.setStatus(FileUploadStatusEnum.ERROR.getCodeStr());
            return fileUploadResult;
        }

        // 准备上传
        // 文件新路径
        String filename = uploadFile.getOriginalFilename();
        String filePath = this.getFilePath(filename);

        // 上传到阿里云
        try {
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, new ByteArrayInputStream(uploadFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            // 上传失败
            fileUploadResult.setStatus(FileUploadStatusEnum.ERROR.getCodeStr());
            return fileUploadResult;
        }

        // 封装返回结果
        fileUploadResult.setStatus(FileUploadStatusEnum.DONE.getCodeStr());
        fileUploadResult.setName(this.aliyunConfig.getUrlPrefix() + filePath);
        fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return fileUploadResult;
    }

    /**
     * 获取文件路径
     *
     * @param filename {@link String} 文件名称
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/7
     */
    private String getFilePath(String filename) {
        DateTime dateTime = new DateTime();
        StringBuilder sbStr = new StringBuilder();
        sbStr.append("images/");
        sbStr.append(dateTime.toString("yyyy")).append("/");
        sbStr.append(dateTime.toString("MM")).append("/");
        sbStr.append(dateTime.toString("dd")).append("/");
        sbStr.append(System.currentTimeMillis());
        sbStr.append(RandomUtils.nextInt(100, 9999)).append(".");
        sbStr.append(StringUtils.substringAfterLast(filename, "."));
        return sbStr.toString();
    }
}
