package com.yh.fanmonitor.service.impl;

import java.util.List;

import com.yh.fanmonitor.domain.WindImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.WindDetectedObjectsMapper;
import com.yh.fanmonitor.domain.WindDetectedObjects;
import com.yh.fanmonitor.service.IWindDetectedObjectsService;

/**
 * 图片检测返回结果Service业务层处理
 *
 * @author wyy
 * @date 2024-09-14
 */
@Service
public class WindDetectedObjectsServiceImpl implements IWindDetectedObjectsService
{
    @Autowired
    private WindDetectedObjectsMapper windDetectedObjectsMapper;

    /**
     * 查询图片检测返回结果
     *
     * @param id 图片检测返回结果主键
     * @return 图片检测返回结果
     */
    @Override
    public WindDetectedObjects selectWindDetectedObjectsById(Long id)
    {
        return windDetectedObjectsMapper.selectWindDetectedObjectsById(id);
    }

    /**
     * 查询图片检测返回结果列表
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 图片检测返回结果
     */
    @Override
    public List<WindDetectedObjects> selectWindDetectedObjectsList(WindDetectedObjects windDetectedObjects)
    {
        return windDetectedObjectsMapper.selectWindDetectedObjectsList(windDetectedObjects);
    }

    /**
     * 新增图片检测返回结果
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 结果
     */
    @Override
    public int insertWindDetectedObjects(WindDetectedObjects windDetectedObjects)
    {
        return windDetectedObjectsMapper.insertWindDetectedObjects(windDetectedObjects);
    }

    /**
     * 修改图片检测返回结果
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 结果
     */
    @Override
    public int updateWindDetectedObjects(WindDetectedObjects windDetectedObjects)
    {
        return windDetectedObjectsMapper.updateWindDetectedObjects(windDetectedObjects);
    }

    /**
     * 批量删除图片检测返回结果
     *
     * @param ids 需要删除的图片检测返回结果主键
     * @return 结果
     */
    @Override
    public int deleteWindDetectedObjectsByIds(Long[] ids)
    {
        return windDetectedObjectsMapper.deleteWindDetectedObjectsByIds(ids);
    }

    /**
     * 删除图片检测返回结果信息
     *
     * @param id 图片检测返回结果主键
     * @return 结果
     */
    @Override
    public int deleteWindDetectedObjectsById(Long id)
    {
        return windDetectedObjectsMapper.deleteWindDetectedObjectsById(id);
    }
}
