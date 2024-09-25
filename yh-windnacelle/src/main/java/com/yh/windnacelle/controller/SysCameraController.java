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
import com.yh.windnacelle.domain.SysCamera;
import com.yh.windnacelle.service.ISysCameraService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 摄像机配置信息Controller
 *
 * @author wyy
 * @date 2024-09-12
 */
@RestController
@RequestMapping("/fanmonitor/camera")
public class SysCameraController extends BaseController
{
    @Autowired
    private ISysCameraService sysCameraService;

    /**
     * 查询摄像机配置信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCamera sysCamera)
    {
        startPage();
        List<SysCamera> list = sysCameraService.selectSysCameraList(sysCamera);
        return getDataTable(list);
    }

    /**
     * 导出摄像机配置信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:export')")
    @Log(title = "摄像机配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCamera sysCamera)
    {
        List<SysCamera> list = sysCameraService.selectSysCameraList(sysCamera);
        ExcelUtil<SysCamera> util = new ExcelUtil<SysCamera>(SysCamera.class);
        util.exportExcel(response, list, "摄像机配置信息数据");
    }

    /**
     * 获取摄像机配置信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sysCameraService.selectSysCameraById(id));
    }

    /**
     * 新增摄像机配置信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:add')")
    @Log(title = "摄像机配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCamera sysCamera)
    {
        return toAjax(sysCameraService.insertSysCamera(sysCamera));
    }

    /**
     * 修改摄像机配置信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:edit')")
    @Log(title = "摄像机配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCamera sysCamera)
    {
        return toAjax(sysCameraService.updateSysCamera(sysCamera));
    }

    /**
     * 删除摄像机配置信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:remove')")
    @Log(title = "摄像机配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysCameraService.deleteSysCameraByIds(ids));
    }

    /**
     * 删除摄像机配置信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:remove')")
    @PostMapping("/deleteStream")
    public AjaxResult removeDetection(@RequestBody String id)
    {
        return toAjax(sysCameraService.deleteSysCameraById(id));
    }

    /**
     * 新增算法配置信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:camera:edit')")
    @Log(title = "摄像机配置信息", businessType = BusinessType.UPDATE)
    @PostMapping("/addAlgorithm")
    public AjaxResult addAlgorithm(@RequestBody SysCamera sysCamera)
    {
        return toAjax(sysCameraService.addAlgorithm(sysCamera));
    }
}
