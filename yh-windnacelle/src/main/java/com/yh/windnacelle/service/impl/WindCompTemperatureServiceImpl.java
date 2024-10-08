package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.domain.WindCompTemperature;
import com.yh.windnacelle.mapper.WindCompTemperatureMapper;
import com.yh.windnacelle.service.IWindCompTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 风机部件温度Service业务层处理
 *
 * @author zzs
 * @date 2024-09-30
 */
@Service
public class WindCompTemperatureServiceImpl implements IWindCompTemperatureService
{
    @Autowired
    private WindCompTemperatureMapper windCompTemperatureMapper;

    /**
     * 查询风机部件温度
     *
     * @param id 风机部件温度主键
     * @return 风机部件温度
     */
    @Override
    public WindCompTemperature selectWindCompTemperatureById(Long id)
    {
        return windCompTemperatureMapper.selectWindCompTemperatureById(id);
    }

    /**
     * 查询风机部件温度列表
     *
     * @param windCompTemperature 风机部件温度
     * @return 风机部件温度
     */
    @Override
    public List<WindCompTemperature> selectWindCompTemperatureList(WindCompTemperature windCompTemperature)
    {
        return windCompTemperatureMapper.selectWindCompTemperatureList(windCompTemperature);
    }

    /**
     * 新增风机部件温度
     *
     * @param windCompTemperature 风机部件温度
     * @return 结果
     */
    @Override
    public int insertWindCompTemperature(WindCompTemperature windCompTemperature)
    {
        return windCompTemperatureMapper.insertWindCompTemperature(windCompTemperature);
    }

    /**
     * 修改风机部件温度
     *
     * @param windCompTemperature 风机部件温度
     * @return 结果
     */
    @Override
    public int updateWindCompTemperature(WindCompTemperature windCompTemperature)
    {
        return windCompTemperatureMapper.updateWindCompTemperature(windCompTemperature);
    }

    @Override
    public int updateWindCompTemperatureBatch(List<WindCompTemperature> windCompTemperatures) {
        return windCompTemperatureMapper.updateWindCompTemperatureBatch(windCompTemperatures);
    }

    /**
     * 批量删除风机部件温度
     *
     * @param ids 需要删除的风机部件温度主键
     * @return 结果
     */
    @Override
    public int deleteWindCompTemperatureByIds(Long[] ids)
    {
        return windCompTemperatureMapper.deleteWindCompTemperatureByIds(ids);
    }

    /**
     * 删除风机部件温度信息
     *
     * @param id 风机部件温度主键
     * @return 结果
     */
    @Override
    public int deleteWindCompTemperatureById(Long id)
    {
        return windCompTemperatureMapper.deleteWindCompTemperatureById(id);
    }
}
