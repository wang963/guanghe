package com.yh.windnacelle.domain.response;

import com.yh.windnacelle.domain.WindImages;

import java.util.List;

public class DetectionResponse {

    private List<WindImages> windImagesList;

    public List<WindImages> getWindImagesList() {
        return windImagesList;
    }

    public void setWindImagesList(List<WindImages> windImagesList) {
        this.windImagesList = windImagesList;
    }
}
