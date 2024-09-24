package com.yh.windnacelle.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.yh.windnacelle.domain.WindSite;
import com.yh.windnacelle.mapper.WindSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindLineMapper;
import com.yh.windnacelle.domain.WindLine;
import com.yh.windnacelle.service.IWindLineService;

/**
 * 风机线路Service业务层处理
 *
 * @author zzs
 * @date 2024-07-02
 */
@Service
public class WindLineServiceImpl implements IWindLineService
{
    @Autowired
    private WindLineMapper windLineMapper;
    @Autowired
    private WindSiteMapper windSiteMapper;

    /**
     * 查询风机线路
     *
     * @param lineId 风机线路主键
     * @return 风机线路
     */
    @Override
    public WindLine selectWindLineByLineId(Integer lineId)
    {
        WindLine windLine = windLineMapper.selectWindLineByLineId(lineId);
        /*windLine.setSiteName(
                windSiteMapper.selectWindSiteBySiteId(windLine.getSiteId()).getSiteName());*/
        return windLine;
    }

    /**
     * 查询风机线路列表
     *
     * @param windLine 风机线路
     * @return 风机线路
     */
    @Override
    public List<WindLine> selectWindLineList(WindLine windLine)
    {
        List<WindLine> windLines
                = windLineMapper.selectWindLineList(windLine);
        /*windLines.stream()
                .peek(item -> item.setSiteName(
                        windSiteMapper.selectWindSiteBySiteId(item.getSiteId()).getSiteName()))
                .collect(Collectors.toList());*/
        return windLines;

    }

    /**
     * 新增风机线路
     *
     * @param windLine 风机线路
     * @return 结果
     */
    @Override
    public int insertWindLine(WindLine windLine)
    {
        windLine.setSiteName(
                windSiteMapper.selectWindSiteBySiteId(windLine.getSiteId()).getSiteName());
        return windLineMapper.insertWindLine(windLine);
    }

    /**
     * 修改风机线路
     *
     * @param windLine 风机线路
     * @return 结果
     */
    @Override
    public int updateWindLine(WindLine windLine)
    {
        windLine.setSiteName(
                windSiteMapper.selectWindSiteBySiteId(windLine.getSiteId()).getSiteName());
        return windLineMapper.updateWindLine(windLine);
    }

    /**
     * 批量删除风机线路
     *
     * @param lineIds 需要删除的风机线路主键
     * @return 结果
     */
    @Override
    public int deleteWindLineByLineIds(Integer[] lineIds)
    {
        return windLineMapper.deleteWindLineByLineIds(lineIds);
    }

    /**
     * 删除风机线路信息
     *
     * @param lineId 风机线路主键
     * @return 结果
     */
    @Override
    public int deleteWindLineByLineId(Integer lineId)
    {
        return windLineMapper.deleteWindLineByLineId(lineId);
    }
}
