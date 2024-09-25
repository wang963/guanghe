package com.yh.windnacelle.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 摄像机配置信息对象 sys_camera
 *
 * @author wyy
 * @date 2024-09-12
 */
public class SysCamera extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 监控id
     */
    @Excel(name = "监控id")
    private String camera_id;

    /**
     * IP地址
     */
    @Excel(name = "IP地址")
    private String ip;

    /**
     * APP
     */
    @Excel(name = "APP")
    private String app;

    /**
     * stream
     */
    @Excel(name = "stream")
    private String stream;

    /**
     * 视频流
     */
    @Excel(name = "视频流")
    private String streamUrl;

    /**
     * 算法ID
     */
    @Excel(name = "算法ID")
    private String algorithmId;

    /**
     * 置信度
     */
    @Excel(name = "置信度")
    private Long confidence;

    /**
     * 告警间隔
     */
    @Excel(name = "告警间隔")
    private Long alarmIntervalSeconds;

    /**
     * 告警区域
     */
    @Excel(name = "告警区域")
    private String alarmArea;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 监控名称 **/
    private String cameraName;



    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }



    /**
     * 状态
     **/
    @Excel(name = "请求状态")
    private int status;

    /** 响应状态码 **/
    private int code;

    /** 相应信息 **/
    private String msg;

    /** 拉流配置返回信息 **/
    @JsonProperty("add_stream_msg")
    private String addStreamMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddStreamMsg() {
        return addStreamMsg;
    }

    public void setAddStreamMsg(String addStreamMsg) {
        this.addStreamMsg = addStreamMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCameraId(String camera_id) {
        this.camera_id = camera_id;
    }

    public String getCameraId() {
        return camera_id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApp() {
        return app;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setAlgorithmId(String algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAlgorithmId() {
        return algorithmId;
    }

    public void setConfidence(Long confidence) {
        this.confidence = confidence;
    }

    public Long getConfidence() {
        return confidence;
    }

    public void setAlarmIntervalSeconds(Long alarmIntervalSeconds) {
        this.alarmIntervalSeconds = alarmIntervalSeconds;
    }

    public Long getAlarmIntervalSeconds() {
        return alarmIntervalSeconds;
    }

    public void setAlarmArea(String alarmArea) {
        this.alarmArea = alarmArea;
    }

    public String getAlarmArea() {
        return alarmArea;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cameraId", getCameraId())
                .append("ip", getIp())
                .append("app", getApp())
                .append("stream", getStream())
                .append("streamUrl", getStreamUrl())
                .append("algorithmId", getAlgorithmId())
                .append("confidence", getConfidence())
                .append("alarmIntervalSeconds", getAlarmIntervalSeconds())
                .append("alarmArea", getAlarmArea())
                .append("createdAt", getCreatedAt())
                .append("updatedAt", getUpdatedAt())
                .append("status", getStatus())
                .toString();
    }
}
