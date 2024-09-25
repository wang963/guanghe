package com.yh.fanmonitor.service;

import java.util.List;
import com.yh.fanmonitor.domain.WindAlertObjects;

/**
 * 告警详细信息Service接口
 *
 * @author wyy
 * @date 2024-09-24
 */
public interface IWindAlertObjectsService
{
    /**
     * 查询告警详细信息
     *
     * @param id 告警详细信息主键
     * @return 告警详细信息
     */
    public WindAlertObjects selectWindAlertObjectsById(Long id);

    /**
     * 查询告警详细信息
     *
     * @param alertId 告警Id
     * @return 告警信息集合
     */
    public List<WindAlertObjects> getWindAlertObjectsById(int alertId);

    /**
     * 查询告警详细信息列表
     *
     * @param windAlertObjects 告警详细信息
     * @return 告警详细信息集合
     */
    public List<WindAlertObjects> selectWindAlertObjectsList(WindAlertObjects windAlertObjects);

    /**
     * 新增告警详细信息
     *
     * @param windAlertObjects 告警详细信息
     * @return 结果
     */
    public int insertWindAlertObjects(WindAlertObjects windAlertObjects);

    /**
     * 修改告警详细信息
     *
     * @param windAlertObjects 告警详细信息
     * @return 结果
     */
    public int updateWindAlertObjects(WindAlertObjects windAlertObjects);

    /**
     * 批量删除告警详细信息
     *
     * @param ids 需要删除的告警详细信息主键集合
     * @return 结果
     */
    public int deleteWindAlertObjectsByIds(Long[] ids);

    /**
     * 删除告警详细信息信息
     *
     * @param id 告警详细信息主键
     * @return 结果
     */
    public int deleteWindAlertObjectsById(Long id);
}
