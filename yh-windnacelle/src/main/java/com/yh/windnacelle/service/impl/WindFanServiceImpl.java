package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.domain.WindLine;
import com.yh.windnacelle.mapper.WindLineMapper;
import com.yh.windnacelle.mapper.WindSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindFanMapper;
import com.yh.windnacelle.domain.WindFan;
import com.yh.windnacelle.service.IWindFanService;

/**
 * 风机维护Service业务层处理
 *
 * @author zzs
 * @date 2024-07-02
 */
@Service
public class WindFanServiceImpl implements IWindFanService
{
    @Autowired
    private WindFanMapper windFanMapper;
    @Autowired
    private WindLineMapper windLineMapper;

    /**
     * 查询风机维护
     *
     * @param fanId 风机维护主键
     * @return 风机维护
     */
    @Override
    public WindFan selectWindFanByFanId(Integer fanId)
    {
        return windFanMapper.selectWindFanByFanId(fanId);
    }

    /**
     * 查询风机维护列表
     *
     * @param windFan 风机维护
     * @return 风机维护
     */
    @Override
    public List<WindFan> selectWindFanList(WindFan windFan)
    {
        return windFanMapper.selectWindFanList(windFan);
    }

    /**
     * 新增风机维护
     *
     * @param windFan 风机维护
     * @return 结果
     */
    @Override
    public int insertWindFan(WindFan windFan)
    {
        WindLine windLine
                = windLineMapper.selectWindLineByLineId(windFan.getLineId());
        windFan.setLineName(windLine.getLineName());
        windFan.setSiteId(windLine.getSiteId());
        windFan.setSiteName(windLine.getSiteName());
        return windFanMapper.insertWindFan(windFan);
    }

    /**
     * 修改风机维护
     *
     * @param windFan 风机维护
     * @return 结果
     */
    @Override
    public int updateWindFan(WindFan windFan)
    {
        WindLine windLine
                = windLineMapper.selectWindLineByLineId(windFan.getLineId());
        windFan.setLineName(windLine.getLineName());
        windFan.setSiteId(windLine.getSiteId());
        windFan.setSiteName(windLine.getSiteName());
        return windFanMapper.updateWindFan(windFan);
    }

    /**
     * 批量删除风机维护
     *
     * @param fanIds 需要删除的风机维护主键
     * @return 结果
     */
    @Override
    public int deleteWindFanByFanIds(Integer[] fanIds)
    {
        return windFanMapper.deleteWindFanByFanIds(fanIds);
    }

    /**
     * 删除风机维护信息
     *
     * @param fanId 风机维护主键
     * @return 结果
     */
    @Override
    public int deleteWindFanByFanId(Integer fanId)
    {
        return windFanMapper.deleteWindFanByFanId(fanId);
    }
}
