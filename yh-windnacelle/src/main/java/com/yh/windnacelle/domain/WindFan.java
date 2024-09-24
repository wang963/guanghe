package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 风机维护对象 wind_fan
 *
 * @author zzs
 * @date 2024-07-02
 */
public class WindFan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer fanId;

    /** 风机名称 */
    @Excel(name = "风机名称")
    private String fanName;

    /** 电站 */
    @Excel(name = "电站")
    private Integer siteId;

    /** 电站名称 */
    @Excel(name = "电站名称")
    private String siteName;

    /** 线路 */
    @Excel(name = "线路")
    private Integer lineId;

    /** 线路名称 */
    @Excel(name = "线路名称")
    private String lineName;

    /** 装机容量 */
    @Excel(name = "装机容量")
    private String capacity;

    /** 经度 */
    @Excel(name = "经度")
    private String latitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String longitude;

    /** 机型 */
    @Excel(name = "机型")
    private String fanModel;

    /** 品牌型号 */
    @Excel(name = "品牌型号")
    private String fanBrand;

    public void setFanId(Integer fanId)
    {
        this.fanId = fanId;
    }

    public Integer getFanId()
    {
        return fanId;
    }
    public void setFanName(String fanName)
    {
        this.fanName = fanName;
    }

    public String getFanName()
    {
        return fanName;
    }
    public void setSiteId(Integer siteId)
    {
        this.siteId = siteId;
    }

    public Integer getSiteId()
    {
        return siteId;
    }
    public void setLineId(Integer lineId)
    {
        this.lineId = lineId;
    }

    public Integer getLineId()
    {
        return lineId;
    }
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
    }
    public void setFanModel(String fanModel)
    {
        this.fanModel = fanModel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFanModel()
    {
        return fanModel;
    }
    public void setFanBrand(String fanBrand)
    {
        this.fanBrand = fanBrand;
    }

    public String getFanBrand()
    {
        return fanBrand;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fanId", getFanId())
            .append("fanName", getFanName())
            .append("siteId", getSiteId())
            .append("lineId", getLineId())
            .append("capacity", getCapacity())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("fanModel", getFanModel())
            .append("fanBrand", getFanBrand())
            .toString();
    }
}
