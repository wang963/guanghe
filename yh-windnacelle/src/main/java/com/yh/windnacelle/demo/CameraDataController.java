package com.yh.windnacelle.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camera-data")
public class CameraDataController {

    @Autowired
    private CameraDataService cameraDataService;

    @PostMapping("/test")
    public void receiveCameraData(@RequestBody List<List<CameraData>> cameraData) {
        // 处理接收到的 JSON 数据
        for (List<CameraData> dataList : cameraData) {
            cameraDataService.saveCameraData(dataList);
        }
    }
}
