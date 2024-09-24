package com.yh.fanmonitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 异常告警对象 wind_alarm
 *
 * @author zzs
 * @date 2024-07-29
 */
public class WindAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** 告警时间 */
    @Excel(name = "告警时间")
    private String alertTime;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 摄像头区域 */
    @Excel(name = "摄像头区域")
    private String camera;

    /** 摄像头IP */
    @Excel(name = "摄像头IP")
    private String camIpv4;

    /** 告警名称 */
    @Excel(name = "告警名称")
    private String algName;

    /** 图片 */
    @Excel(name = "图片")
    private String imgs;

    /** 告警内容 */
    private String objs;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setAlertTime(String alertTime)
    {
        this.alertTime = alertTime;
    }

    public String getAlertTime()
    {
        return alertTime;
    }
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId()
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }
    public void setCamera(String camera)
    {
        this.camera = camera;
    }

    public String getCamera()
    {
        return camera;
    }
    public void setCamIpv4(String camIpv4)
    {
        this.camIpv4 = camIpv4;
    }

    public String getCamIpv4()
    {
        return camIpv4;
    }
    public void setAlgName(String algName)
    {
        this.algName = algName;
    }

    public String getAlgName()
    {
        return algName;
    }
    public void setImgs(String imgs)
    {
        this.imgs = imgs;
    }

    public String getImgs()
    {
        return imgs;
    }
    public void setObjs(String objs)
    {
        this.objs = objs;
    }

    public String getObjs()
    {
        return objs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("alertTime", getAlertTime())
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("camera", getCamera())
            .append("camIpv4", getCamIpv4())
            .append("algName", getAlgName())
            .append("imgs", getImgs())
            .append("objs", getObjs())
            .toString();
    }
}
