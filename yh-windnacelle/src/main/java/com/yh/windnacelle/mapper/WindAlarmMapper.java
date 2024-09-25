package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindAlarm;

/**
 * 异常告警Mapper接口
 *
 * @author zzs
 * @date 2024-07-29
 */
public interface WindAlarmMapper
{
    /**
     * 查询异常告警
     *
     * @param id 异常告警主键
     * @return 异常告警
     */
    public WindAlarm selectWindAlarmById(Integer id);

    /**
     * 查询异常告警列表
     *
     * @param windAlarm 异常告警
     * @return 异常告警集合
     */
    public List<WindAlarm> selectWindAlarmList(WindAlarm windAlarm);

    /**
     * 新增异常告警
     *
     * @param windAlarm 异常告警
     * @return 结果
     */
    public int insertWindAlarm(WindAlarm windAlarm);

    /**
     * 修改异常告警
     *
     * @param windAlarm 异常告警
     * @return 结果
     */
    public int updateWindAlarm(WindAlarm windAlarm);

    /**
     * 删除异常告警
     *
     * @param id 异常告警主键
     * @return 结果
     */
    public int deleteWindAlarmById(Integer id);

    /**
     * 批量删除异常告警
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindAlarmByIds(Integer[] ids);
}
