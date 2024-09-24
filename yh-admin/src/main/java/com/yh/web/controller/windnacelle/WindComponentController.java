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
import com.yh.windnacelle.domain.WindComponent;
import com.yh.windnacelle.service.IWindComponentService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 风机部件Controller
 *
 * @author zzs
 * @date 2024-07-15
 */
@RestController
@RequestMapping("/windnacelle/component")
public class WindComponentController extends BaseController
{
    @Autowired
    private IWindComponentService windComponentService;

    /**
     * 查询风机部件列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindComponent windComponent)
    {
        startPage();
        List<WindComponent> list = windComponentService.selectWindComponentList(windComponent);
        return getDataTable(list);
    }

    /**
     * 导出风机部件列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:export')")
    @Log(title = "风机部件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindComponent windComponent)
    {
        List<WindComponent> list = windComponentService.selectWindComponentList(windComponent);
        ExcelUtil<WindComponent> util = new ExcelUtil<WindComponent>(WindComponent.class);
        util.exportExcel(response, list, "风机部件数据");
    }

    /**
     * 获取风机部件详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:query')")
    @GetMapping(value = "/{componentId}")
    public AjaxResult getInfo(@PathVariable("componentId") Integer componentId)
    {
        return success(windComponentService.selectWindComponentByComponentId(componentId));
    }

    /**
     * 新增风机部件
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:add')")
    @Log(title = "风机部件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindComponent windComponent)
    {
        return toAjax(windComponentService.insertWindComponent(windComponent));
    }

    /**
     * 修改风机部件
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:edit')")
    @Log(title = "风机部件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindComponent windComponent)
    {
        return toAjax(windComponentService.updateWindComponent(windComponent));
    }

    /**
     * 删除风机部件
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:component:remove')")
    @Log(title = "风机部件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{componentIds}")
    public AjaxResult remove(@PathVariable Integer[] componentIds)
    {
        return toAjax(windComponentService.deleteWindComponentByComponentIds(componentIds));
    }
}
