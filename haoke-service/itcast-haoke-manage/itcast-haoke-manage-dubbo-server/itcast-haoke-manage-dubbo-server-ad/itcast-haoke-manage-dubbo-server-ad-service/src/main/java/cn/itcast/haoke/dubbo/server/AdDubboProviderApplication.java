package cn.itcast.haoke.dubbo.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动类，非web应用
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@EnableDubbo
@SpringBootApplication
public class AdDubboProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AdDubboProviderApplication.class)
                .web(WebApplicationType.NONE) // 非 web 应用
                .run(args);
    }

}
