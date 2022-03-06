package cn.itcast.haoke.dubbo.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * dubbo服务启动类
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderApplication.class)
                .web(WebApplicationType.NONE) // 非web应用
                .run(args);
    }

}
