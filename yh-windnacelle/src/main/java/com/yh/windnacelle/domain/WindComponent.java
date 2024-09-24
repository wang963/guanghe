package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 风机部件对象 wind_component
 *
 * @author zzs
 * @date 2024-07-15
 */
public class WindComponent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer componentId;

    /** 风机 */
    @Excel(name = "风机")
    private Integer fanId;
    /** 风机 */
    @Excel(name = "风机名称")
    private String fanName;
    /** 部件名称 */
    @Excel(name = "部件名称")
    private String componentName;

    /** 厂家 */
    @Excel(name = "厂家")
    private String componentFactory;

    /** 型号 */
    @Excel(name = "型号")
    private String componentModel;

    /** 温度上限 */
    @Excel(name = "温度上限")
    private String temperatureUpper;

    /** 温度下限 */
    @Excel(name = "温度下限")
    private String temperatureLower;

    /** 部件照片 */
    @Excel(name = "部件照片")
    private String cimage;

    /** 关联摄像头 */
    @Excel(name = "关联摄像头")
    private Integer cameraId;

    /** 关联视频标记 */
    @Excel(name = "关联视频标记")
    private String cameraTag;

    public void setComponentId(Integer componentId)
    {
        this.componentId = componentId;
    }

    public Integer getComponentId()
    {
        return componentId;
    }
    public void setFanId(Integer fanId)
    {
        this.fanId = fanId;
    }

    public Integer getFanId()
    {
        return fanId;
    }

    public void setFanName(String fanName)
    {
        this.fanName = fanName;
    }
    public String getFanName()
    {
        return fanName;
    }

    public void setComponentName(String componentName)
    {
        this.componentName = componentName;
    }

    public String getComponentName()
    {
        return componentName;
    }
    public void setComponentFactory(String componentFactory)
    {
        this.componentFactory = componentFactory;
    }

    public String getComponentFactory()
    {
        return componentFactory;
    }
    public void setComponentModel(String componentModel)
    {
        this.componentModel = componentModel;
    }

    public String getComponentModel()
    {
        return componentModel;
    }
    public void setTemperatureUpper(String temperatureUpper)
    {
        this.temperatureUpper = temperatureUpper;
    }

    public String getTemperatureUpper()
    {
        return temperatureUpper;
    }
    public void setTemperatureLower(String temperatureLower)
    {
        this.temperatureLower = temperatureLower;
    }

    public String getTemperatureLower()
    {
        return temperatureLower;
    }
    public void setCimage(String cimage)
    {
        this.cimage = cimage;
    }

    public String getCimage()
    {
        return cimage;
    }
    public void setCameraId(Integer cameraId)
    {
        this.cameraId = cameraId;
    }

    public Integer getCameraId()
    {
        return cameraId;
    }
    public void setCameraTag(String cameraTag)
    {
        this.cameraTag = cameraTag;
    }

    public String getCameraTag()
    {
        return cameraTag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("componentId", getComponentId())
            .append("fanId", getFanId())
            .append("componentName", getComponentName())
            .append("componentFactory", getComponentFactory())
            .append("componentModel", getComponentModel())
            .append("temperatureUpper", getTemperatureUpper())
            .append("temperatureLower", getTemperatureLower())
            .append("cimage", getCimage())
            .append("cameraId", getCameraId())
            .append("cameraTag", getCameraTag())
            .toString();
    }
}
