package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindCamera;

/**
 * 视频维护Service接口
 *
 * @author zzs
 * @date 2024-07-03
 */
public interface IWindCameraService
{
    /**
     * 查询视频维护
     *
     * @param cameraId 视频维护主键
     * @return 视频维护
     */
    public WindCamera selectWindCameraByCameraId(Integer cameraId);

    /**
     * 查询视频维护列表
     *
     * @param windCamera 视频维护
     * @return 视频维护集合
     */
    public List<WindCamera> selectWindCameraList(WindCamera windCamera);

    /**
     * 新增视频维护
     *
     * @param windCamera 视频维护
     * @return 结果
     */
    public int insertWindCamera(WindCamera windCamera);

    /**
     * 修改视频维护
     *
     * @param windCamera 视频维护
     * @return 结果
     */
    public int updateWindCamera(WindCamera windCamera);

    /**
     * 批量删除视频维护
     *
     * @param cameraIds 需要删除的视频维护主键集合
     * @return 结果
     */
    public int deleteWindCameraByCameraIds(Integer[] cameraIds);

    /**
     * 删除视频维护信息
     *
     * @param cameraId 视频维护主键
     * @return 结果
     */
    public int deleteWindCameraByCameraId(Integer cameraId);
}
