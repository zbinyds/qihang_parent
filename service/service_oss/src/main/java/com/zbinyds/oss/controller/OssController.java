package com.zbinyds.oss.controller;

import com.zbinyds.R;
import com.zbinyds.oss.service.OssService;
import com.zbinyds.oss.utils.OssPropertiesUtils;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/17 15:37
 */

@Api(tags = "阿里云Oss文件管理服务")
@RestController
@RequestMapping("/eduoss/fileoss")
//@CrossOrigin // 允许跨域访问
public class OssController {
    @Autowired
    OssService ossService;

    /**
     * 上传讲师头像/课程封面/前台轮播图
     * @param file：文件对象
     * @return：返回头像url地址
     */
    @ApiOperation("上传文件")
    @PostMapping
    public R uploadOssFile(MultipartFile file) {
        if (Objects.isNull(file)){
            throw new QiHangException("20002","未传入必填参数！");
        }
        String url = ossService.uploadAvatarFile(file);
        return !StringUtils.isEmpty(url) ? R.success().data("url", url) : R.failed().message("上传文件失败");
    }
}
