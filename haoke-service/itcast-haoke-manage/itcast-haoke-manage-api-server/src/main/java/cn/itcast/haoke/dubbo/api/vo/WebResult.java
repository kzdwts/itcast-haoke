package cn.itcast.haoke.dubbo.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 与前端系统交互的数据结构定义
 *
 * @author Kang Yong
 * @date 2022/3/17
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class WebResult {


    @JsonIgnore
    private Integer status;

    @JsonIgnore
    private String msg;

    @JsonIgnore
    private List<?> list;

    /**
     * 成功返回数据
     *
     * @param list {@link List<?>}
     * @return {@link WebResult}
     * @author Kang Yong
     * @date 2022/3/17
     */
    @JsonIgnore
    public static WebResult ok(List<?> list) {
        return new WebResult(200, "成功", list);
    }

    /**
     * 成功返回数据和描述信息
     *
     * @param list {@link List<?>} 数据
     * @param msg  {@link String} 描述信息
     * @return {@link WebResult}
     * @author Kang Yong
     * @date 2022/3/17
     */
    public static WebResult ok(List<?> list, String msg) {
        return new WebResult(200, msg, list);
    }

    /**
     * 获取数据
     *
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/17
     */
    public Map<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", this.list);
        return data;
    }

    /**
     * 获取响应状态和描述信息
     *
     * @return {@link Map< String, Object>}
     * @author Kang Yong
     * @date 2022/3/17
     */
    public Map<String, Object> getMeta() {
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("msg", this.msg);
        meta.put("status", this.status);
        return meta;
    }

}
