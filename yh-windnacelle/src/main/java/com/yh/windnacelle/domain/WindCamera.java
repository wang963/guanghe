package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 视频维护对象 wind_camera
 *
 * @author zzs
 * @date 2024-07-03
 */
public class WindCamera extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer cameraId;

    /** 监控编号 */
    @Excel(name = "监控编号")
    private String cameraName;

    /** 所属风机 */
    @Excel(name = "所属风机")
    private Integer fanId;

    /** 风机名称 */
    @Excel(name = "风机名称")
    private String fanName;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String position;

    /** 监控类型 */
    @Excel(name = "监控类型")
    private String cameraType;

    /** 视频URL */
    @Excel(name = "视频URL")
    private String cameraUrl;

    public void setCameraId(Integer cameraId)
    {
        this.cameraId = cameraId;
    }

    public Integer getCameraId()
    {
        return cameraId;
    }
    public void setCameraName(String cameraName)
    {
        this.cameraName = cameraName;
    }

    public String getCameraName()
    {
        return cameraName;
    }
    public void setFanId(Integer fanId)
    {
        this.fanId = fanId;
    }

    public Integer getFanId()
    {
        return fanId;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getFanName() {
        return fanName;
    }

    public void setFanName(String fanName) {
        this.fanName = fanName;
    }

    public String getPosition()
    {
        return position;
    }
    public void setCameraType(String cameraType)
    {
        this.cameraType = cameraType;
    }

    public String getCameraType()
    {
        return cameraType;
    }
    public void setCameraUrl(String cameraUrl)
    {
        this.cameraUrl = cameraUrl;
    }

    public String getCameraUrl()
    {
        return cameraUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cameraId", getCameraId())
            .append("cameraName", getCameraName())
            .append("fanId", getFanId())
            .append("position", getPosition())
            .append("cameraType", getCameraType())
            .append("cameraUrl", getCameraUrl())
            .toString();
    }
}
