package com.zbinyds.eduService.service;

import com.zbinyds.eduService.pojo.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
public interface EduVideoService extends IService<EduVideo> {

    /**
     * 删除小节
     * @param id：小节id
     * @return
     */
    Boolean removeAlyVodAndVideo(String id);
}
