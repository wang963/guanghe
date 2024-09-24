package com.yh.fanmonitor.service;

import java.io.IOException;
import java.util.List;
import com.yh.fanmonitor.domain.WindAlerts;

/**
 * 告警信息Service接口
 * 
 * @author wyy
 * @date 2024-09-21
 */
public interface IWindAlertsService 
{
    /**
     * 查询告警信息
     * 
     * @param id 告警信息主键
     * @return 告警信息
     */
    public WindAlerts selectWindAlertsById(Long id);

    /**
     * 查询告警信息列表
     * 
     * @param windAlerts 告警信息
     * @return 告警信息集合
     */
    public List<WindAlerts> selectWindAlertsList(WindAlerts windAlerts);

    /**
     * 新增告警信息
     * 
     * @param windAlerts 告警信息
     * @return 结果
     */
    public int insertWindAlerts(WindAlerts windAlerts);

    /**
     * 修改告警信息
     * 
     * @param windAlerts 告警信息
     * @return 结果
     */
    public int updateWindAlerts(WindAlerts windAlerts);

    /**
     * 批量删除告警信息
     * 
     * @param ids 需要删除的告警信息主键集合
     * @return 结果
     */
    public int deleteWindAlertsByIds(Long[] ids);

    /**
     * 删除告警信息信息
     * 
     * @param id 告警信息主键
     * @return 结果
     */
    public int deleteWindAlertsById(Long id);
}
