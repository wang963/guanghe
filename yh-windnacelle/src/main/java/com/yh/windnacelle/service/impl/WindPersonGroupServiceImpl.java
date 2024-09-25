package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.domain.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindPersonGroupMapper;
import com.yh.windnacelle.domain.WindPersonGroup;
import com.yh.windnacelle.service.IWindPersonGroupService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * 人员分组管理Service业务层处理
 *
 * @author wyy
 * @date 2024-09-13
 */
@Service
public class WindPersonGroupServiceImpl implements IWindPersonGroupService {
    @Autowired
    private WindPersonGroupMapper windPersonGroupMapper;

    /**
     * 查询人员分组管理
     *
     * @param id 人员分组管理主键
     * @return 人员分组管理
     */
    @Override
    public WindPersonGroup selectWindPersonGroupById(Long id) {
        return windPersonGroupMapper.selectWindPersonGroupById(id);
    }

    /**
     * 查询人员分组管理列表
     *
     * @param windPersonGroup 人员分组管理
     * @return 人员分组管理
     */
    @Override
    public List<WindPersonGroup> selectWindPersonGroupList(WindPersonGroup windPersonGroup) {
        return windPersonGroupMapper.selectWindPersonGroupList(windPersonGroup);
    }

    /**
     * 新增人员分组管理
     *
     * @param windPersonGroup 人员分组管理
     * @return 结果
     */
    @Transactional
    @Override
    public String insertWindPersonGroup(WindPersonGroup windPersonGroup) {
        //先执行插入操作
        int i = windPersonGroupMapper.insertWindPersonGroup(windPersonGroup);
        if (i <= 0) {
            return "数据库插入失败！";
        }
        // 插入成功后调用外部接口
        String url = "http://localhost:8080/open-api/addAlgorithmProperty"; // 确保URL完整
        RestTemplate restTemplate = new RestTemplate();
        try {
            // 调用外部接口
            ApiResponse response = restTemplate.postForObject(url, windPersonGroup, ApiResponse.class);
            // 检查接口返回值
            if (response == null || response.getCode() != 2000) {
                // 如果接口调用失败，抛出异常以回滚事务
                throw new RuntimeException(response != null ? response.getMsg() : "组织添加失败，接口返回值为空");
            }
        } catch (ResourceAccessException e) {
            // 处理超时或连接失败的情况
            throw new RuntimeException("接口调用超时或连接失败: " + e.getMessage(), e);
        }
        return "success";
    }

    /**
     * 修改人员分组管理
     *
     * @param windPersonGroup 人员分组管理
     * @return 结果
     */
    @Override
    public int updateWindPersonGroup(WindPersonGroup windPersonGroup) {
        return windPersonGroupMapper.updateWindPersonGroup(windPersonGroup);
    }

    /**
     * 批量删除人员分组管理
     *
     * @param ids 需要删除的人员分组管理主键
     * @return 结果
     */
    @Override
    public int deleteWindPersonGroupByIds(Long[] ids) {
        return windPersonGroupMapper.deleteWindPersonGroupByIds(ids);
    }

    /**
     * 删除人员分组管理信息
     *
     * @param id 人员分组管理主键
     * @return 结果
     */
    @Override
    public int deleteWindPersonGroupById(Long id) {
        return windPersonGroupMapper.deleteWindPersonGroupById(id);
    }
}
