package com.zbinyds.cms.service;

import com.zbinyds.cms.pojo.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-24
 */
public interface CrmBannerService extends IService<CrmBanner> {

    /**
     * 查询前三条轮播图
     *
     * @return
     */
    List<CrmBanner> getBannerLimitThree();
}
