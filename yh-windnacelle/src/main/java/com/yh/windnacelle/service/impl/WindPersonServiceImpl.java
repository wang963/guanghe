package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.domain.ApiResponse;
import com.yh.windnacelle.service.IWindPersonService;
import com.yh.windnacelle.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindPersonMapper;
import com.yh.windnacelle.domain.WindPerson;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * 人员信息Service业务层处理
 *
 * @author wyy
 * @date 2024-09-13
 */
@Service
public class WindPersonServiceImpl implements IWindPersonService {
    @Autowired
    private WindPersonMapper windPersonMapper;

    @Autowired
    private Utils utils;

    /**
     * 查询人员信息
     *
     * @param id 人员信息主键
     * @return 人员信息
     */
    @Override
    public WindPerson selectWindPersonById(Long id) {
        return windPersonMapper.selectWindPersonById(id);
    }

    /**
     * 查询人员信息列表
     *
     * @param windPerson 人员信息
     * @return 人员信息
     */
    @Override
    public List<WindPerson> selectWindPersonList(WindPerson windPerson) {
        return windPersonMapper.selectWindPersonList(windPerson);
    }

    /**
     * 新增人员信息
     *
     * @param windPerson 人员信息
     * @return 结果
     */
    @Override
    public String insertWindPerson(WindPerson windPerson) {
        //先执行插入操作
        int x = windPersonMapper.insertWindPerson(windPerson);
        if (x <= 0) {
            return "数据库插入失败！";
        }
//         插入成功后调用外部接口
        String url = utils.getPrefixAddress() +"/addAlgorithmProperty"; // 确保URL完整
        RestTemplate restTemplate = new RestTemplate();
        try {
            // 调用外部接口
            ApiResponse response = restTemplate.postForObject(url, windPerson, ApiResponse.class);
            // 检查接口返回值
            if (response == null || response.getCode() != 2000) {
                // 如果接口调用失败，抛出异常以回滚事务
                throw new RuntimeException(response != null ? response.getMsg() : "人员添加失败，接口返回值为空");
            }
        } catch (ResourceAccessException e) {
            // 处理超时或连接失败的情况
            throw new RuntimeException("接口调用超时或连接失败: " + e.getMessage(), e);
        }
        return "success";
    }

    /**
     * 修改人员信息
     *
     * @param windPerson 人员信息
     * @return 结果
     */
    @Override
    public int updateWindPerson(WindPerson windPerson) {
        return windPersonMapper.updateWindPerson(windPerson);
    }

    /**
     * 批量删除人员信息
     *
     * @param ids 需要删除的人员信息主键
     * @return 结果
     */
    @Override
    public int deleteWindPersonByIds(Long[] ids) {
        return windPersonMapper.deleteWindPersonByIds(ids);
    }

    /**
     * 删除人员信息信息
     *
     * @param id 人员信息主键
     * @return 结果
     */
    @Override
    public int deleteWindPersonById(Long id) {
        return windPersonMapper.deleteWindPersonById(id);
    }
}
