package com.yh.windnacelle.domain;

public class WindVideoCameraEnhanced {
    private Integer id;
    private String camera_ID;
    private Integer frameraId;
    private String timeStamp;
    private String imgPath;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCamera_ID() {
        return camera_ID;
    }

    public void setCamera_ID(String camera_ID) {
        this.camera_ID = camera_ID;
    }

    public Integer getFrameraId() {
        return frameraId;
    }

    public void setFrameraId(Integer frameraId) {
        this.frameraId = frameraId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
