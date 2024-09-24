package com.yh.fanmonitor.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

    @JsonProperty("add_stream_msg")
    private String addStreamMsg;

    @JsonProperty("camera_id")
    private String cameraId;

    @JsonProperty("code")
    private int code; // 直接使用 int 类型

    private String msg;

    // Getter and Setter for addStreamMsg
    public String getAddStreamMsg() {
        return addStreamMsg;
    }

    public void setAddStreamMsg(String addStreamMsg) {
        this.addStreamMsg = addStreamMsg;
    }

    // Getter and Setter for cameraId
    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    // Getter and Setter for code
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // Getter and Setter for msg
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
