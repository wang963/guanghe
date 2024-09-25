package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.SysCamera;

/**
 * 摄像机配置信息Mapper接口
 *
 * @author wyy
 * @date 2024-09-12
 */
public interface SysCameraMapper
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
     * 修改摄像机配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    public int updateSysCamera(SysCamera sysCamera);

    /**
     * 删除摄像机配置信息
     *
     * @param id 摄像机配置信息主键
     * @return 结果
     */
    public int deleteSysCameraById(String id);

    /**
     * 批量删除摄像机配置信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCameraByIds(String[] ids);
}
