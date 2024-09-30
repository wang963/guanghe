package com.yh.windnacelle.demo;

import java.util.List;

public class WindVideoDto {
    private List<String> video_path;
    private List<String> camera_ID;
    private String detect_time;
    private String save_video;

    public List<String> getVideo_path() {
        return video_path;
    }

    public void setVideo_path(List<String> video_path) {
        this.video_path = video_path;
    }

    public List<String> getCamera_ID() {
        return camera_ID;
    }

    public void setCamera_ID(List<String> camera_ID) {
        this.camera_ID = camera_ID;
    }

    public String getDetect_time() {
        return detect_time;
    }

    public void setDetect_time(String detect_time) {
        this.detect_time = detect_time;
    }

    public String getSave_video() {
        return save_video;
    }

    public void setSave_video(String save_video) {
        this.save_video = save_video;
    }
}
