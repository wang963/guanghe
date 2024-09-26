package com.yh.windnacelle.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraDataService {

    @Autowired
    private CameraDataRepository cameraDataRepository;

    public void saveCameraData(List<CameraData> cameraDataList) {
        cameraDataRepository.saveAll(cameraDataList);
    }
}
