package com.yh.fanmonitor.service.impl;

import java.util.Arrays;
import java.util.List;
import com.yh.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.SysStreamMapper;
import com.yh.fanmonitor.domain.SysStream;
import com.yh.fanmonitor.service.ISysStreamService;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

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

    //新增拉流接口
    private static final String API_URL_ADD = "http://192.168.101.187/open-api/submitAddStream"; // 替换为实际的 API 地址
    //
    private static final String API_URL = "http://192.168.101.187/open-api/submitDeleteStream"; // 替换为实际的 API 地址


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
        SysStream stream = restTemplate.postForObject(API_URL_ADD, sysStream, SysStream.class);
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
        SysStream responseStream = restTemplate.postForObject(API_URL, sysStream, SysStream.class);
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
