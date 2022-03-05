package cn.itcast.haoke.dubbo.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus配置
 *
 * @author Kang Yong
 * @date 2022/3/5
 * @since 1.0.0
 */
@Configuration
@MapperScan("cn.itcast.haoke.dubbo.server.mapper.HouseResourcesMapper")
public class MybatisConfig {

}
