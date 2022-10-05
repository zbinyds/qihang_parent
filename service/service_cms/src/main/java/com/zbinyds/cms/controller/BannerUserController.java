package com.zbinyds.cms.controller;


import com.zbinyds.R;
import com.zbinyds.cms.pojo.CrmBanner;
import com.zbinyds.cms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前台显示控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-24
 */

@Api(tags = "前台轮播图显示")
@RestController
@RequestMapping("/educms/userBanner")
//@CrossOrigin // 允许跨域访问
public class BannerUserController {

    @Autowired
    private CrmBannerService bannerService;

    @Cacheable(value = "banner",key = "'getBannerLimitThree'")
    @ApiOperation("按照id降序查询前三条轮播图")
    @GetMapping("/getBannerLimitThree")
    public R getBannerLimitThree() {
        List<CrmBanner> bannerList = bannerService.getBannerLimitThree();
        return R.success().message("请求成功！").data("bannerList", bannerList);
    }
}

