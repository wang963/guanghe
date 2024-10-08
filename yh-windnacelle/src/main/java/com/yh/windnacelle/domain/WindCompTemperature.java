package com.yh.windnacelle.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 风机部件温度对象 wind_comp_temperature
 *
 * @author zzs
 * @date 2024-09-30
 */
public class WindCompTemperature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 部件名称 */
    @Excel(name = "部件名称")
    private String compName;

    /** 温度 */
    @Excel(name = "温度")
    private Long temperature;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 告警 */
    @Excel(name = "告警")
    private String alarm;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCompName(String compName)
    {
        this.compName = compName;
    }

    public String getCompName()
    {
        return compName;
    }
    public void setTemperature(Long temperature)
    {
        this.temperature = temperature;
    }

    public Long getTemperature()
    {
        return temperature;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setAlarm(String alarm)
    {
        this.alarm = alarm;
    }

    public String getAlarm()
    {
        return alarm;
    }
    public void setCreatedTime(Date createdTime)
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime()
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime)
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime()
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("compName", getCompName())
                .append("temperature", getTemperature())
                .append("unit", getUnit())
                .append("time", getTime())
                .append("alarm", getAlarm())
                .append("createdTime", getCreatedTime())
                .append("updatedTime", getUpdatedTime())
                .toString();
    }
}
