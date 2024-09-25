package com.yh.fanmonitor.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Orion Huo
 * @version 1.0.0
 * @since 2024-09-25 11:28:45
 **/

public class Utils {

    @Value("${ip}")
    private String plainCameraIp;

    public String getPlainCameraIp() {
        return plainCameraIp;
    }

    public static String getPrefixAddress() {
        return "http://" + new Utils().getPlainCameraIp() + "/open-api";
    }
}
