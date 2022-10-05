package com.zbinyds.cms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.R;
import com.zbinyds.cms.pojo.CrmBanner;
import com.zbinyds.cms.service.CrmBannerService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 首页banner表 后台管理控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-24
 */
@Api(tags = "后台轮播图管理")
@RestController
@RequestMapping("/educms/adminBanner")
//@CrossOrigin // 允许跨域访问
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;

    /**
     * 分页查询轮播图信息
     *
     * @param page：当前页
     * @param pageSize：页记录数
     * @return：返回查询结果
     */
    @ApiOperation("分页查询轮播图信息")
    @GetMapping("/pageBanner/{page}/{pageSize}")
    public R page(@PathVariable Integer page, @PathVariable Integer pageSize) {
        // 参数非空校验
        if (Objects.isNull(page) || Objects.isNull(pageSize)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        Page<CrmBanner> bannerPage = new Page<>(page, pageSize);
        bannerService.page(bannerPage, null);
        return R.success().data("total", bannerPage.getTotal()).data("rows", bannerPage.getRecords());
    }

    /**
     * 根据id查询轮播图
     *
     * @param id：轮播图id
     * @return：返回查询结果
     */
    @ApiOperation("根据id查询轮播图")
    @GetMapping("/{id}")
    public R getTeacher(@PathVariable String id) {
        if (StringUtils.isEmpty(id)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        CrmBanner crmBanner = bannerService.getById(id);
        return !Objects.isNull(crmBanner) ? R.success().data("banner", crmBanner) : R.success().message("未查询到相关轮播图信息！");
    }

    /**
     * 添加轮播图
     *
     * @param crmBanner：封装好的待添加对象
     * @return：返回提示信息
     */
    @ApiOperation("添加轮播图")
    @PostMapping
    public R add(@RequestBody CrmBanner crmBanner) {
        // 参数非空校验
        if (Objects.isNull(crmBanner) ||
                StringUtils.isEmpty(crmBanner.getTitle()) ||
                StringUtils.isEmpty(crmBanner.getImageUrl()) ||
                StringUtils.isEmpty(crmBanner.getLinkUrl())) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        return bannerService.save(crmBanner) ? R.success().message("添加轮播图成功！") : R.failed().message("添加轮播图失败！");
    }

    /**
     * 修改轮播图信息
     *
     * @param id：轮播图id
     * @param crmBanner：封装好的待修改对象
     * @return：返回提示信息
     */
    @ApiOperation("修改轮播图信息")
    @PutMapping("/{id}")
    public R update(@PathVariable String id, @RequestBody CrmBanner crmBanner) {
        // 参数非空校验
        if (StringUtils.isEmpty(id) || Objects.isNull(crmBanner)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        crmBanner.setId(id);
        boolean flag = bannerService.updateById(crmBanner);
        return flag ? R.success().message("修改信息成功！") : R.failed().message("修改信息失败！");
    }

    /**
     * 删除轮播图
     *
     * @param id：轮播图id
     * @return：返回提示信息
     */
    @ApiOperation("删除轮播图")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable() String id) {
        // 判断讲师id是否为空
        if (!StringUtils.hasLength(id)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        boolean bool = bannerService.removeById(id);
        return bool ? R.success().message("删除成功！") : R.failed().message("删除失败！");
    }
}

