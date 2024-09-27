package com.yh.windnacelle.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yh.windnacelle.domain.DetectionResponse;
import com.yh.windnacelle.domain.WindDetectedObjects;
import com.yh.windnacelle.mapper.WindDetectedObjectsMapper;
import com.yh.windnacelle.domain.WindImages;
import com.yh.windnacelle.mapper.WindImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yh.windnacelle.service.IWindImagesService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


/**
 * 图片识别Service业务层处理
 *
 * @author wyy
 * @date 2024-09-14
 */
@Service
public class WindImagesServiceImpl implements IWindImagesService
{
    @Autowired
    private WindImagesMapper windImagesMapper;

    @Autowired
    private WindDetectedObjectsMapper windDetectedObjectsMapper;

    /**
     * 查询图片识别
     *
     * @param id 图片识别主键
     * @return 图片识别
     */
    @Override
    public WindImages selectWindImagesById(Long id)
    {
        return windImagesMapper.selectWindImagesById(id);
    }

    /**
     * 查询图片识别列表
     *
     * @param windImages 图片识别
     * @return 图片识别
     */
    @Override
    public List<WindImages> selectWindImagesList(WindImages windImages)
    {
        return windImagesMapper.selectWindImagesList(windImages);
    }

    /**
     * 新增图片识别
     *
     * @param windImages 图片识别
     * @return 结果
     */
    @Override
    @Transactional
    public int insertWindImages(WindImages windImages)
    {
        return windImagesMapper.insertWindImages(windImages);
    }

    /**
     * 修改图片识别
     *
     * @param windImages 图片识别
     * @return 结果
     */
    @Override
    public int updateWindImages(WindImages windImages)
    {
        return windImagesMapper.updateWindImages(windImages);
    }

    /**
     * 批量删除图片识别
     *
     * @param ids 需要删除的图片识别主键
     * @return 结果
     */
    @Override
    public int deleteWindImagesByIds(Long[] ids)
    {
        return windImagesMapper.deleteWindImagesByIds(ids);
    }

    /**
     * 删除图片识别信息
     *
     * @param id 图片识别主键
     * @return 结果
     */
    @Override
    public int deleteWindImagesById(Long id)
    {
        return windImagesMapper.deleteWindImagesById(id);
    }

    /**
     * 检测图片信息
     *
     * @param windImages 图片信息
     * @param enhance_Type 增强类型
     * @return 结果
     */
    @Override
    @Transactional
    public int detection(List<WindImages> windImagesList, String enhance_Type) {
        String url = "http://47.94.239.117:80/imgObjDetection/" + enhance_Type + "/Bboxs";
        RestTemplate restTemplate = new RestTemplate();
        // 发送请求并获取响应
        DetectionResponse detectionResponse;
        try {
            //detectionResponse = restTemplate.postForObject(url, windImagesList, DetectionResponse.class);
            detectionResponse = parseDetectionResponse();
        } catch (Exception e) {
            e.printStackTrace();
            // 记录错误日志
            return -1; // 或者其他适当的错误代码
        }
        if (detectionResponse == null || detectionResponse.getWindImagesList() == null) {
            return -1; // 或者其他适当的错误代码
        }
        List<WindDetectedObjects> detectedObjectsList = new ArrayList<>();
        List<Long> imageIds = new ArrayList<>();
        // 遍历响应并准备插入数据
        for (WindImages images : detectionResponse.getWindImagesList()) {
            Long imageId = windImagesMapper.getWindImagesIdByName(images.getImageName());
            imageIds.add(imageId);

            for (WindDetectedObjects windDetectedObjects : images.getWindDetectedObjectsList()) {
                windDetectedObjects.setImageId(imageId);
                detectedObjectsList.add(windDetectedObjects);
            }
        }
        // 批量插入检测到的对象
        if (!detectedObjectsList.isEmpty()) {
            windImagesMapper.deleteWindDetectedObjectsByIds(imageIds);
            return windDetectedObjectsMapper.insertWindDetectedObjectsBatch(detectedObjectsList);
        }
        return -1;
    }

    @Override
    public List<WindImages> getWindImagesByIds(Long[] ids) {
        return windImagesMapper.getWindImagesByIds(ids);
    }

    /*
    * 产生临时测试用的假数据，以后删除
    */
    private DetectionResponse parseDetectionResponse() {
        DetectionResponse response = new DetectionResponse();
        List<WindImages> windImagesList = new ArrayList<>();
        WindImages windImages = new WindImages();

        windImages.setImageName("机组内部1");
        windImages.setWindDetectedObjectsList(parseWindDetectedObjectsList());

        windImagesList.add(windImages);
        response.setWindImagesList(windImagesList);
        return response;
    }

    private List<WindDetectedObjects> parseWindDetectedObjectsList() {
        List<WindDetectedObjects> windDetectedObjectsList = new ArrayList<>();

        WindDetectedObjects objects = new WindDetectedObjects();
        objects.setName("Generator");
        objects.setConfidence(0.432516);
        objects.setXmin(150L);
        objects.setXmax(200L);
        objects.setYmin(144L);
        objects.setYmax(256L);
        objects.setClazz(2315L);
        windDetectedObjectsList.add(objects);

        return windDetectedObjectsList;
    }

}
