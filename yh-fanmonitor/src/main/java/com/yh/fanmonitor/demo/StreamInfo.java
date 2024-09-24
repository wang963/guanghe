package com.yh.fanmonitor.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamInfo {

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("app")
    private String app;

    @JsonProperty("stream")
    private String stream;

    @JsonProperty("streamUrl")
    private String streamUrl;

    // �޲ι��캯��
    public StreamInfo() {}

    // ���ι��캯��
    public StreamInfo(String ip, String app, String stream, String streamUrl) {
        this.ip = ip;
        this.app = app;
        this.stream = stream;
        this.streamUrl = streamUrl;
    }

    // Getter �� Setter ����
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @Override
    public String toString() {
        return "StreamInfo{" +
                "ip='" + ip + '\'' +
                ", app='" + app + '\'' +
                ", stream='" + stream + '\'' +
                ", streamUrl='" + streamUrl + '\'' +
                '}';
    }
}
