package cn.itcast.haoke.dubbo.api.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云 oss参数配置
 *
 * @author Kang Yong
 * @date 2022/3/7
 * @since 1.0.0
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "aliyun")
public class AliyunConfig {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String urlPrefix;

    @Bean
    public OSS ossClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}
