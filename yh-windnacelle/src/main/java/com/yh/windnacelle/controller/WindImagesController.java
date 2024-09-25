package com.yh.windnacelle.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yh.windnacelle.domain.WindImages;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yh.common.annotation.Log;
import com.yh.common.core.controller.BaseController;
import com.yh.common.core.domain.AjaxResult;
import com.yh.common.enums.BusinessType;
import com.yh.windnacelle.service.IWindImagesService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 图片识别Controller
 *
 * @author wyy
 * @date 2024-09-14
 */
@RestController
@RequestMapping("/fanmonitor/images")
public class WindImagesController extends BaseController
{
    @Autowired
    private IWindImagesService windImagesService;

    /**
     * 查询图片识别列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindImages windImages)
    {
        startPage();
        List<WindImages> list = windImagesService.selectWindImagesList(windImages);
        return getDataTable(list);
    }

    /**
     * 导出图片识别列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:export')")
    @Log(title = "图片识别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindImages windImages)
    {
        List<WindImages> list = windImagesService.selectWindImagesList(windImages);
        ExcelUtil<WindImages> util = new ExcelUtil<WindImages>(WindImages.class);
        util.exportExcel(response, list, "图片识别数据");
    }

    /**
     * 获取图片识别详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windImagesService.selectWindImagesById(id));
    }

    /**
     * 新增图片识别
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:add')")
    @Log(title = "图片识别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindImages windImages)
    {
        AjaxResult ajaxResult = null;
        try {
            ajaxResult = toAjax(windImagesService.insertWindImages(windImages));
        }catch (Exception e){
            return ajaxResult;
        }
        return ajaxResult;
    }

    /**
     * 修改图片识别
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:edit')")
    @Log(title = "图片识别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindImages windImages)
    {
        return toAjax(windImagesService.updateWindImages(windImages));
    }

    /**
     * 删除图片识别
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:remove')")
    @Log(title = "图片识别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windImagesService.deleteWindImagesByIds(ids));
    }

    /**
     * 调用图片检测接口
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:images:detection')")
    @PostMapping("/detection")
    public AjaxResult detection(@RequestBody Long[] ids){
        List<WindImages> windImages = windImagesService.getWindImagesByIds(ids);
        return toAjax(windImagesService.detection(windImages));
    }
}
