package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 拉流配置对象 sys_stream
 *
 * @author zzs
 * @date 2024-09-11
 */
public class SysStream extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ip;

    /** app */
    @Excel(name = "app")
    private String app;

    /** stream */
    @Excel(name = "stream")
    private String stream;

    /** 视频流 */
    @Excel(name = "视频流")
    private String streamUrl;

    /** 请求状态 */
    @Excel(name = "请求状态")
    private String code;

    /** 请求描述 */
    @Excel(name = "请求描述")
    private String msg;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }
    public void setApp(String app)
    {
        this.app = app;
    }

    public String getApp()
    {
        return app;
    }
    public void setStream(String stream)
    {
        this.stream = stream;
    }

    public String getStream()
    {
        return stream;
    }
    public void setStreamUrl(String streamUrl)
    {
        this.streamUrl = streamUrl;
    }

    public String getStreamUrl()
    {
        return streamUrl;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getMsg()
    {
        return msg;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ip", getIp())
            .append("app", getApp())
            .append("stream", getStream())
            .append("streamUrl", getStreamUrl())
            .append("code", getCode())
            .append("msg", getMsg())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
