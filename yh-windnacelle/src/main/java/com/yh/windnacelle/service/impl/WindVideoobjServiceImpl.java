package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.demo.WindVideoDto;
import com.yh.windnacelle.domain.VideoDetectionResponse;
import com.yh.windnacelle.domain.WindVideoCameraData;
import com.yh.windnacelle.domain.WindVideoDetectedObject;
import com.yh.windnacelle.mapper.WindVideoCameraDataMapper;
import com.yh.windnacelle.mapper.WindVideoDetectedObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindVideoobjMapper;
import com.yh.windnacelle.domain.WindVideoobj;
import com.yh.windnacelle.service.IWindVideoobjService;
import org.springframework.web.client.RestTemplate;

/**
 * 视频检测Service业务层处理
 *
 * @author wyy
 * @date 2024-09-27
 */
@Service
public class WindVideoobjServiceImpl implements IWindVideoobjService {
    @Autowired
    private WindVideoobjMapper windVideoobjMapper;

    @Autowired
    private WindVideoDetectedObjectMapper windVideoDetectedObjectMapper;

    @Autowired
    private WindVideoCameraDataMapper windVideoCameraDataMapper;
    /**
     * 查询视频检测
     *
     * @param id 视频检测主键
     * @return 视频检测
     */
    @Override
    public WindVideoobj selectWindVideoobjById(Long id) {
        return windVideoobjMapper.selectWindVideoobjById(id);
    }

    /**
     * 查询视频检测列表
     *
     * @param windVideoobj 视频检测
     * @return 视频检测
     */
    @Override
    public List<WindVideoobj> selectWindVideoobjList(WindVideoobj windVideoobj) {
        return windVideoobjMapper.selectWindVideoobjList(windVideoobj);
    }

    /**
     * 新增视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    @Override
    public int insertWindVideoobj(WindVideoobj windVideoobj) {
        return windVideoobjMapper.insertWindVideoobj(windVideoobj);
    }

    /**
     * 修改视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    @Override
    public int updateWindVideoobj(WindVideoobj windVideoobj) {
        return windVideoobjMapper.updateWindVideoobj(windVideoobj);
    }

    /**
     * 批量删除视频检测
     *
     * @param ids 需要删除的视频检测主键
     * @return 结果
     */
    @Override
    public int deleteWindVideoobjByIds(Long[] ids) {
        return windVideoobjMapper.deleteWindVideoobjByIds(ids);
    }

    /**
     * 删除视频检测信息
     *
     * @param id 视频检测主键
     * @return 结果
     */
    @Override
    public int deleteWindVideoobjById(Long id) {
        return windVideoobjMapper.deleteWindVideoobjById(id);
    }

    /**
     * 视频检测
     *
     * @param windVideoDto
     */
    @Override
    public int videoDetection(WindVideoDto windVideoDto) {
        String url = "http://47.94.239.117:80/videoObjDetection/None/Bboxs";
        RestTemplate restTemplate = new RestTemplate();
        VideoDetectionResponse videoDetectionResponse = restTemplate.postForObject(url, windVideoDto, VideoDetectionResponse.class);
        List<List<WindVideoCameraData>> cameraDataList = videoDetectionResponse.getCameraDataList();
        String time_stamp = cameraDataList.get(0).get(0).getTime_stamp().toString();
        List<WindVideoCameraData> windVideoCameraData = cameraDataList.remove(0);

        for (WindVideoCameraData windVideoCameraData1 : windVideoCameraData) {
            List<WindVideoDetectedObject> objects = windVideoCameraData1.getObjects();
            windVideoCameraData1.setTimeStampDba(time_stamp);
            windVideoDetectedObjectMapper.insertBatch(objects);
        }
        windVideoCameraDataMapper.insertBatch(windVideoCameraData);

        return 0;
    }


    /**
     * 视频检测
     *
     * @param windVideoDto
     */
//    @Override
    public int videoEnhanced(WindVideoDto windVideoDto) {
        String url = "http://47.94.239.117:80/videoObjDetection/None/Bboxs";
        RestTemplate restTemplate = new RestTemplate();
        VideoDetectionResponse videoDetectionResponse = restTemplate.postForObject(url, windVideoDto, VideoDetectionResponse.class);
        List<List<WindVideoCameraData>> cameraDataList = videoDetectionResponse.getCameraDataList();
        String time_stamp = cameraDataList.get(0).get(0).getTime_stamp().toString();
        List<WindVideoCameraData> windVideoCameraData = cameraDataList.remove(0);

        for (WindVideoCameraData windVideoCameraData1 : windVideoCameraData) {
            List<WindVideoDetectedObject> objects = windVideoCameraData1.getObjects();
            windVideoCameraData1.setTimeStampDba(time_stamp);
            windVideoDetectedObjectMapper.insertBatch(objects);
        }
        windVideoCameraDataMapper.insertBatch(windVideoCameraData);

        return 0;
    }

}
