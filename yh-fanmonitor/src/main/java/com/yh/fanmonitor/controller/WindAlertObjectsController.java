package com.yh.fanmonitor.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.yh.fanmonitor.domain.WindAlertObjects;
import com.yh.fanmonitor.service.IWindAlertObjectsService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 告警详细信息Controller
 *
 * @author wyy
 * @date 2024-09-24
 */
@RestController
@RequestMapping("/fanmonitor/alertObjects")
public class WindAlertObjectsController extends BaseController
{
    @Autowired
    private IWindAlertObjectsService windAlertObjectsService;

    /**
     * 查询告警详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindAlertObjects windAlertObjects)
    {
        startPage();
        List<WindAlertObjects> list = windAlertObjectsService.selectWindAlertObjectsList(windAlertObjects);
        return getDataTable(list);
    }

    /**
     * 导出告警详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:export')")
    @Log(title = "告警详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindAlertObjects windAlertObjects)
    {
        List<WindAlertObjects> list = windAlertObjectsService.selectWindAlertObjectsList(windAlertObjects);
        ExcelUtil<WindAlertObjects> util = new ExcelUtil<WindAlertObjects>(WindAlertObjects.class);
        util.exportExcel(response, list, "告警详细信息数据");
    }

    /**
     * 获取告警详细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windAlertObjectsService.selectWindAlertObjectsById(id));
    }

    /**
     * 新增告警详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:add')")
    @Log(title = "告警详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindAlertObjects windAlertObjects)
    {
        return toAjax(windAlertObjectsService.insertWindAlertObjects(windAlertObjects));
    }

    /**
     * 修改告警详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:edit')")
    @Log(title = "告警详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindAlertObjects windAlertObjects)
    {
        return toAjax(windAlertObjectsService.updateWindAlertObjects(windAlertObjects));
    }

    /**
     * 删除告警详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:objects:remove')")
    @Log(title = "告警详细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windAlertObjectsService.deleteWindAlertObjectsByIds(ids));
    }
}
