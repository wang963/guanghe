package com.yh.windnacelle.controller;

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
import com.yh.windnacelle.domain.WindMiscInfo;
import com.yh.windnacelle.service.IWindMiscInfoService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 外发告警地址配置Controller
 *
 * @author wyy
 * @date 2024-09-20
 */
@RestController
@RequestMapping("/fanmonitor/info")
public class WindMiscInfoController extends BaseController
{
    @Autowired
    private IWindMiscInfoService windMiscInfoService;

    /**
     * 查询外发告警地址配置列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindMiscInfo windMiscInfo)
    {
        startPage();
        List<WindMiscInfo> list = windMiscInfoService.selectWindMiscInfoList(windMiscInfo);
        return getDataTable(list);
    }

    /**
     * 导出外发告警地址配置列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:export')")
    @Log(title = "外发告警地址配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindMiscInfo windMiscInfo)
    {
        List<WindMiscInfo> list = windMiscInfoService.selectWindMiscInfoList(windMiscInfo);
        ExcelUtil<WindMiscInfo> util = new ExcelUtil<WindMiscInfo>(WindMiscInfo.class);
        util.exportExcel(response, list, "外发告警地址配置数据");
    }

    /**
     * 获取外发告警地址配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windMiscInfoService.selectWindMiscInfoById(id));
    }

    /**
     * 新增外发告警地址配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:add')")
    @Log(title = "外发告警地址配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindMiscInfo windMiscInfo)
    {
        return toAjax(windMiscInfoService.insertWindMiscInfo(windMiscInfo));
    }

    /**
     * 修改外发告警地址配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:edit')")
    @Log(title = "外发告警地址配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindMiscInfo windMiscInfo)
    {
        return toAjax(windMiscInfoService.updateWindMiscInfo(windMiscInfo));
    }

    /**
     * 删除外发告警地址配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:info:remove')")
    @Log(title = "外发告警地址配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windMiscInfoService.deleteWindMiscInfoByIds(ids));
    }
}
