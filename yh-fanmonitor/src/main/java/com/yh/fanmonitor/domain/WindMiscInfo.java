package com.yh.fanmonitor.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 外发告警地址配置对象 wind_misc_info
 *
 * @author wyy
 * @date 2024-09-20
 */
public class WindMiscInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 字典key值 */
    @Excel(name = "字典key值")
    private String key;

    /** 外发警告地址 */
    @Excel(name = "外发警告地址")
    private String value;

    /** 状态码 */
    private Long code;

    /** 状态信息 */
    @Excel(name = "状态信息")
    private String msg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** $column.columnComment */
    private Date updatedAt;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
    public void setCode(Long code)
    {
        this.code = code;
    }

    public Long getCode()
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
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("key", getKey())
            .append("value", getValue())
            .append("code", getCode())
            .append("msg", getMsg())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
