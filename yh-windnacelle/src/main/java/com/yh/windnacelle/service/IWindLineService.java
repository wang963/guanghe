package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindLine;

/**
 * 风机线路Service接口
 *
 * @author zzs
 * @date 2024-07-02
 */
public interface IWindLineService
{
    /**
     * 查询风机线路
     *
     * @param lineId 风机线路主键
     * @return 风机线路
     */
    public WindLine selectWindLineByLineId(Integer lineId);

    /**
     * 查询风机线路列表
     *
     * @param windLine 风机线路
     * @return 风机线路集合
     */
    public List<WindLine> selectWindLineList(WindLine windLine);

    /**
     * 新增风机线路
     *
     * @param windLine 风机线路
     * @return 结果
     */
    public int insertWindLine(WindLine windLine);

    /**
     * 修改风机线路
     *
     * @param windLine 风机线路
     * @return 结果
     */
    public int updateWindLine(WindLine windLine);

    /**
     * 批量删除风机线路
     *
     * @param lineIds 需要删除的风机线路主键集合
     * @return 结果
     */
    public int deleteWindLineByLineIds(Integer[] lineIds);

    /**
     * 删除风机线路信息
     *
     * @param lineId 风机线路主键
     * @return 结果
     */
    public int deleteWindLineByLineId(Integer lineId);
}
