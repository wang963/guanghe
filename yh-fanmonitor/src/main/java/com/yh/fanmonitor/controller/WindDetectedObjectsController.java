package com.yh.fanmonitor.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yh.fanmonitor.domain.WindImages;
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
import com.yh.fanmonitor.domain.WindDetectedObjects;
import com.yh.fanmonitor.service.IWindDetectedObjectsService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 图片检测返回结果Controller
 *
 * @author wyy
 * @date 2024-09-14
 */
@RestController
@RequestMapping("/fanmonitor/objects")
public class WindDetectedObjectsController extends BaseController
{
    @Autowired
    private IWindDetectedObjectsService windDetectedObjectsService;

    /**
     * 查询图片检测返回结果列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindDetectedObjects windDetectedObjects)
    {
        startPage();
        List<WindDetectedObjects> list = windDetectedObjectsService.selectWindDetectedObjectsList(windDetectedObjects);
        return getDataTable(list);
    }

    /**
     * 导出图片检测返回结果列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:export')")
    @Log(title = "图片检测返回结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindDetectedObjects windDetectedObjects)
    {
        List<WindDetectedObjects> list = windDetectedObjectsService.selectWindDetectedObjectsList(windDetectedObjects);
        ExcelUtil<WindDetectedObjects> util = new ExcelUtil<WindDetectedObjects>(WindDetectedObjects.class);
        util.exportExcel(response, list, "图片检测返回结果数据");
    }

    /**
     * 获取图片检测返回结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windDetectedObjectsService.selectWindDetectedObjectsById(id));
    }

    /**
     * 新增图片检测返回结果
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:add')")
    @Log(title = "图片检测返回结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindDetectedObjects windDetectedObjects)
    {
        return toAjax(windDetectedObjectsService.insertWindDetectedObjects(windDetectedObjects));
    }

    /**
     * 修改图片检测返回结果
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:edit')")
    @Log(title = "图片检测返回结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindDetectedObjects windDetectedObjects)
    {
        return toAjax(windDetectedObjectsService.updateWindDetectedObjects(windDetectedObjects));
    }

    /**
     * 删除图片检测返回结果
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:remove')")
    @Log(title = "图片检测返回结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windDetectedObjectsService.deleteWindDetectedObjectsByIds(ids));
    }
}
