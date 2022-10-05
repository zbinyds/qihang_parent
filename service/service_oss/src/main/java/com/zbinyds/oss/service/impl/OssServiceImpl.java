package com.zbinyds.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.zbinyds.oss.service.OssService;
import com.zbinyds.oss.utils.OssPropertiesUtils;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author zbinyds
 * @time 2022/09/17 15:39
 * <p>
 * 文件上传-阿里云Oss服务
 */

@Service
@Slf4j
public class OssServiceImpl implements OssService {
    @Override
    public String uploadAvatarFile(MultipartFile file) {
        String endpoint = OssPropertiesUtils.END_POINT; // 地域节点
        String accessKeyId = OssPropertiesUtils.KEY_ID; // AccessKey
        String accessKeySecret = OssPropertiesUtils.KEY_SECRET; // AccessKey秘钥
        String bucketName = OssPropertiesUtils.BUCKET_NAME; // bucket
        String path; // 头像存放在阿里云Oss服务器中的路径

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 使用uuid构建文件名
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); // 文件后缀
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix; // 随机文件名
            // 使用 joda-time 工具包，构建日期。作为服务器中的路径
            String pathName = new DateTime().toString("yyyy/MM/dd");
            path = pathName + "/" + fileName;

            // 获取文件的输入流
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求
            ossClient.putObject(bucketName, path, inputStream);
            // 返回头像url ：https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2.jpg
            String url = "https://" + bucketName + "." + endpoint + "/" + path;
            log.info("--------------文件已经上传完毕！---------------");
            return url;
        } catch (Exception e) {
            throw new QiHangException("20001", "头像上传发生了异常");
        } finally {
            if (ossClient != null) {
                // 关闭oss客户端
                ossClient.shutdown();
            }
        }
    }
}
