package com.yh.fanmonitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.WindAlarmMapper;
import com.yh.fanmonitor.domain.WindAlarm;
import com.yh.fanmonitor.service.IWindAlarmService;

/**
 * 异常告警Service业务层处理
 *
 * @author zzs
 * @date 2024-07-29
 */
@Service
public class WindAlarmServiceImpl implements IWindAlarmService
{
    @Autowired
    private WindAlarmMapper windAlarmMapper;

    /**
     * 查询异常告警
     *
     * @param id 异常告警主键
     * @return 异常告警
     */
    @Override
    public WindAlarm selectWindAlarmById(Integer id)
    {
        return windAlarmMapper.selectWindAlarmById(id);
    }

    /**
     * 查询异常告警列表
     *
     * @param windAlarm 异常告警
     * @return 异常告警
     */
    @Override
    public List<WindAlarm> selectWindAlarmList(WindAlarm windAlarm)
    {
        return windAlarmMapper.selectWindAlarmList(windAlarm);
    }

    /**
     * 新增异常告警
     *
     * @param windAlarm 异常告警
     * @return 结果
     */
    @Override
    public int insertWindAlarm(WindAlarm windAlarm)
    {
        return windAlarmMapper.insertWindAlarm(windAlarm);
    }

    /**
     * 修改异常告警
     *
     * @param windAlarm 异常告警
     * @return 结果
     */
    @Override
    public int updateWindAlarm(WindAlarm windAlarm)
    {
        return windAlarmMapper.updateWindAlarm(windAlarm);
    }

    /**
     * 批量删除异常告警
     *
     * @param ids 需要删除的异常告警主键
     * @return 结果
     */
    @Override
    public int deleteWindAlarmByIds(Integer[] ids)
    {
        return windAlarmMapper.deleteWindAlarmByIds(ids);
    }

    /**
     * 删除异常告警信息
     *
     * @param id 异常告警主键
     * @return 结果
     */
    @Override
    public int deleteWindAlarmById(Integer id)
    {
        return windAlarmMapper.deleteWindAlarmById(id);
    }
}
