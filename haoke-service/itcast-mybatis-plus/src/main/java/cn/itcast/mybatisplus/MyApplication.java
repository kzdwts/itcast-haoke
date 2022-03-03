package cn.itcast.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author Kang Yong
 * @date 2022/3/3
 * @since 1.0.0
 */
@MapperScan(basePackages = {"cn.itcast.mybatisplus.mapper"})
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    /**
     * 分页插件
     *
     * @return {@link PaginationInterceptor}
     * @author Kang Yong
     * @date 2022/3/3
     */
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
