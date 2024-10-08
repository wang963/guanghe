package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindCompTemperature;

/**
 * 风机部件温度Mapper接口
 *
 * @author zzs
 * @date 2024-09-30
 */
public interface WindCompTemperatureMapper
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
     * 批量修改风机部件温度
     *
     * @param windCompTemperatures
     * @return
     */
    public int updateWindCompTemperatureBatch(List<WindCompTemperature> windCompTemperatures);

    /**
     * 删除风机部件温度
     *
     * @param id 风机部件温度主键
     * @return 结果
     */
    public int deleteWindCompTemperatureById(Long id);

    /**
     * 批量删除风机部件温度
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindCompTemperatureByIds(Long[] ids);
}
