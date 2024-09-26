package com.yh.windnacelle.mapper;

import java.util.List;
import com.yh.windnacelle.domain.WindPersonImgpath;

/**
 * 人员图片列表Mapper接口
 *
 * @author wyy
 * @date 2024-09-26
 */
public interface WindPersonImgpathMapper
{
    /**
     * 查询人员图片列表
     *
     * @param id 人员图片列表主键
     * @return 人员图片列表
     */
    public WindPersonImgpath selectWindPersonImgpathById(Long id);

    /**
     * 查询人员图片列表列表
     *
     * @param windPersonImgpath 人员图片列表
     * @return 人员图片列表集合
     */
    public List<WindPersonImgpath> selectWindPersonImgpathList(WindPersonImgpath windPersonImgpath);

    /**
     * 根据personId查询
     *
     * @param personId 人员信息id
     * @return 人员信息集合
     */
    public List<WindPersonImgpath> selectWindPersonImgpathByPersonId(int personId);


    /**
     * 新增人员图片列表
     *
     * @param windPersonImgpath 人员图片列表
     * @return 结果
     */
    public int insertWindPersonImgpath(WindPersonImgpath windPersonImgpath);

    /**
     * 修改人员图片列表
     *
     * @param windPersonImgpath 人员图片列表
     * @return 结果
     */
    public int updateWindPersonImgpath(WindPersonImgpath windPersonImgpath);

    /**
     * 删除人员图片列表
     *
     * @param id 人员图片列表主键
     * @return 结果
     */
    public int deleteWindPersonImgpathById(Long id);

    /**
     * 批量删除人员图片列表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWindPersonImgpathByIds(Long[] ids);
}
