package com.yh.windnacelle.service.impl;

import java.util.List;
import com.yh.common.utils.DateUtils;
import com.yh.windnacelle.utils.Utils;
import com.yh.windnacelle.mapper.SysStreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.domain.SysStream;
import com.yh.windnacelle.service.ISysStreamService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


/**
 * 拉流配置Service业务层处理
 *
 * @author zzs
 * @date 2024-09-11
 */
@Service
public class SysStreamServiceImpl implements ISysStreamService
{
    @Autowired
    private SysStreamMapper sysStreamMapper;

    @Autowired
    private Utils utils;

    /**
     * 查询拉流配置
     *
     * @param id 拉流配置主键
     * @return 拉流配置
     */
    @Override
    public SysStream selectSysStreamById(Long id)
    {
        return sysStreamMapper.selectSysStreamById(id);
    }

    /**
     * 查询拉流配置列表
     *
     * @param sysStream 拉流配置
     * @return 拉流配置
     */
    @Override
    public List<SysStream> selectSysStreamList(SysStream sysStream)
    {
        return sysStreamMapper.selectSysStreamList(sysStream);
    }

    /**
     * 新增拉流配置
     *
     * @param sysStream 拉流配置
     * @return 结果
     */
    @Override
    public int insertSysStream(SysStream sysStream)
    {
        RestTemplate restTemplate = new RestTemplate();
        SysStream stream = restTemplate.postForObject(utils.getPrefixAddress() + "/submitAddStream", sysStream, SysStream.class);
        sysStream.setCode(stream.getCode());
        sysStream.setMsg(stream.getMsg());
        sysStream.setCreateTime(DateUtils.getNowDate());
        return sysStreamMapper.insertSysStream(sysStream);
    }

    /**
     * 修改拉流配置
     *
     * @param sysStream 拉流配置
     * @return 结果
     */
    @Override
    public int updateSysStream(SysStream sysStream)
    {
        sysStream.setUpdateTime(DateUtils.getNowDate());
        return sysStreamMapper.updateSysStream(sysStream);
    }

    /**
     * 批量删除拉流配置
     *
     * @param ids 需要删除的拉流配置主键
     * @return 结果
     */
    @Override
    public int deleteSysStreamByIds(Long[] ids)
    {
        int i = sysStreamMapper.deleteSysStreamByIds(ids);
        return i;
    }

    /**
     * 删除拉流配置信息
     *
     * @param id 拉流配置主键
     * @return 结果
     */
    @Override
    @Transactional // 开启事务
    public int deleteSysStreamById(Long id) {
        // 查询要删除的流配置
        SysStream sysStream = sysStreamMapper.selectSysStreamById(id);

        // 调用远程接口
        RestTemplate restTemplate = new RestTemplate();
        SysStream responseStream = restTemplate.postForObject(utils.getPrefixAddress() + "/submitDeleteStream", sysStream, SysStream.class);
        responseStream.setStatus("已删除");
        // 检查远程接口调用的结果
        if (responseStream == null) {
            throw new RuntimeException("删除拉流配置失败");
        }

        // 更新数据库中的流配置
        int updatedCount = sysStreamMapper.updateSysStream(responseStream);

        // 删除数据库中的流配置
//        int deletedCount = sysStreamMapper.deleteSysStreamById(id);

        // 返回操作结果
        return updatedCount;
    }
}
