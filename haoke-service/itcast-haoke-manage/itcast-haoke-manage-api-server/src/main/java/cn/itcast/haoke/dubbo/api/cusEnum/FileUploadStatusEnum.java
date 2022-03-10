package cn.itcast.haoke.dubbo.api.cusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 文件上传状态枚举
 *
 * @author Kang Yong
 * @date 2022/3/10
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum FileUploadStatusEnum {

    UPLOADING("uploading", "上传中"),

    DONE("done", "已完成"),

    ERROR("error", "文件不合法"),

    REMOVED("removed", "已删除"),
    ;

    private String codeStr;

    private String desc;


    /**
     * 枚举转成Map.
     */
    private static final Map<String, FileUploadStatusEnum> map = Arrays.stream(values()).collect(Collectors.toMap(FileUploadStatusEnum::getCodeStr, Function.identity()));

    /**
     * 功能: 根据Code获取描述信息.
     *
     * @param codeStr {@link String}
     * @return {@link String}
     * @author leo
     * @date 2021/10/11
     */
    public static String getDescByCode(String codeStr) {
        return of(codeStr).map(FileUploadStatusEnum::getDesc).orElse("");
    }

    /**
     * 功能: 根据Code 获取枚举对象.
     *
     * @param codeStr {@link String}
     * @return {@link FileUploadStatusEnum}
     * @author leo
     * @date 2021/10/11
     */
    public static FileUploadStatusEnum getEnumByCode(String codeStr) {
        return of(codeStr).orElse(null);
    }

    /**
     * 功能: Optional 转换.
     *
     * @param codeStr {@link String}
     * @return {@link Optional <FileUploadStatusEnum>}
     * @author leo
     * @date 2021/10/11
     */
    private static Optional<FileUploadStatusEnum> of(String codeStr) {
        return Optional.ofNullable(map.get(codeStr));
    }
}
