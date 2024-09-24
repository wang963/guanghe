package com.yh.fanmonitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.WindAlertObjectsMapper;
import com.yh.fanmonitor.domain.WindAlertObjects;
import com.yh.fanmonitor.service.IWindAlertObjectsService;

/**
 * 告警详细信息Service业务层处理
 *
 * @author wyy
 * @date 2024-09-24
 */
@Service
public class WindAlertObjectsServiceImpl implements IWindAlertObjectsService
{
    @Autowired
    private WindAlertObjectsMapper windAlertObjectsMapper;

    /**
     * 查询告警详细信息
     *
     * @param id 告警详细信息主键
     * @return 告警详细信息
     */
    @Override
    public WindAlertObjects selectWindAlertObjectsById(Long id)
    {
        return windAlertObjectsMapper.selectWindAlertObjectsById(id);
    }

    /**
     * 查询告警详细信息列表
     *
     * @param windAlertObjects 告警详细信息
     * @return 告警详细信息
     */
    @Override
    public List<WindAlertObjects> selectWindAlertObjectsList(WindAlertObjects windAlertObjects)
    {
        return windAlertObjectsMapper.selectWindAlertObjectsList(windAlertObjects);
    }

    /**
     * 新增告警详细信息
     *
     * @param windAlertObjects 告警详细信息
     * @return 结果
     */
    @Override
    public int insertWindAlertObjects(WindAlertObjects windAlertObjects)
    {
        return windAlertObjectsMapper.insertWindAlertObjects(windAlertObjects);
    }

    /**
     * 修改告警详细信息
     *
     * @param windAlertObjects 告警详细信息
     * @return 结果
     */
    @Override
    public int updateWindAlertObjects(WindAlertObjects windAlertObjects)
    {
        return windAlertObjectsMapper.updateWindAlertObjects(windAlertObjects);
    }

    /**
     * 批量删除告警详细信息
     *
     * @param ids 需要删除的告警详细信息主键
     * @return 结果
     */
    @Override
    public int deleteWindAlertObjectsByIds(Long[] ids)
    {
        return windAlertObjectsMapper.deleteWindAlertObjectsByIds(ids);
    }

    /**
     * 删除告警详细信息信息
     *
     * @param id 告警详细信息主键
     * @return 结果
     */
    @Override
    public int deleteWindAlertObjectsById(Long id)
    {
        return windAlertObjectsMapper.deleteWindAlertObjectsById(id);
    }
}
