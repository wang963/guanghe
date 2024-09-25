package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindVideoobj;

/**
 * 视频检测Service接口
 *
 * @author wyy
 * @date 2024-09-18
 */
public interface IWindVideoobjService
{
    /**
     * 查询视频检测
     *
     * @param id 视频检测主键
     * @return 视频检测
     */
    public WindVideoobj selectWindVideoobjById(Long id);

    /**
     * 查询视频检测列表
     *
     * @param windVideoobj 视频检测
     * @return 视频检测集合
     */
    public List<WindVideoobj> selectWindVideoobjList(WindVideoobj windVideoobj);

    /**
     * 新增视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    public int insertWindVideoobj(WindVideoobj windVideoobj);

    /**
     * 修改视频检测
     *
     * @param windVideoobj 视频检测
     * @return 结果
     */
    public int updateWindVideoobj(WindVideoobj windVideoobj);

    /**
     * 批量删除视频检测
     *
     * @param ids 需要删除的视频检测主键集合
     * @return 结果
     */
    public int deleteWindVideoobjByIds(Long[] ids);

    /**
     * 删除视频检测信息
     *
     * @param id 视频检测主键
     * @return 结果
     */
    public int deleteWindVideoobjById(Long id);
}
