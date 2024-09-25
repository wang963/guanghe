package com.yh.fanmonitor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Orion Huo
 * @version 1.0.0
 * @since 2024-09-25 11:28:45
 **/

@Component
public class Utils {

    @Value("${ip}")
    private String plainCameraIp;

    public String getPlainCameraIp() {
        return plainCameraIp;
    }

    public String getPrefixAddress() {
        return "http://" + getPlainCameraIp() + "/open-api";
    }
}
