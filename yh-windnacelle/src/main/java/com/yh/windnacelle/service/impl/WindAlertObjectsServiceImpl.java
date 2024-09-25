package com.yh.windnacelle.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.yh.windnacelle.mapper.WindAlertObjectsMapper;
import com.yh.windnacelle.service.IWindAlertObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.domain.WindAlertObjects;

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
     * 查询告警详细信息
     *
     * @param alertId 告警Id
     * @return 告警信息集合
     */
    @Override
    public List<WindAlertObjects> getWindAlertObjectsById(int alertId)
    {
        List<WindAlertObjects> windAlertObjectsList = windAlertObjectsMapper.getWindAlertObjectsById(alertId);
        for (WindAlertObjects windAlertObjects:windAlertObjectsList){
            List<String> colorlist = Arrays.stream(
                            windAlertObjects.getColorDba().substring(1, windAlertObjects.getColorDba().length() - 1)
                                    .split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            windAlertObjects.setColor(colorlist);

            List<String> list = Arrays.stream(
                            windAlertObjects.getPositionDba().substring(1, windAlertObjects.getPositionDba().length() - 1)
                                    .split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            windAlertObjects.setPosition(list);
        }
        return windAlertObjectsList;
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
