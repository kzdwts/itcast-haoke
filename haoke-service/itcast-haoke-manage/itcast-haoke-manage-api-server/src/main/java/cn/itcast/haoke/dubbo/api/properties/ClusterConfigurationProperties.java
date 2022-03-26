package cn.itcast.haoke.dubbo.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis集群配置
 *
 * @author Kang Yong
 * @date 2022/3/26
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigurationProperties {

    private List<String> nodes;

    private Integer maxRedirects;
}
