package com.yh.windnacelle.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class WindVideoCameraData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> time_stamp;

    private String timeStampDba;

    private String cameraID;
    private int frameID;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 添加此注解
    private List<WindVideoDetectedObject> objects;

    // Getters and Setters


    public String getTimeStampDba() {
        return timeStampDba;
    }

    public void setTimeStampDba(String timeStampDba) {
        this.timeStampDba = timeStampDba;
    }

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

    public List<WindVideoDetectedObject> getObjects() {
        return objects;
    }

    public void setObjects(List<WindVideoDetectedObject> objects) {
        this.objects = objects;
    }
}
