package com.yh.windnacelle.mapper;

import com.yh.windnacelle.domain.WindVideoDetectedObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WindVideoDetectedObjectMapper {

    // 批量插入
    void insertBatch(@Param("objects") List<WindVideoDetectedObject> objects);

    // 查询所有记录
    List<WindVideoDetectedObject> findAll();

    // 根据 frameID 查询
    List<WindVideoDetectedObject> findByFrameID(@Param("frameID") int frameID);
}
