package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 视频检测对象 wind_videoobj
 *
 * @author wyy
 * @date 2024-09-27
 */
public class WindVideoobj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 视频地址 */
    @Excel(name = "视频流地址")
    private String videoPath;

    /** 监控ID */
    @Excel(name = "监控ID")
    private String cameraId;

    /** 检测时长 */
    @Excel(name = "检测时长")
    private String detectTime;

    /** 是否保存 */
    @Excel(name = "是否保存")
    private String saveVideo;

    /** $column.columnComment */
    private String timeStamp;

    private String cameraName;

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setVideoPath(String videoPath)
    {
        this.videoPath = videoPath;
    }

    public String getVideoPath()
    {
        return videoPath;
    }
    public void setCameraId(String cameraId)
    {
        this.cameraId = cameraId;
    }

    public String getCameraId()
    {
        return cameraId;
    }
    public void setDetectTime(String detectTime)
    {
        this.detectTime = detectTime;
    }

    public String getDetectTime()
    {
        return detectTime;
    }
    public void setSaveVideo(String saveVideo)
    {
        this.saveVideo = saveVideo;
    }

    public String getSaveVideo()
    {
        return saveVideo;
    }
    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("videoPath", getVideoPath())
            .append("cameraId", getCameraId())
            .append("detectTime", getDetectTime())
            .append("saveVideo", getSaveVideo())
            .append("timeStamp", getTimeStamp())
            .toString();
    }
}
