package com.yh.windnacelle.service;

import java.util.List;

import com.yh.windnacelle.domain.SysCamera;

/**
 * 摄像机配置信息Service接口
 *
 * @author wyy
 * @date 2024-09-12
 */
public interface ISysCameraService
{
    /**
     * 查询摄像机配置信息
     *
     * @param id 摄像机配置信息主键
     * @return 摄像机配置信息
     */
    public SysCamera selectSysCameraById(String id);

    /**
     * 查询摄像机配置信息列表
     *
     * @param sysCamera 摄像机配置信息
     * @return 摄像机配置信息集合
     */
    public List<SysCamera> selectSysCameraList(SysCamera sysCamera);

    /**
     * 新增摄像机配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    public int insertSysCamera(SysCamera sysCamera);

    /**
     * 新增算法配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    public int addAlgorithm(SysCamera sysCamera);

    /**
     * 修改摄像机配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    public int updateSysCamera(SysCamera sysCamera);

    /**
     * 批量删除摄像机配置信息
     *
     * @param ids 需要删除的摄像机配置信息主键集合
     * @return 结果
     */
    public int deleteSysCameraByIds(String[] ids);

    /**
     * 删除摄像机配置信息信息
     *
     * @param id 摄像机配置信息主键
     * @return 结果
     */
    public int deleteSysCameraById(String id);
}
