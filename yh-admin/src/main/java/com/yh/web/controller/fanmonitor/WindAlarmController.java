package com.yh.web.controller.fanmonitor;

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
import com.yh.windnacelle.domain.WindAlarm;
import com.yh.windnacelle.service.IWindAlarmService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 异常告警Controller
 *
 * @author zzs
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/fanmonitor/alarm")
public class WindAlarmController extends BaseController
{
    @Autowired
    private IWindAlarmService windAlarmService;

    /**
     * 查询异常告警列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindAlarm windAlarm)
    {
        startPage();
        List<WindAlarm> list = windAlarmService.selectWindAlarmList(windAlarm);
        return getDataTable(list);
    }

    /**
     * 导出异常告警列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:export')")
    @Log(title = "异常告警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindAlarm windAlarm)
    {
        List<WindAlarm> list = windAlarmService.selectWindAlarmList(windAlarm);
        ExcelUtil<WindAlarm> util = new ExcelUtil<WindAlarm>(WindAlarm.class);
        util.exportExcel(response, list, "异常告警数据");
    }

    /**
     * 获取异常告警详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(windAlarmService.selectWindAlarmById(id));
    }

    /**
     * 新增异常告警
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:add')")
    @Log(title = "异常告警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindAlarm windAlarm)
    {
        return toAjax(windAlarmService.insertWindAlarm(windAlarm));
    }

    /**
     * 修改异常告警
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:edit')")
    @Log(title = "异常告警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindAlarm windAlarm)
    {
        return toAjax(windAlarmService.updateWindAlarm(windAlarm));
    }

    /**
     * 删除异常告警
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:alarm:remove')")
    @Log(title = "异常告警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(windAlarmService.deleteWindAlarmByIds(ids));
    }
}
