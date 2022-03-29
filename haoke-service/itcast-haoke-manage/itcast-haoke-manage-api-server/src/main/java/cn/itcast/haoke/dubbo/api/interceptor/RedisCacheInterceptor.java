package cn.itcast.haoke.dubbo.api.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * redis缓存拦截器
 *
 * @author Kang Yong
 * @date 2022/3/27
 * @since 1.0.0
 */
@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * preHandle
     *
     * @param request  {@link HttpServletRequest}
     * @param response {@link HttpServletResponse}
     * @param handler  {@link Object}
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2022/3/27
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.equalsIgnoreCase(request.getMethod(), "OPTIONS")) {
            return true;
        }

        if (!StringUtils.equalsIgnoreCase(request.getMethod(), "get")) {
            // 非get请求，如果不是graphql请求，放行
            if (!StringUtils.equalsIgnoreCase(request.getRequestURI(), "/graphql")) {
                return true;
            }
        }

        String data = this.redisTemplate.opsForValue().get(this.createRedisKey(request));
        if (StringUtils.isEmpty(data)) {
            // 未命中缓存， 继续执行业务逻辑
            return true;
        }

        // 命中缓存，写出数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        // 支持跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Token");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.getWriter().write(data);
        return false;
    }

    /**
     * 创建缓存
     *
     * @param request {@link HttpServletRequest}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/3/27
     */
    public static String createRedisKey(HttpServletRequest request) throws IOException {
        String paramStr = request.getRequestURI();

        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.isEmpty()) {
            paramStr += IOUtils.toString(request.getInputStream(), "UTF-8");
        } else {
            paramStr += mapper.writeValueAsString(request.getParameterMap());
        }

        String redisKey = "WEB_DATA_" + DigestUtils.md5Hex(paramStr);
        return redisKey;
    }
}
