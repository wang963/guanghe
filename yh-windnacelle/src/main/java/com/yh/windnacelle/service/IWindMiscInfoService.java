package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindMiscInfo;

/**
 * 外发告警地址配置Service接口
 *
 * @author wyy
 * @date 2024-09-20
 */
public interface IWindMiscInfoService
{
    /**
     * 查询外发告警地址配置
     *
     * @param id 外发告警地址配置主键
     * @return 外发告警地址配置
     */
    public WindMiscInfo selectWindMiscInfoById(Long id);

    /**
     * 查询外发告警地址配置列表
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 外发告警地址配置集合
     */
    public List<WindMiscInfo> selectWindMiscInfoList(WindMiscInfo windMiscInfo);

    /**
     * 新增外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    public int insertWindMiscInfo(WindMiscInfo windMiscInfo);

    /**
     * 修改外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    public int updateWindMiscInfo(WindMiscInfo windMiscInfo);

    /**
     * 批量删除外发告警地址配置
     *
     * @param ids 需要删除的外发告警地址配置主键集合
     * @return 结果
     */
    public int deleteWindMiscInfoByIds(Long[] ids);

    /**
     * 删除外发告警地址配置信息
     *
     * @param id 外发告警地址配置主键
     * @return 结果
     */
    public int deleteWindMiscInfoById(Long id);
}
