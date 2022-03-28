package cn.itcast.haoke.dubbo.api.interceptor;

import cn.itcast.haoke.dubbo.api.controller.GraphQLController;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;

/**
 * 返回结果被处理前，进行拦截处理
 *
 * @author Kang Yong
 * @date 2022/3/28
 * @since 1.0.0
 */
@Slf4j
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        log.info("===supports===正在执行");
        if (methodParameter.hasMethodAnnotation(GetMapping.class)) {
            return true;
        }

        if (methodParameter.hasMethodAnnotation(PostMapping.class)
                && StringUtils.equals(GraphQLController.class.getName(), methodParameter.getExecutable().getDeclaringClass().getName())) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("===beforeBodyWrite===正在执行");
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        try {
            String redisKey = RedisCacheInterceptor.createRedisKey(servletRequest);
            String redisValue;
            if (body instanceof String) {
                redisValue = (String) body;
            } else {
                redisValue = mapper.writeValueAsString(body);
            }
            this.redisTemplate.opsForValue().set(redisKey, redisValue, Duration.ofHours(1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

}
