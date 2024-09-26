package com.yh.windnacelle.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class CameraData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> time_stamp;

    private String cameraID;
    private int frameID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "camera_data_id")
    private List<DetectedObject> objects;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(List<String> time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getCameraID() {
        return cameraID;
    }

    public void setCameraID(String cameraID) {
        this.cameraID = cameraID;
    }

    public int getFrameID() {
        return frameID;
    }

    public void setFrameID(int frameID) {
        this.frameID = frameID;
    }

    public List<DetectedObject> getObjects() {
        return objects;
    }

    public void setObjects(List<DetectedObject> objects) {
        this.objects = objects;
    }
}
