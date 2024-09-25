package com.yh.windnacelle.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 告警信息对象 wind_alerts
 *
 * @author wyy
 * @date 2024-09-21
 */
public class WindAlerts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** 告警时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "告警时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonProperty("alert_time")
    private Date alertTime;

    /** 设备ID */
    @JsonProperty("device_id")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    @JsonProperty("device_name")
    private String deviceName;

    /** 摄像头区域 */
    @Excel(name = "摄像头区域")
    private String camera;

    /** 摄像头IP地址 */
    @Excel(name = "摄像头IP地址")
    @JsonProperty("cam_ipv4")
    private String camIpv4;

    /** 算法名称 */
    @Excel(name = "算法名称")
    @JsonProperty("alg_name")
    private String algName;

    /** base64编码图片 */
    private List<String> imgs;

    private String imgpath;

    private List<List<WindAlertObjects>> objs;

    public List<List<WindAlertObjects>> getObjs() {
        return objs;
    }

    public void setObjs(List<List<WindAlertObjects>> objs) {
        this.objs = objs;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
    public void setAlertTime(Date alertTime)
    {
        this.alertTime = alertTime;
    }

    public Date getAlertTime()
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
    public void setImgs(List<String> imgs)
    {
        this.imgs = imgs;
    }

    public List<String> getImgs()
    {
        return imgs;
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
            .toString();
    }
}
