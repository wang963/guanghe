package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindImages;

/**
 * 图片识别Mapper接口
 *
 * @author wyy
 * @date 2024-09-14
 */
public interface WindImagesMapper
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
     * 删除图片识别
     *
     * @param id 图片识别主键
     * @return 结果
     */
    public int deleteWindImagesById(Long id);

    /**
     * 批量删除图片识别
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindImagesByIds(Long[] ids);

    public List<WindImages> getWindImagesByIds(Long[] ids);

    Long getWindImagesIdByName(String imageName);

    int deleteWindDetectedObjectsByIds(List<Long> imageIds);

    int updateImagePahtByName(WindImages windImages);

    WindImages getWindImagesById(Long id);
}
