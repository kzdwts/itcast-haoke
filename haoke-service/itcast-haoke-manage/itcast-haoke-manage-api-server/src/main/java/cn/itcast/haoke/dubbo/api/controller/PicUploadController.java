package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.PicUploadService;
import cn.itcast.haoke.dubbo.api.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author Kang Yong
 * @date 2022/3/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("/pic/upload")
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;

    /**
     * 文件上传
     *
     * @param uploadFile {@link MultipartFile}
     * @return {@link PicUploadResult}
     * @author Kang Yong
     * @date 2022/3/7
     */
    @PostMapping
    public PicUploadResult upload(@RequestParam("file") MultipartFile uploadFile) {
        return this.picUploadService.upload(uploadFile);
    }
}
