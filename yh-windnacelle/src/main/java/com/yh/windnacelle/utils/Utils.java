package com.yh.windnacelle.utils;

import com.yh.common.config.RuoYiConfig;
import com.yh.common.utils.DateUtils;
import com.yh.common.utils.StringUtils;
import com.yh.common.utils.uuid.Seq;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

/**
 * @author Orion Huo
 * @version 1.0.0
 * @since 2024-09-25 11:28:45
 **/

@Component
public class Utils {

    @Value("${ip}")
    private String plainCameraIp;

    @Value("${infraredIp}")
    private String infraredCameraIp;

    public String getPlainCameraIp() {
        return plainCameraIp;
    }

    public String getInfraredCameraIp() {
        return infraredCameraIp;
    }

    public String getPrefixAddress() {
        return "http://" + getPlainCameraIp() + "/open-api";
    }

    public String getInfraredPrefixAddress() {
        return "http://" + getInfraredCameraIp() + ":80/";
    }

    public static String getBaseName(String fileName) {
        int index1 = fileName.lastIndexOf('/');
        int index2 = fileName.lastIndexOf('.');
        if (index1 < 0) {
            return index2 > -1 ? fileName.substring(0, index2) : fileName;
        } else {
            return index2 > -1 ? fileName.substring(index1 + 1, index2) : fileName.substring(index1 + 1);
        }
    }

    public static String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    /**
     * 获取上传时的绝对路径
     * @param extractFilename 例如：2024/09/26/image_2_20240926144443A001.jpg
     * @return 例如：D:/ruoyi/uploadPath/upload/2024/09/26/image_2_20240926144443A001.jpg
     */
    public static String getAbsoluteUploadPath(String extractFilename) {
        return RuoYiConfig.getUploadPath() + "/" + extractFilename;
    }

    /**
     * 生成带日期路径的文件名
     * @param fileName 例如: demos/image1.jpg
     * @return 例如：2024/09/26/image_2_20240926144443A001.jpg
     */
    public static String extractFilename(String fileName) {
        return StringUtils.format("{}/{}_{}.{}", DateUtils.datePath(),
                Utils.getBaseName(fileName), Seq.getId(Seq.uploadSeqType),
                Utils.getExtension(fileName));
    }

    /**
     * 生成存储到数据库中的路径
     * @param extractFilename 例如： 2024/09/26/image_2_20240926144443A001.jpg
     * @return 例如：/profile/upload/2024/09/26/image_2_20240926144443A001.jpg
     */
    public static String getImagePath(String extractFilename) {
        return "/profile/upload/" + extractFilename;
    }

    public static String getBase64ForImage(String fileName) {
        String base64 = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();
            base64 = Base64.getEncoder().encodeToString(bytes);
            //System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64;
    }
}
