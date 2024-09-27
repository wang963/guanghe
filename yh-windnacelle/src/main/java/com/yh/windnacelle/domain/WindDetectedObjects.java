package com.yh.windnacelle.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 图片检测返回结果对象 wind_detected_objects
 *
 * @author wyy
 * @date 2024-09-14
 */
public class WindDetectedObjects extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long imageId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long xmin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long xmax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ymin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ymax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double confidence;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @JsonProperty("class")
    private Long clazz;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date updatedAt;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setImageId(Long imageId)
    {
        this.imageId = imageId;
    }

    public Long getImageId()
    {
        return imageId;
    }
    public void setXmin(Long xmin)
    {
        this.xmin = xmin;
    }

    public Long getXmin()
    {
        return xmin;
    }
    public void setXmax(Long xmax)
    {
        this.xmax = xmax;
    }

    public Long getXmax()
    {
        return xmax;
    }
    public void setYmin(Long ymin)
    {
        this.ymin = ymin;
    }

    public Long getYmin()
    {
        return ymin;
    }
    public void setYmax(Long ymax)
    {
        this.ymax = ymax;
    }

    public Long getYmax()
    {
        return ymax;
    }
    public void setConfidence(Double confidence)
    {
        this.confidence = confidence;
    }

    public Double getConfidence()
    {
        return confidence;
    }
    public void setClazz(Long clazz)
    {
        this.clazz = clazz;
    }

    public Long getClazz()
    {
        return clazz;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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
            .append("imageId", getImageId())
            .append("xmin", getXmin())
            .append("xmax", getXmax())
            .append("ymin", getYmin())
            .append("ymax", getYmax())
            .append("confidence", getConfidence())
            .append("class", getClass())
            .append("name", getName())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
