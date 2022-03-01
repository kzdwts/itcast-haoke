package cn.itcast.dubbo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 生产者启动类
 *
 * @author Kang Yong
 * @date 2022/3/1
 * @since 1.0.0
 */
@SpringBootApplication
public class DubboProvider {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProvider.class)
                .web(WebApplicationType.NONE) // 非 web 应用
                .run(args);
    }
}
