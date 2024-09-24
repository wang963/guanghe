package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 风机线路对象 wind_line
 *
 * @author zzs
 * @date 2024-07-02
 */
public class WindLine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer lineId;

    /** 线路名称 */
    @Excel(name = "线路名称")
    private String lineName;

    /** 电站 */
    @Excel(name = "电站")
    private Integer siteId;

    /** 电站名称 */
    @Excel(name = "电站名称")
    private String siteName;

    public void setLineId(Integer lineId)
    {
        this.lineId = lineId;
    }

    public Integer getLineId()
    {
        return lineId;
    }
    public void setLineName(String lineName)
    {
        this.lineName = lineName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLineName()
    {
        return lineName;
    }
    public void setSiteId(Integer siteId)
    {
        this.siteId = siteId;
    }

    public Integer getSiteId()
    {
        return siteId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lineId", getLineId())
            .append("lineName", getLineName())
            .append("siteId", getSiteId())
            .append("remark", getRemark())
            .toString();
    }
}
