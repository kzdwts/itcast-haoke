package cn.itcast.haoke.dubbo.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus配置类
 *
 * @author Kang Yong
 * @date 2022/3/6
 * @since 1.0.0
 */
@Configuration
@MapperScan("cn.itcast.haoke.dubbo.server.mapper")
public class MybatisConfig {

}
