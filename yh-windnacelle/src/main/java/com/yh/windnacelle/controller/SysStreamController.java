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
import com.yh.windnacelle.domain.SysStream;
import com.yh.windnacelle.service.ISysStreamService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 拉流配置Controller
 *
 * @author zzs
 * @date 2024-09-11
 */
@RestController
@RequestMapping("/fanmonitor/stream")
public class SysStreamController extends BaseController
{
    @Autowired
    private ISysStreamService sysStreamService;

    /**
     * 查询拉流配置列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysStream sysStream)
    {
        startPage();
        List<SysStream> list = sysStreamService.selectSysStreamList(sysStream);
        return getDataTable(list);
    }

    /**
     * 导出拉流配置列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:export')")
    @Log(title = "拉流配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysStream sysStream)
    {
        List<SysStream> list = sysStreamService.selectSysStreamList(sysStream);
        ExcelUtil<SysStream> util = new ExcelUtil<SysStream>(SysStream.class);
        util.exportExcel(response, list, "拉流配置数据");
    }

    /**
     * 获取拉流配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysStreamService.selectSysStreamById(id));
    }

    /**
     * 新增拉流配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:add')")
    @Log(title = "拉流配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysStream sysStream)
    {
        return toAjax(sysStreamService.insertSysStream(sysStream));
    }

    /**
     * 修改拉流配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:edit')")
    @Log(title = "拉流配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysStream sysStream)
    {
        return toAjax(sysStreamService.updateSysStream(sysStream));
    }

    /**
     * 删除拉流配置
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:stream:remove')")
    @Log(title = "拉流配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysStreamService.deleteSysStreamByIds(ids));
    }
}
