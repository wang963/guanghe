package com.yh.windnacelle.service;

import com.yh.windnacelle.domain.WindCompTemperature;

import java.util.List;

/**
 * 风机部件温度Service接口
 *
 * @author zzs
 * @date 2024-09-30
 */
public interface IWindCompTemperatureService
{
    /**
     * 查询风机部件温度
     *
     * @param id 风机部件温度主键
     * @return 风机部件温度
     */
    public WindCompTemperature selectWindCompTemperatureById(Long id);

    /**
     * 查询风机部件温度列表
     *
     * @param windCompTemperature 风机部件温度
     * @return 风机部件温度集合
     */
    public List<WindCompTemperature> selectWindCompTemperatureList(WindCompTemperature windCompTemperature);

    /**
     * 新增风机部件温度
     *
     * @param windCompTemperature 风机部件温度
     * @return 结果
     */
    public int insertWindCompTemperature(WindCompTemperature windCompTemperature);

    /**
     * 修改风机部件温度
     *
     * @param windCompTemperature 风机部件温度
     * @return 结果
     */
    public int updateWindCompTemperature(WindCompTemperature windCompTemperature);

    /**
     * 批量删除风机部件温度
     *
     * @param ids 需要删除的风机部件温度主键集合
     * @return 结果
     */
    public int deleteWindCompTemperatureByIds(Long[] ids);

    /**
     * 删除风机部件温度信息
     *
     * @param id 风机部件温度主键
     * @return 结果
     */
    public int deleteWindCompTemperatureById(Long id);
}
