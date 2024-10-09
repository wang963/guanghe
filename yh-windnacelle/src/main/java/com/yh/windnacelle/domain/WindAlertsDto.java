package com.yh.windnacelle.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 告警信息对象 wind_alerts 和 wind_camera
 *
 * @author Orion Huo
 * @date 2024-10-8
 */
public class WindAlertsDto extends BaseEntity
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

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 风机编号 */
    @Excel(name = "风机编号")
    private String fanId;

    /** 风机名称 */
    @Excel(name = "风机名称")
    private String fanName;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    public String getFanName() {
        return fanName;
    }

    public void setFanName(String fanName) {
        this.fanName = fanName;
    }

    @Override
    public String toString() {
        return "WindAlertsDto{" +
                "id=" + id +
                ", alertTime=" + alertTime +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", camera='" + camera + '\'' +
                ", camIpv4='" + camIpv4 + '\'' +
                ", algName='" + algName + '\'' +
                ", imgs=" + imgs +
                ", imgpath='" + imgpath + '\'' +
                ", state='" + state + '\'' +
                ", fanId='" + fanId + '\'' +
                ", fanName='" + fanName + '\'' +
                ", objs=" + objs +
                '}';
    }
}
