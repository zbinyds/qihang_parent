package com.zbinyds.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author zbinyds
 * @time 2022/09/17 15:38
 */
public interface OssService {
    /**
     * 上传文件
     * @param file：文件对象
     * @return：返回头像url地址
     */
    String uploadAvatarFile(MultipartFile file);
}
