package com.yh.fanmonitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.WindMiscInfoMapper;
import com.yh.fanmonitor.domain.WindMiscInfo;
import com.yh.fanmonitor.service.IWindMiscInfoService;

/**
 * 外发告警地址配置Service业务层处理
 *
 * @author wyy
 * @date 2024-09-20
 */
@Service
public class WindMiscInfoServiceImpl implements IWindMiscInfoService
{
    @Autowired
    private WindMiscInfoMapper windMiscInfoMapper;

    /**
     * 查询外发告警地址配置
     *
     * @param id 外发告警地址配置主键
     * @return 外发告警地址配置
     */
    @Override
    public WindMiscInfo selectWindMiscInfoById(Long id)
    {
        return windMiscInfoMapper.selectWindMiscInfoById(id);
    }

    /**
     * 查询外发告警地址配置列表
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 外发告警地址配置
     */
    @Override
    public List<WindMiscInfo> selectWindMiscInfoList(WindMiscInfo windMiscInfo)
    {
        return windMiscInfoMapper.selectWindMiscInfoList(windMiscInfo);
    }

    /**
     * 新增外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    @Override
    public int insertWindMiscInfo(WindMiscInfo windMiscInfo)
    {
        return windMiscInfoMapper.insertWindMiscInfo(windMiscInfo);
    }

    /**
     * 修改外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    @Override
    public int updateWindMiscInfo(WindMiscInfo windMiscInfo)
    {
        return windMiscInfoMapper.updateWindMiscInfo(windMiscInfo);
    }

    /**
     * 批量删除外发告警地址配置
     *
     * @param ids 需要删除的外发告警地址配置主键
     * @return 结果
     */
    @Override
    public int deleteWindMiscInfoByIds(Long[] ids)
    {
        return windMiscInfoMapper.deleteWindMiscInfoByIds(ids);
    }

    /**
     * 删除外发告警地址配置信息
     *
     * @param id 外发告警地址配置主键
     * @return 结果
     */
    @Override
    public int deleteWindMiscInfoById(Long id)
    {
        return windMiscInfoMapper.deleteWindMiscInfoById(id);
    }
}
