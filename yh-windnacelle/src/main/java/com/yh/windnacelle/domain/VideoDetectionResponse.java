package com.yh.windnacelle.domain;

import java.util.List;

public class VideoDetectionResponse {
    private List<List<WindVideoCameraData>> cameraDataList;

    public List<List<WindVideoCameraData>> getCameraDataList() {
        return cameraDataList;
    }

    public void setCameraDataList(List<List<WindVideoCameraData>> cameraDataList) {
        this.cameraDataList = cameraDataList;
    }
}
