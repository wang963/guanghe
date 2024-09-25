package com.yh.windnacelle.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamResponse {

    @JsonProperty("add_stream_msg")
    private String addStreamMsg;

    @JsonProperty("camera_id")
    private String cameraId;

    @JsonProperty("code")
    private int code;

    @JsonProperty("msg")
    private String msg;

    // 无参构造函数
    public StreamResponse() {}

    // 带参构造函数
    public StreamResponse(String addStreamMsg, String cameraId, int code, String msg) {
        this.addStreamMsg = addStreamMsg;
        this.cameraId = cameraId;
        this.code = code;
        this.msg = msg;
    }

    // Getter 和 Setter 方法
    public String getAddStreamMsg() {
        return addStreamMsg;
    }

    public void setAddStreamMsg(String addStreamMsg) {
        this.addStreamMsg = addStreamMsg;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "StreamResponse{" +
                "addStreamMsg='" + addStreamMsg + '\'' +
                ", cameraId='" + cameraId + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
