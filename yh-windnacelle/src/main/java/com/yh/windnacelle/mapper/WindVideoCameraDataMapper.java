package com.yh.windnacelle.mapper;

import com.yh.windnacelle.domain.WindVideoCameraData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WindVideoCameraDataMapper {
    // 批量插入
    void insertBatch(@Param("objects") List<WindVideoCameraData> objects);

    // 查询所有记录
    List<WindVideoCameraData> findAll();

    // 根据 frameID 查询
}
