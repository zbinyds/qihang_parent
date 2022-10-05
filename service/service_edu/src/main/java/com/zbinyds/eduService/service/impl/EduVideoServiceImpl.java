package com.zbinyds.eduService.service.impl;

import com.zbinyds.R;
import com.zbinyds.eduService.client.VodClient;
import com.zbinyds.eduService.pojo.EduVideo;
import com.zbinyds.eduService.mapper.EduVideoMapper;
import com.zbinyds.eduService.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private VodClient vodClient; // 注入client，进行远程调用

    @Transactional // 开始事务支持
    public Boolean removeAlyVodAndVideo(String id) {
        // 1、根据小节id获取到对应的阿里云视频id
        EduVideo eduVideo = this.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();

        // 2、删除阿里云视频（当该小节内存在阿里云视频才进行删除）
        if (!StringUtils.isEmpty(videoSourceId)){
            R result = vodClient.removeVideo(videoSourceId);
            // 如果调用的接口返回结果异常，则抛出异常，不往下执行。
            if (!"20000".equals(result.getCode())) throw new QiHangException("20001",result.getMessage());
        }

        // 3、删除小节
        return removeById(id);
    }
}
