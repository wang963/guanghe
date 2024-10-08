package com.yh.windnacelle.domain;

/**
 * @author Orion Huo
 * @version 1.0.0
 * @since 2024-09-30 16:58:00
 **/

public class CompTemperatureDto {
    private String name;
    private float value;
    private String alarm;
    private String time;
    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
