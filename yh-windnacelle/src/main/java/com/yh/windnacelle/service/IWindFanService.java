package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindFan;

/**
 * 风机维护Service接口
 *
 * @author zzs
 * @date 2024-07-02
 */
public interface IWindFanService
{
    /**
     * 查询风机维护
     *
     * @param fanId 风机维护主键
     * @return 风机维护
     */
    public WindFan selectWindFanByFanId(Integer fanId);

    /**
     * 查询风机维护列表
     *
     * @param windFan 风机维护
     * @return 风机维护集合
     */
    public List<WindFan> selectWindFanList(WindFan windFan);

    /**
     * 新增风机维护
     *
     * @param windFan 风机维护
     * @return 结果
     */
    public int insertWindFan(WindFan windFan);

    /**
     * 修改风机维护
     *
     * @param windFan 风机维护
     * @return 结果
     */
    public int updateWindFan(WindFan windFan);

    /**
     * 批量删除风机维护
     *
     * @param fanIds 需要删除的风机维护主键集合
     * @return 结果
     */
    public int deleteWindFanByFanIds(Integer[] fanIds);

    /**
     * 删除风机维护信息
     *
     * @param fanId 风机维护主键
     * @return 结果
     */
    public int deleteWindFanByFanId(Integer fanId);
}
