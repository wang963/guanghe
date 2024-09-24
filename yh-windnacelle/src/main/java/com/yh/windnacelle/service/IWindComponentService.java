package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindComponent;

/**
 * 风机部件Service接口
 *
 * @author zzs
 * @date 2024-07-15
 */
public interface IWindComponentService
{
    /**
     * 查询风机部件
     *
     * @param componentId 风机部件主键
     * @return 风机部件
     */
    public WindComponent selectWindComponentByComponentId(Integer componentId);

    /**
     * 查询风机部件列表
     *
     * @param windComponent 风机部件
     * @return 风机部件集合
     */
    public List<WindComponent> selectWindComponentList(WindComponent windComponent);

    /**
     * 新增风机部件
     *
     * @param windComponent 风机部件
     * @return 结果
     */
    public int insertWindComponent(WindComponent windComponent);

    /**
     * 修改风机部件
     *
     * @param windComponent 风机部件
     * @return 结果
     */
    public int updateWindComponent(WindComponent windComponent);

    /**
     * 批量删除风机部件
     *
     * @param componentIds 需要删除的风机部件主键集合
     * @return 结果
     */
    public int deleteWindComponentByComponentIds(Integer[] componentIds);

    /**
     * 删除风机部件信息
     *
     * @param componentId 风机部件主键
     * @return 结果
     */
    public int deleteWindComponentByComponentId(Integer componentId);
}
