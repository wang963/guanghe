package com.yh.windnacelle.service.impl;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.yh.windnacelle.mapper.WindFanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindCameraMapper;
import com.yh.windnacelle.domain.WindCamera;
import com.yh.windnacelle.service.IWindCameraService;

/**
 * 视频维护Service业务层处理
 *
 * @author zzs
 * @date 2024-07-03
 */
@Service
public class WindCameraServiceImpl implements IWindCameraService
{
    @Autowired
    private WindCameraMapper windCameraMapper;
    @Autowired
    private WindFanMapper windFanMapper;

    /**
     * 查询视频维护
     *
     * @param cameraId 视频维护主键
     * @return 视频维护
     */
    @Override
    public WindCamera selectWindCameraByCameraId(Integer cameraId)
    {
        return windCameraMapper.selectWindCameraByCameraId(cameraId);
    }

    /**
     * 查询视频维护列表
     *
     * @param windCamera 视频维护
     * @return 视频维护
     */
    @Override
    public List<WindCamera> selectWindCameraList(WindCamera windCamera)
    {
        return windCameraMapper.selectWindCameraList(windCamera);
    }

    /**
     * 新增视频维护
     *
     * @param windCamera 视频维护
     * @return 结果
     */
    @Override
    public int insertWindCamera(WindCamera windCamera)
    {
        windCamera.setFanName(windFanMapper.selectWindFanByFanId(windCamera.getFanId()).getFanName());
        windCamera.setCameraId(LocalDateTime.now().toString());
        return windCameraMapper.insertWindCamera(windCamera);
    }

    /**
     * 修改视频维护
     *
     * @param windCamera 视频维护
     * @return 结果
     */
    @Override
    public int updateWindCamera(WindCamera windCamera)
    {
        windCamera.setFanName(windFanMapper.selectWindFanByFanId(windCamera.getFanId()).getFanName());
        return windCameraMapper.updateWindCamera(windCamera);
    }

    /**
     * 批量删除视频维护
     *
     * @param cameraIds 需要删除的视频维护主键
     * @return 结果
     */
    @Override
    public int deleteWindCameraByCameraIds(Integer[] cameraIds)
    {
        return windCameraMapper.deleteWindCameraByCameraIds(cameraIds);
    }

    /**
     * 删除视频维护信息
     *
     * @param cameraId 视频维护主键
     * @return 结果
     */
    @Override
    public int deleteWindCameraByCameraId(Integer cameraId)
    {
        return windCameraMapper.deleteWindCameraByCameraId(cameraId);
    }
}
