package com.yh.fanmonitor.service.impl;

import java.util.List;

import com.yh.fanmonitor.domain.VideoDetectionResponse;
import com.yh.fanmonitor.domain.WindDetectedObjects;
import com.yh.fanmonitor.mapper.WindDetectedObjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.WindVideoobjMapper;
import com.yh.fanmonitor.domain.WindVideoobj;
import com.yh.fanmonitor.service.IWindVideoobjService;
import org.springframework.web.client.RestTemplate;

/**
 * 视频检测Service业务层处理
 *
 * @author wyy
 * @date 2024-09-18
 */
@Service
public class WindVideoobjServiceImpl implements IWindVideoobjService
{
    @Autowired
    private WindVideoobjMapper windVideoobjMapper;

    @Autowired
    private WindDetectedObjectsMapper windDetectedObjectsMapper;

    /**
     * 查询视频检测
     *
     * @param id 视频检测主键
     * @return 视频检测
     */
    @Override
    public WindVideoobj selectWindVideoobjById(Long id)
    {
        return windVideoobjMapper.selectWindVideoobjById(id);
    }

    /**
     * 查询视频检测列表
     *
     * @param windVideoobj 视频检测
     * @return 视频检测
     */
    @Override
    public List<WindVideoobj> selectWindVideoobjList(WindVideoobj windVideoobj)
    {
        return windVideoobjMapper.selectWindVideoobjList(windVideoobj);
    }

    /**
     * 新增视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    @Override
    public int insertWindVideoobj(WindVideoobj windVideoobj)
    {
        String url = "http://47.94.239.117:80/videoObjDetection/None/Images";
        RestTemplate restTemplate = new RestTemplate();
        VideoDetectionResponse videoDetectionResponse = restTemplate.postForObject(url, windVideoobj, VideoDetectionResponse.class);
        windVideoobj.setTimeStamp(videoDetectionResponse.getTimestamps().toString());
        List<WindDetectedObjects> windDetectedObjectsList = videoDetectionResponse.getWindDetectedObjectsList();
        windDetectedObjectsMapper.insertWindDetectedObjectsBatch(windDetectedObjectsList);
        return windVideoobjMapper.insertWindVideoobj(windVideoobj);
    }

    /**
     * 修改视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    @Override
    public int updateWindVideoobj(WindVideoobj windVideoobj)
    {
        return windVideoobjMapper.updateWindVideoobj(windVideoobj);
    }

    /**
     * 批量删除视频检测
     *
     * @param ids 需要删除的视频检测主键
     * @return 结果
     */
    @Override
    public int deleteWindVideoobjByIds(Long[] ids)
    {
        return windVideoobjMapper.deleteWindVideoobjByIds(ids);
    }

    /**
     * 删除视频检测信息
     *
     * @param id 视频检测主键
     * @return 结果
     */
    @Override
    public int deleteWindVideoobjById(Long id)
    {
        return windVideoobjMapper.deleteWindVideoobjById(id);
    }
}
