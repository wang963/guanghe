package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.SysStream;

/**
 * 拉流配置Mapper接口
 *
 * @author zzs
 * @date 2024-09-11
 */
public interface SysStreamMapper
{
    /**
     * 查询拉流配置
     *
     * @param id 拉流配置主键
     * @return 拉流配置
     */
    public SysStream selectSysStreamById(Long id);

    /**
     * 查询拉流配置列表
     *
     * @param sysStream 拉流配置
     * @return 拉流配置集合
     */
    public List<SysStream> selectSysStreamList(SysStream sysStream);

    /**
     * 新增拉流配置
     *
     * @param sysStream 拉流配置
     * @return 结果
     */
    public int insertSysStream(SysStream sysStream);

    /**
     * 修改拉流配置
     *
     * @param sysStream 拉流配置
     * @return 结果
     */
    public int updateSysStream(SysStream sysStream);

    /**
     * 删除拉流配置
     *
     * @param id 拉流配置主键
     * @return 结果
     */
    public int deleteSysStreamById(Long id);

    /**
     * 批量删除拉流配置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysStreamByIds(Long[] ids);
}
