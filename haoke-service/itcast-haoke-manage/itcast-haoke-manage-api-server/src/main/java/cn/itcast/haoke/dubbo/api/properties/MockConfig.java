package cn.itcast.haoke.dubbo.api.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * mock数据
 *
 * @author Kang Yong
 * @date 2022/3/18
 * @since 1.0.0
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "mock")
@PropertySource("classpath:mock-data.properties")
public class MockConfig {

    private String indexMenu;
    private String indexInfo;
    private String indexFaq;
    private String indexHouse;
    private String infosList1;
    private String infosList2;
    private String infosList3;
    private String my;
}
