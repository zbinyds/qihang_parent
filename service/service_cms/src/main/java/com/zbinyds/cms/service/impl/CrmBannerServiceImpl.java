package com.zbinyds.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.cms.mapper.CrmBannerMapper;
import com.zbinyds.cms.pojo.CrmBanner;
import com.zbinyds.cms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-24
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Override
    public List<CrmBanner> getBannerLimitThree() {
        LambdaQueryWrapper<CrmBanner> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(CrmBanner::getId); // 根据id降序排序（由于id按照插入顺序递增，这里相当于按照添加时间降序排序）
        queryWrapper.last("limit 3"); // 查询前三条记录
        return baseMapper.selectList(queryWrapper);
    }
}
