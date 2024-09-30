package com.yh.windnacelle.mapper;

import com.yh.windnacelle.domain.WindVideoCameraEnhanced;

import java.util.List;

public interface WindVideoCameraEnhancedMapper {
    void insertBach(List<WindVideoCameraEnhanced> windVideoCameraEnhanceds);
    void insert(WindVideoCameraEnhanced enhanced);
    WindVideoCameraEnhanced selectById(Integer id);
    List<WindVideoCameraEnhanced> selectAll();
    void update(WindVideoCameraEnhanced enhanced);
    void delete(Integer id);
}
