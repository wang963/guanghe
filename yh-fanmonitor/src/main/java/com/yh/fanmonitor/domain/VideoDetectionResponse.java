package com.yh.fanmonitor.domain;

import java.util.List;

public class VideoDetectionResponse {
    private List<Timestamp> timestamps;
    private List<WindDetectedObjects> windDetectedObjectsList;

    public List<Timestamp> getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(List<Timestamp> timestamps) {
        this.timestamps = timestamps;
    }

    public List<WindDetectedObjects> getWindDetectedObjectsList() {
        return windDetectedObjectsList;
    }

    public void setWindDetectedObjectsList(List<WindDetectedObjects> windDetectedObjectsList) {
        this.windDetectedObjectsList = windDetectedObjectsList;
    }
}
