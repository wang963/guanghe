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
import com.yh.windnacelle.domain.WindFan;
import com.yh.windnacelle.service.IWindFanService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 风机维护Controller
 *
 * @author zzs
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/windnacelle/fan")
public class WindFanController extends BaseController
{
    @Autowired
    private IWindFanService windFanService;

    /**
     * 查询风机维护列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindFan windFan)
    {
        startPage();
        List<WindFan> list = windFanService.selectWindFanList(windFan);
        return getDataTable(list);
    }

    /**
     * 导出风机维护列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:export')")
    @Log(title = "风机维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindFan windFan)
    {
        List<WindFan> list = windFanService.selectWindFanList(windFan);
        ExcelUtil<WindFan> util = new ExcelUtil<WindFan>(WindFan.class);
        util.exportExcel(response, list, "风机维护数据");
    }

    /**
     * 获取风机维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:query')")
    @GetMapping(value = "/{fanId}")
    public AjaxResult getInfo(@PathVariable("fanId") Integer fanId)
    {
        return success(windFanService.selectWindFanByFanId(fanId));
    }

    /**
     * 新增风机维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:add')")
    @Log(title = "风机维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindFan windFan)
    {
        return toAjax(windFanService.insertWindFan(windFan));
    }

    /**
     * 修改风机维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:edit')")
    @Log(title = "风机维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindFan windFan)
    {
        return toAjax(windFanService.updateWindFan(windFan));
    }

    /**
     * 删除风机维护
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:fan:remove')")
    @Log(title = "风机维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fanIds}")
    public AjaxResult remove(@PathVariable Integer[] fanIds)
    {
        return toAjax(windFanService.deleteWindFanByFanIds(fanIds));
    }
}
