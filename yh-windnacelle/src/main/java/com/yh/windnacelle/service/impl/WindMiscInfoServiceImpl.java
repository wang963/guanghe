package com.yh.windnacelle.service.impl;

import java.util.List;

import com.yh.windnacelle.domain.ApiResponse;
import com.yh.windnacelle.domain.SysCamera;
import com.yh.windnacelle.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.mapper.WindMiscInfoMapper;
import com.yh.windnacelle.domain.WindMiscInfo;
import com.yh.windnacelle.service.IWindMiscInfoService;
import org.springframework.web.client.RestTemplate;

/**
 * 外发告警地址配置Service业务层处理
 *
 * @author wyy
 * @date 2024-09-20
 */
@Service
public class WindMiscInfoServiceImpl implements IWindMiscInfoService
{
    @Autowired
    private WindMiscInfoMapper windMiscInfoMapper;

    @Autowired
    private Utils utils;

    /**
     * 查询外发告警地址配置
     *
     * @param id 外发告警地址配置主键
     * @return 外发告警地址配置
     */
    @Override
    public WindMiscInfo selectWindMiscInfoById(Long id)
    {
        return windMiscInfoMapper.selectWindMiscInfoById(id);
    }

    /**
     * 查询外发告警地址配置列表
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 外发告警地址配置
     */
    @Override
    public List<WindMiscInfo> selectWindMiscInfoList(WindMiscInfo windMiscInfo)
    {
        return windMiscInfoMapper.selectWindMiscInfoList(windMiscInfo);
    }

    /**
     * 新增外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    @Override
    public int insertWindMiscInfo(WindMiscInfo windMiscInfo)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 创建请求实体，使用 SysCamera 对象而不是 JSON 字符串
        HttpEntity<WindMiscInfo> requestEntity = new HttpEntity<>(windMiscInfo, headers);

        // 创建 RestTemplate 实例
        RestTemplate restTemplate = new RestTemplate();
        String url = utils.getPrefixAddress() + "/updateMiscInfo"; // 替换为实际 URL
        // 发送 POST 请求
        ApiResponse response = restTemplate.postForObject(url, requestEntity, ApiResponse.class);

        if (response.getCode() != 2000){
            return 0;
        }
        return windMiscInfoMapper.insertWindMiscInfo(windMiscInfo);
    }

    /**
     * 修改外发告警地址配置
     *
     * @param windMiscInfo 外发告警地址配置
     * @return 结果
     */
    @Override
    public int updateWindMiscInfo(WindMiscInfo windMiscInfo)
    {
        return windMiscInfoMapper.updateWindMiscInfo(windMiscInfo);
    }

    /**
     * 批量删除外发告警地址配置
     *
     * @param ids 需要删除的外发告警地址配置主键
     * @return 结果
     */
    @Override
    public int deleteWindMiscInfoByIds(Long[] ids)
    {
        return windMiscInfoMapper.deleteWindMiscInfoByIds(ids);
    }

    /**
     * 删除外发告警地址配置信息
     *
     * @param id 外发告警地址配置主键
     * @return 结果
     */
    @Override
    public int deleteWindMiscInfoById(Long id)
    {
        return windMiscInfoMapper.deleteWindMiscInfoById(id);
    }
}
