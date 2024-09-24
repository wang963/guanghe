package com.yh.windnacelle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindSiteMapper;
import com.yh.windnacelle.domain.WindSite;
import com.yh.windnacelle.service.IWindSiteService;

/**
 * 电站信息Service业务层处理
 *
 * @author zzs
 * @date 2024-07-02
 */
@Service
public class WindSiteServiceImpl implements IWindSiteService
{
    @Autowired
    private WindSiteMapper windSiteMapper;

    /**
     * 查询电站信息
     *
     * @param siteId 电站信息主键
     * @return 电站信息
     */
    @Override
    public WindSite selectWindSiteBySiteId(Integer siteId)
    {
        return windSiteMapper.selectWindSiteBySiteId(siteId);
    }

    /**
     * 查询电站信息列表
     *
     * @param windSite 电站信息
     * @return 电站信息
     */
    @Override
    public List<WindSite> selectWindSiteList(WindSite windSite)
    {
        return windSiteMapper.selectWindSiteList(windSite);
    }

    /**
     * 新增电站信息
     *
     * @param windSite 电站信息
     * @return 结果
     */
    @Override
    public int insertWindSite(WindSite windSite)
    {
        return windSiteMapper.insertWindSite(windSite);
    }

    /**
     * 修改电站信息
     *
     * @param windSite 电站信息
     * @return 结果
     */
    @Override
    public int updateWindSite(WindSite windSite)
    {
        return windSiteMapper.updateWindSite(windSite);
    }

    /**
     * 批量删除电站信息
     *
     * @param siteIds 需要删除的电站信息主键
     * @return 结果
     */
    @Override
    public int deleteWindSiteBySiteIds(Integer[] siteIds)
    {
        return windSiteMapper.deleteWindSiteBySiteIds(siteIds);
    }

    /**
     * 删除电站信息信息
     *
     * @param siteId 电站信息主键
     * @return 结果
     */
    @Override
    public int deleteWindSiteBySiteId(Integer siteId)
    {
        return windSiteMapper.deleteWindSiteBySiteId(siteId);
    }
}
