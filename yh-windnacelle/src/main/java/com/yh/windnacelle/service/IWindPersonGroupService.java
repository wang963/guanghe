package com.yh.windnacelle.service;

import java.util.List;

import com.yh.windnacelle.domain.WindPersonGroup;

/**
 * 人员分组管理Service接口
 *
 * @author wyy
 * @date 2024-09-13
 */
public interface IWindPersonGroupService {
    /**
     * 查询人员分组管理
     *
     * @param id 人员分组管理主键
     * @return 人员分组管理
     */
    public WindPersonGroup selectWindPersonGroupById(Long id);

    /**
     * 查询人员分组管理列表
     *
     * @param windPersonGroup 人员分组管理
     * @return 人员分组管理集合
     */
    public List<WindPersonGroup> selectWindPersonGroupList(WindPersonGroup windPersonGroup);

    /**
     * 新增人员分组管理
     *
     * @param windPersonGroup 人员分组管理
     * @return 结果
     */
    public String insertWindPersonGroup(WindPersonGroup windPersonGroup);

    /**
     * 修改人员分组管理
     *
     * @param windPersonGroup 人员分组管理
     * @return 结果
     */
    public int updateWindPersonGroup(WindPersonGroup windPersonGroup);

    /**
     * 批量删除人员分组管理
     *
     * @param ids 需要删除的人员分组管理主键集合
     * @return 结果
     */
    public int deleteWindPersonGroupByIds(Long[] ids);

    /**
     * 删除人员分组管理信息
     *
     * @param id 人员分组管理主键
     * @return 结果
     */
    public int deleteWindPersonGroupById(Long id);
}
