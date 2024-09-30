package com.yh.windnacelle.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yh.windnacelle.demo.WindVideoDto;
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
import com.yh.windnacelle.domain.WindVideoobj;
import com.yh.windnacelle.service.IWindVideoobjService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 视频检测Controller
 *
 * @author wyy
 * @date 2024-09-27
 */
@RestController
@RequestMapping("/windnacelle/videoobj")
public class WindVideoobjController extends BaseController
{
    @Autowired
    private IWindVideoobjService windVideoobjService;

    /**
     * 查询视频检测列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindVideoobj windVideoobj)
    {
        startPage();
        List<WindVideoobj> list = windVideoobjService.selectWindVideoobjList(windVideoobj);
        return getDataTable(list);
    }

    /**
     * 导出视频检测列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:export')")
    @Log(title = "视频检测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindVideoobj windVideoobj)
    {
        List<WindVideoobj> list = windVideoobjService.selectWindVideoobjList(windVideoobj);
        ExcelUtil<WindVideoobj> util = new ExcelUtil<WindVideoobj>(WindVideoobj.class);
        util.exportExcel(response, list, "视频检测数据");
    }

    /**
     * 获取视频检测详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windVideoobjService.selectWindVideoobjById(id));
    }

    /**
     * 新增视频检测
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:add')")
    @Log(title = "视频检测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindVideoobj windVideoobj)
    {
        return toAjax(windVideoobjService.insertWindVideoobj(windVideoobj));
    }

    /**
     * 修改视频检测
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:edit')")
    @Log(title = "视频检测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindVideoobj windVideoobj)
    {
        return toAjax(windVideoobjService.updateWindVideoobj(windVideoobj));
    }

    /**
     * 删除视频检测
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:videoobj:remove')")
    @Log(title = "视频检测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windVideoobjService.deleteWindVideoobjByIds(ids));
    }

    /**
     * 视频检测
     */
    @PostMapping("/videoDetection")
    public AjaxResult videoDetection(@RequestBody WindVideoDto windVideoDto){

        return toAjax(1);
    }
}
