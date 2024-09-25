package com.yh.fanmonitor.service.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yh.fanmonitor.demo.StreamInfo;
import com.yh.fanmonitor.domain.ApiResponse;
import com.yh.fanmonitor.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.yh.fanmonitor.mapper.SysCameraMapper;
import com.yh.fanmonitor.domain.SysCamera;
import com.yh.fanmonitor.service.ISysCameraService;
import org.springframework.web.client.RestTemplate;

/**
 * 摄像机配置信息Service业务层处理
 *
 * @author wyy
 * @date 2024-09-12
 */
@Service
public class SysCameraServiceImpl implements ISysCameraService {
    @Autowired
    private SysCameraMapper sysCameraMapper;

    /**
     * 查询摄像机配置信息
     *
     * @param id 摄像机配置信息主键
     * @return 摄像机配置信息
     */
    @Override
    public SysCamera selectSysCameraById(String id) {
        return sysCameraMapper.selectSysCameraById(id);
    }

    /**
     * 查询摄像机配置信息列表
     *
     * @param sysCamera 摄像机配置信息
     * @return 摄像机配置信息
     */
    @Override
    public List<SysCamera> selectSysCameraList(SysCamera sysCamera) {
        return sysCameraMapper.selectSysCameraList(sysCamera);
    }

    /**
     * 新增摄像机配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    @Override
    public int insertSysCamera(SysCamera sysCamera){

        // 创建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 创建请求实体，使用 SysCamera 对象而不是 JSON 字符串
        HttpEntity<SysCamera> requestEntity = new HttpEntity<>(sysCamera, headers);

        // 创建 RestTemplate 实例
        RestTemplate restTemplate = new RestTemplate();
        String url = Utils.getPrefixAddress() + "/submitAddStream"; // 替换为实际 URL

        // 发送 POST 请求
        ApiResponse response = restTemplate.postForObject(url, requestEntity, ApiResponse.class);

        // 检查响应并处理
        if (response != null && response.getCode() == 20000) {
            sysCamera.setStatus(1);
            sysCamera.setCameraId(response.getCameraId());
            sysCamera.setCode(response.getCode());
            sysCamera.setAddStreamMsg(response.getAddStreamMsg());
            sysCamera.setMsg(response.getMsg());
            System.out.println(response.getCameraId());
            return sysCameraMapper.insertSysCamera(sysCamera);
        }
        return 0;
    }


    /**
     * 新增算法配置信息
     */
    @Override
    public int addAlgorithm(SysCamera sysCamera) {
        String url = Utils.getPrefixAddress() + "/addAlgorithmProperty";
        RestTemplate restTemplate = new RestTemplate();
        ApiResponse response = restTemplate.postForObject(url, sysCamera, ApiResponse.class);
        if (response.getCode() == 20000) {
            sysCamera.setStatus(2);
            return sysCameraMapper.updateSysCamera(sysCamera);
        }
        return 0;
    }


    /**
     * 修改摄像机配置信息
     *
     * @param sysCamera 摄像机配置信息
     * @return 结果
     */
    @Override
    public int updateSysCamera(SysCamera sysCamera) {
        return sysCameraMapper.updateSysCamera(sysCamera);
    }

    /**
     * 批量删除摄像机配置信息
     *
     * @param ids 需要删除的摄像机配置信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCameraByIds(String[] ids) {
        return sysCameraMapper.deleteSysCameraByIds(ids);
    }

    /**
     * 删除摄像机配置信息信息
     *
     * @param id 摄像机配置信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCameraById(String id) {
        String url = Utils.getPrefixAddress() + "/submitDeleteStream";
        RestTemplate restTemplate = new RestTemplate();
        SysCamera sysCamera = sysCameraMapper.selectSysCameraById(id);
        ApiResponse response = restTemplate.postForObject(url, sysCamera, ApiResponse.class);
        if (response.getCode() == 20000) {
            sysCamera.setStatus(3);
            int i = sysCameraMapper.updateSysCamera(sysCamera);
            return i;
        }
        return 0;
    }


}
