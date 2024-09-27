package com.yh.windnacelle.service;

import java.util.List;
import com.yh.windnacelle.domain.WindImages;

/**
 * 图片识别Service接口
 *
 * @author wyy
 * @date 2024-09-14
 */
public interface IWindImagesService
{
    /**
     * 查询图片识别
     *
     * @param id 图片识别主键
     * @return 图片识别
     */
    public WindImages selectWindImagesById(Long id);

    /**
     * 查询图片识别列表
     *
     * @param windImages 图片识别
     * @return 图片识别集合
     */
    public List<WindImages> selectWindImagesList(WindImages windImages);

    /**
     * 新增图片识别
     *
     * @param windImages 图片识别
     * @return 结果
     */
    public int insertWindImages(WindImages windImages);

    /**
     * 修改图片识别
     *
     * @param windImages 图片识别
     * @return 结果
     */
    public int updateWindImages(WindImages windImages);

    /**
     * 批量删除图片识别
     *
     * @param ids 需要删除的图片识别主键集合
     * @return 结果
     */
    public int deleteWindImagesByIds(Long[] ids);

    /**
     * 删除图片识别信息
     *
     * @param id 图片识别主键
     * @return 结果
     */
    public int deleteWindImagesById(Long id);

    /**
     * 检测图片信息
     *
     * @param windImages 图片信息
     * @param enhance_Type
     * @return 结果
     */
    public int detection(List<WindImages> windImages, String enhance_Type);

    /**
     * 根据ids获取图片信息
     *
     * @param ids id集合
     * @return 结果
     */
    public List<WindImages> getWindImagesByIds(Long[] ids);
}
