package com.yh.windnacelle.controller;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

import com.yh.windnacelle.domain.WindAlerts;
import com.yh.windnacelle.domain.WindAlertsDto;
import com.yh.windnacelle.service.IWindAlertsService;
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
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 告警信息Controller
 *
 * @author wyy
 * @date 2024-09-21
 */
@RestController
@RequestMapping("/fanmonitor/alerts")
public class WindAlertsController extends BaseController
{
    @Autowired
    private IWindAlertsService windAlertsService;

    /**
     * 查询告警信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindAlerts windAlerts)
    {
        startPage();
        List<WindAlerts> list = windAlertsService.selectWindAlertsList(windAlerts);
        return getDataTable(list);
    }

    /**
     * 查询告警信息(包含风机信息)列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:list')")
    @GetMapping("/listDto")
    public TableDataInfo listDto(WindAlertsDto windAlertsDto)
    {
        startPage();
        List<WindAlertsDto> list = windAlertsService.selectWindAlertsDtoList(windAlertsDto);
        return getDataTable(list);
    }

    /**
     * 导出告警信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:export')")
    @Log(title = "告警信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindAlerts windAlerts)
    {
        List<WindAlerts> list = windAlertsService.selectWindAlertsList(windAlerts);
        ExcelUtil<WindAlerts> util = new ExcelUtil<WindAlerts>(WindAlerts.class);
        util.exportExcel(response, list, "告警信息数据");
    }

    /**
     * 获取告警信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windAlertsService.selectWindAlertsById(id));
    }

    /**
     * 新增告警信息
     */
    @PostMapping("/addAlerts")
    @PermitAll // 或者使用自定义注解
    public AjaxResult add(@RequestBody WindAlerts windAlerts)
    {
        return toAjax(windAlertsService.insertWindAlerts(windAlerts));
    }

    /**
     * 修改告警信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:edit')")
    @Log(title = "告警信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindAlerts windAlerts)
    {
        return toAjax(windAlertsService.updateWindAlerts(windAlerts));
    }

    /**
     * 删除告警信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alerts:remove')")
    @Log(title = "告警信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windAlertsService.deleteWindAlertsByIds(ids));
    }
}
