package com.yh.fanmonitor.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 视频检测对象 wind_videoobj
 *
 * @author wyy
 * @date 2024-09-18
 */
public class WindVideoobj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** frame_id */
    @Excel(name = "frame_id")
    private Long frameId;

    /** 视频地址 */
    @Excel(name = "视频地址")
    private String videoPath;

    /** 监控id */
    @Excel(name = "监控id")
    private Long cameraId;

    /** 时间节点 */
    @Excel(name = "时间节点")
    private String detectTime;

    /** 是否保存 */
    @Excel(name = "是否保存")
    private String saveVideo;

    /** 时间戳 */
    private String timeStamp;

    /** 监控名称 */
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
    public void setFrameId(Long frameId)
    {
        this.frameId = frameId;
    }

    public Long getFrameId()
    {
        return frameId;
    }
    public void setVideoPath(String videoPath)
    {
        this.videoPath = videoPath;
    }

    public String getVideoPath()
    {
        return videoPath;
    }
    public void setCameraId(Long cameraId)
    {
        this.cameraId = cameraId;
    }

    public Long getCameraId()
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
            .append("frameId", getFrameId())
            .append("videoPath", getVideoPath())
            .append("cameraId", getCameraId())
            .append("detectTime", getDetectTime())
            .append("saveVideo", getSaveVideo())
            .append("timeStamp", getTimeStamp())
            .toString();
    }
}
