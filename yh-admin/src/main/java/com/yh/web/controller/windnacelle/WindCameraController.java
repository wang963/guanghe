package com.yh.web.controller.windnacelle;

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
import com.yh.windnacelle.domain.WindCamera;
import com.yh.windnacelle.service.IWindCameraService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 视频维护Controller
 *
 * @author zzs
 * @date 2024-07-03
 */
@RestController
@RequestMapping("/windnacelle/camera")
public class WindCameraController extends BaseController
{
    @Autowired
    private IWindCameraService windCameraService;

    /**
     * 查询视频维护列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindCamera windCamera)
    {
        startPage();
        List<WindCamera> list = windCameraService.selectWindCameraList(windCamera);
        return getDataTable(list);
    }

    /**
     * 导出视频维护列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:export')")
    @Log(title = "视频维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindCamera windCamera)
    {
        List<WindCamera> list = windCameraService.selectWindCameraList(windCamera);
        ExcelUtil<WindCamera> util = new ExcelUtil<WindCamera>(WindCamera.class);
        util.exportExcel(response, list, "视频维护数据");
    }

    /**
     * 获取视频维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:query')")
    @GetMapping(value = "/{cameraId}")
    public AjaxResult getInfo(@PathVariable("cameraId") Integer cameraId)
    {
        return success(windCameraService.selectWindCameraByCameraId(cameraId));
    }

    /**
     * 新增视频维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:add')")
    @Log(title = "视频维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindCamera windCamera)
    {
        return toAjax(windCameraService.insertWindCamera(windCamera));
    }

    /**
     * 修改视频维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:edit')")
    @Log(title = "视频维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindCamera windCamera)
    {
        return toAjax(windCameraService.updateWindCamera(windCamera));
    }

    /**
     * 删除视频维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:camera:remove')")
    @Log(title = "视频维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cameraIds}")
    public AjaxResult remove(@PathVariable Integer[] cameraIds)
    {
        return toAjax(windCameraService.deleteWindCameraByCameraIds(cameraIds));
    }
}
