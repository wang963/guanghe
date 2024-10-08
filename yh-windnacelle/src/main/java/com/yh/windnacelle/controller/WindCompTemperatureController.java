package com.yh.windnacelle.controller;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.yh.windnacelle.domain.CompTemperatureDto;
import com.yh.windnacelle.domain.WindCompTemperature;
import com.yh.windnacelle.service.IWindCompTemperatureService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yh.common.annotation.Log;
import com.yh.common.core.controller.BaseController;
import com.yh.common.core.domain.AjaxResult;
import com.yh.common.enums.BusinessType;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 风机部件温度Controller
 *
 * @author zzs
 * @date 2024-09-30
 */
@RestController
@RequestMapping("/fanmonitor/temperature")
public class WindCompTemperatureController extends BaseController
{
    @Autowired
    private IWindCompTemperatureService windCompTemperatureService;

    /**
     * 查询风机部件温度列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindCompTemperature windCompTemperature)
    {
        startPage();
        List<WindCompTemperature> list = windCompTemperatureService.selectWindCompTemperatureList(windCompTemperature);
        return getDataTable(list);
    }

    /**
     * 导出风机部件温度列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:export')")
    @Log(title = "风机部件温度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindCompTemperature windCompTemperature)
    {
        List<WindCompTemperature> list = windCompTemperatureService.selectWindCompTemperatureList(windCompTemperature);
        ExcelUtil<WindCompTemperature> util = new ExcelUtil<WindCompTemperature>(WindCompTemperature.class);
        util.exportExcel(response, list, "风机部件温度数据");
    }

    /**
     * 获取风机部件温度详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windCompTemperatureService.selectWindCompTemperatureById(id));
    }

    /**
     * 新增风机部件温度
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:add')")
    @Log(title = "风机部件温度", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindCompTemperature windCompTemperature)
    {
        return toAjax(windCompTemperatureService.insertWindCompTemperature(windCompTemperature));
    }

    /**
     * 修改风机部件温度
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:edit')")
    @Log(title = "风机部件温度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindCompTemperature windCompTemperature)
    {
        return toAjax(windCompTemperatureService.updateWindCompTemperature(windCompTemperature));
    }

    /**
     * 删除风机部件温度
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:remove')")
    @Log(title = "风机部件温度", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windCompTemperatureService.deleteWindCompTemperatureByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('fanmonitor:temperature:list')")
    @GetMapping("/listCompTemperature")
    @ResponseBody
    public Map<String, Object> getCompTemperature()
    {
        Map<String, Object> resultMap = new HashMap<>();

        List<WindCompTemperature> windCompTemperatures = windCompTemperatureService.
                selectWindCompTemperatureList(new WindCompTemperature());
        for (WindCompTemperature windCompTemperature : windCompTemperatures) {
            CompTemperatureDto dto = new CompTemperatureDto();

            dto.setName(windCompTemperature.getCompName());
            dto.setValue(windCompTemperature.getTemperature());
            Date time = windCompTemperature.getTime();
            dto.setTime(time.getHours() + ":" + time.getMinutes());
            dto.setAlarm(windCompTemperature.getAlarm());
            dto.setUnit(windCompTemperature.getUnit());

            resultMap.put(windCompTemperature.getCompName(), dto);
        }

        return resultMap;
    }
}
