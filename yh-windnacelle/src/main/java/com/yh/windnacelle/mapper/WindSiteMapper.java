package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindSite;

/**
 * 电站信息Mapper接口
 *
 * @author zzs
 * @date 2024-07-02
 */
public interface WindSiteMapper
{
    /**
     * 查询电站信息
     *
     * @param siteId 电站信息主键
     * @return 电站信息
     */
    public WindSite selectWindSiteBySiteId(Integer siteId);

    /**
     * 查询电站信息列表
     *
     * @param windSite 电站信息
     * @return 电站信息集合
     */
    public List<WindSite> selectWindSiteList(WindSite windSite);

    /**
     * 新增电站信息
     *
     * @param windSite 电站信息
     * @return 结果
     */
    public int insertWindSite(WindSite windSite);

    /**
     * 修改电站信息
     *
     * @param windSite 电站信息
     * @return 结果
     */
    public int updateWindSite(WindSite windSite);

    /**
     * 删除电站信息
     *
     * @param siteId 电站信息主键
     * @return 结果
     */
    public int deleteWindSiteBySiteId(Integer siteId);

    /**
     * 批量删除电站信息
     *
     * @param siteIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindSiteBySiteIds(Integer[] siteIds);
}
