package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.mapper.WindFanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindComponentMapper;
import com.yh.windnacelle.domain.WindComponent;
import com.yh.windnacelle.service.IWindComponentService;

/**
 * 风机部件Service业务层处理
 *
 * @author zzs
 * @date 2024-07-15
 */
@Service
public class WindComponentServiceImpl implements IWindComponentService
{
    @Autowired
    private WindComponentMapper windComponentMapper;
    @Autowired
    private WindFanMapper windFanMapper;

    /**
     * 查询风机部件
     *
     * @param componentId 风机部件主键
     * @return 风机部件
     */
    @Override
    public WindComponent selectWindComponentByComponentId(Integer componentId)
    {
        return windComponentMapper.selectWindComponentByComponentId(componentId);
    }

    /**
     * 查询风机部件列表
     *
     * @param windComponent 风机部件
     * @return 风机部件
     */
    @Override
    public List<WindComponent> selectWindComponentList(WindComponent windComponent)
    {
        return windComponentMapper.selectWindComponentList(windComponent);
    }

    /**
     * 新增风机部件
     *
     * @param windComponent 风机部件
     * @return 结果
     */
    @Override
    public int insertWindComponent(WindComponent windComponent)
    {
        windComponent.setFanName(windFanMapper.selectWindFanByFanId(windComponent.getFanId()).getFanName());
        return windComponentMapper.insertWindComponent(windComponent);
    }

    /**
     * 修改风机部件
     *
     * @param windComponent 风机部件
     * @return 结果
     */
    @Override
    public int updateWindComponent(WindComponent windComponent)
    {
        windComponent.setFanName(windFanMapper.selectWindFanByFanId(windComponent.getFanId()).getFanName());
        return windComponentMapper.updateWindComponent(windComponent);
    }

    /**
     * 批量删除风机部件
     *
     * @param componentIds 需要删除的风机部件主键
     * @return 结果
     */
    @Override
    public int deleteWindComponentByComponentIds(Integer[] componentIds)
    {
        return windComponentMapper.deleteWindComponentByComponentIds(componentIds);
    }

    /**
     * 删除风机部件信息
     *
     * @param componentId 风机部件主键
     * @return 结果
     */
    @Override
    public int deleteWindComponentByComponentId(Integer componentId)
    {
        return windComponentMapper.deleteWindComponentByComponentId(componentId);
    }
}
