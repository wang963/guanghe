package com.yh.fanmonitor.mapper;

import java.util.List;
import com.yh.fanmonitor.domain.WindPerson;

/**
 * 人员信息Mapper接口
 * 
 * @author wyy
 * @date 2024-09-13
 */
public interface WindPersonMapper 
{
    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    public WindPerson selectWindPersonById(Long id);

    /**
     * 查询人员信息列表
     * 
     * @param windPerson 人员信息
     * @return 人员信息集合
     */
    public List<WindPerson> selectWindPersonList(WindPerson windPerson);

    /**
     * 新增人员信息
     * 
     * @param windPerson 人员信息
     * @return 结果
     */
    public int insertWindPerson(WindPerson windPerson);

    /**
     * 修改人员信息
     * 
     * @param windPerson 人员信息
     * @return 结果
     */
    public int updateWindPerson(WindPerson windPerson);

    /**
     * 删除人员信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    public int deleteWindPersonById(Long id);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindPersonByIds(Long[] ids);
}
