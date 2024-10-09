package com.yh.windnacelle.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import com.yh.windnacelle.domain.WindAlertObjects;
import com.yh.windnacelle.domain.WindAlertsDto;
import com.yh.windnacelle.mapper.WindAlertObjectsMapper;
import com.yh.windnacelle.domain.WindAlerts;
import com.yh.windnacelle.mapper.WindAlertsMapper;
import com.yh.windnacelle.service.IWindAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 告警信息Service业务层处理
 *
 * @author wyy
 * @date 2024-09-21
 */
@Service
public class WindAlertsServiceImpl implements IWindAlertsService
{
    @Autowired
    private WindAlertsMapper windAlertsMapper;

    @Autowired
    private WindAlertObjectsMapper windAlertObjectsMapper;
    @Value("${ruoyi.profile}") // 从配置文件中读取路径
    private String imageDirectory;

    private static final String IMAGE_DIRECTORY = "/image";

    /**
     * 查询告警信息
     *
     * @param id 告警信息主键
     * @return 告警信息
     */
    @Override
    public WindAlerts selectWindAlertsById(Long id)
    {
        return windAlertsMapper.selectWindAlertsById(id);
    }

    /**
     * 查询告警信息列表
     *
     * @param windAlerts 告警信息
     * @return 告警信息
     */
    @Override
    public List<WindAlerts> selectWindAlertsList(WindAlerts windAlerts)
    {
        List<WindAlerts> windAlerts1 = windAlertsMapper.selectWindAlertsList(windAlerts);
        return windAlerts1;
    }

    @Override
    public List<WindAlertsDto> selectWindAlertsDtoList(WindAlertsDto windAlertsDto) {
        return windAlertsMapper.selectWindAlertsDtoList(windAlertsDto);
    }

    /**
     * 新增告警信息
     *
     * @param windAlerts 告警信息
     * @return 结果
     */
    @Override
    public int insertWindAlerts(WindAlerts windAlerts){
        List<String> imgs = windAlerts.getImgs();
        String imagePath = "";
        List<String> imgpaths = new ArrayList<>();
        if (imgs != null && !imgs.isEmpty()) {
            for (String img:imgs){
                imagePath =saveBase64Image(img);
                imgpaths.add(imagePath);
            }
            windAlerts.setImgpath(imgpaths.get(0).toString());
            System.out.println(imgpaths);
        }
        windAlertsMapper.insertWindAlerts(windAlerts);
        if (windAlerts.getObjs()!=null){
            for (List<WindAlertObjects> windAlertObjects:windAlerts.getObjs()){
                for (WindAlertObjects windAlertObjects1:windAlertObjects){
                    windAlertObjects1.setAlertId(windAlerts.getId());
                    windAlertObjects1.setColorDba(windAlertObjects1.getColor().toString());
                    windAlertObjects1.setPositionDba(windAlertObjects1.getPosition().toString());
                    windAlertObjectsMapper.insertWindAlertObjects(windAlertObjects1);
                }
            }
        }
        return 0;
    }

    /**
     * 修改告警信息
     *
     * @param windAlerts 告警信息
     * @return 结果
     */
    @Override
    public int updateWindAlerts(WindAlerts windAlerts)
    {
        return windAlertsMapper.updateWindAlerts(windAlerts);
    }

    /**
     * 批量删除告警信息
     *
     * @param ids 需要删除的告警信息主键
     * @return 结果
     */
    @Override
    public int deleteWindAlertsByIds(Long[] ids)
    {
        return windAlertsMapper.deleteWindAlertsByIds(ids);
    }

    /**
     * 删除告警信息信息
     *
     * @param id 告警信息主键
     * @return 结果
     */
    @Override
    public int deleteWindAlertsById(Long id)
    {
        return windAlertsMapper.deleteWindAlertsById(id);
    }

    private String saveBase64Image(String base64Image){
        // 去掉 Base64 字符串的头部信息
        String[] parts = base64Image.split(",");
        String imageData = parts.length > 1 ? parts[1] : parts[0];

        // 解码 Base64 字符串
        byte[] imageBytes = Base64.getDecoder().decode(imageData);

        // 确保目录存在
        File dir = new File(imageDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // 创建目录
        }

        // 生成唯一的文件名
        String fileName = UUID.randomUUID().toString() + ".png"; // 这里使用 PNG 格式，您可以根据需要更改扩展名
        File imageFile = new File(imageDirectory, fileName);

        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            // 处理异常，例如记录日志或抛出自定义异常
        }

        // 返回图片的相对路径或绝对路径
        return "/profile/"+imageFile.getName(); // 或者返回相对路径，例如 "/images/" + fileName
    }
}
