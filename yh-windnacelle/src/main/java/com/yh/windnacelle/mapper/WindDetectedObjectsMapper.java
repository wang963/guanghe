package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindDetectedObjects;

/**
 * 图片检测返回结果Mapper接口
 *
 * @author wyy
 * @date 2024-09-14
 */
public interface WindDetectedObjectsMapper
{
    /**
     * 查询图片检测返回结果
     *
     * @param id 图片检测返回结果主键
     * @return 图片检测返回结果
     */
    public WindDetectedObjects selectWindDetectedObjectsById(Long id);

    /**
     * 查询图片检测返回结果列表
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 图片检测返回结果集合
     */
    public List<WindDetectedObjects> selectWindDetectedObjectsList(WindDetectedObjects windDetectedObjects);

    /**
     * 新增图片检测返回结果
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 结果
     */
    public int insertWindDetectedObjects(WindDetectedObjects windDetectedObjects);

    /**
     * 修改图片检测返回结果
     *
     * @param windDetectedObjects 图片检测返回结果
     * @return 结果
     */
    public int updateWindDetectedObjects(WindDetectedObjects windDetectedObjects);

    /**
     * 删除图片检测返回结果
     *
     * @param id 图片检测返回结果主键
     * @return 结果
     */
    public int deleteWindDetectedObjectsById(Long id);

    /**
     * 批量删除图片检测返回结果
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindDetectedObjectsByIds(Long[] ids);

    void insertWindDetectedObjectsBatch(List<WindDetectedObjects> allDetectedObjects);
}
