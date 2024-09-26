package com.yh.windnacelle.domain;

import com.yh.windnacelle.demo.CameraData;

import java.util.List;

public class VideoDetectionResponse {
    private List<List<CameraData>> cameraDataList;

    public List<List<CameraData>> getCameraDataList() {
        return cameraDataList;
    }

    public void setCameraDataList(List<List<CameraData>> cameraDataList) {
        this.cameraDataList = cameraDataList;
    }
}
