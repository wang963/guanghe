package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 告警详细信息对象 wind_alert_objects
 *
 * @author wyy
 * @date 2024-09-24
 */
public class WindAlertObjects extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private int id;

    /**
     * 告警ID
     */
    @Excel(name = "告警ID")
    private int alertId;

    /**
     * 告警项
     */
    @Excel(name = "告警项")
    private String label;

    /**
     * 置信度
     */
    @Excel(name = "置信度")
    private Long confidence;

    /**
     * 框颜色
     */
    @Excel(name = "框颜色")
    private List<String> color;

    private String colorDba;

    /**
     * 坐标信息
     */
    @Excel(name = "坐标信息")
    private List<String> position;

    private String positionDba;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setConfidence(Long confidence) {
        this.confidence = confidence;
    }

    public Long getConfidence() {
        return confidence;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<String> getColor() {
        return color;
    }

    public void setPosition(List<String> position) {
        this.position = position;
    }

    public List<String> getPosition() {
        return position;
    }

    public String getColorDba() {
        return colorDba;
    }

    public void setColorDba(String colorDba) {
        this.colorDba = colorDba;
    }

    public String getPositionDba() {
        return positionDba;
    }

    public void setPositionDba(String positionDba) {
        this.positionDba = positionDba;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("alertId", getAlertId())
                .append("label", getLabel())
                .append("confidence", getConfidence())
                .append("color", getColor())
                .append("position", getPosition())
                .toString();
    }
}
