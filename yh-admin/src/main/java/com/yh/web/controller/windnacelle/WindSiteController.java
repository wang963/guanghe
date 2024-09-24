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
import com.yh.windnacelle.domain.WindSite;
import com.yh.windnacelle.service.IWindSiteService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 电站信息Controller
 *
 * @author zzs
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/windnacelle/site")
public class WindSiteController extends BaseController
{
    @Autowired
    private IWindSiteService windSiteService;

    /**
     * 查询电站信息列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindSite windSite)
    {
        startPage();
        List<WindSite> list = windSiteService.selectWindSiteList(windSite);
        return getDataTable(list);
    }

    /**
     * 导出电站信息列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:export')")
    @Log(title = "电站信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindSite windSite)
    {
        List<WindSite> list = windSiteService.selectWindSiteList(windSite);
        ExcelUtil<WindSite> util = new ExcelUtil<WindSite>(WindSite.class);
        util.exportExcel(response, list, "电站信息数据");
    }

    /**
     * 获取电站信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:query')")
    @GetMapping(value = "/{siteId}")
    public AjaxResult getInfo(@PathVariable("siteId") Integer siteId)
    {
        return success(windSiteService.selectWindSiteBySiteId(siteId));
    }

    /**
     * 新增电站信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:add')")
    @Log(title = "电站信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindSite windSite)
    {
        return toAjax(windSiteService.insertWindSite(windSite));
    }

    /**
     * 修改电站信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:edit')")
    @Log(title = "电站信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindSite windSite)
    {
        return toAjax(windSiteService.updateWindSite(windSite));
    }

    /**
     * 删除电站信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:site:remove')")
    @Log(title = "电站信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{siteIds}")
    public AjaxResult remove(@PathVariable Integer[] siteIds)
    {
        return toAjax(windSiteService.deleteWindSiteBySiteIds(siteIds));
    }
}
