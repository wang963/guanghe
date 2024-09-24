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
import com.yh.windnacelle.domain.WindLine;
import com.yh.windnacelle.service.IWindLineService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 风机线路Controller
 *
 * @author zzs
 * @date 2024-07-02
 */
@RestController
@RequestMapping("/windnacelle/line")
public class WindLineController extends BaseController
{
    @Autowired
    private IWindLineService windLineService;

    /**
     * 查询风机线路列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindLine windLine)
    {
        startPage();
        List<WindLine> list = windLineService.selectWindLineList(windLine);
        return getDataTable(list);
    }

    /**
     * 导出风机线路列表
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:export')")
    @Log(title = "风机线路", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindLine windLine)
    {
        List<WindLine> list = windLineService.selectWindLineList(windLine);
        ExcelUtil<WindLine> util = new ExcelUtil<WindLine>(WindLine.class);
        util.exportExcel(response, list, "风机线路数据");
    }

    /**
     * 获取风机线路详细信息
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Integer lineId)
    {
        return success(windLineService.selectWindLineByLineId(lineId));
    }

    /**
     * 新增风机线路
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:add')")
    @Log(title = "风机线路", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WindLine windLine)
    {
        return toAjax(windLineService.insertWindLine(windLine));
    }

    /**
     * 修改风机线路
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:edit')")
    @Log(title = "风机线路", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindLine windLine)
    {
        return toAjax(windLineService.updateWindLine(windLine));
    }

    /**
     * 删除风机线路
     */
    @PreAuthorize("@ss.hasPermi('windnacelle:line:remove')")
    @Log(title = "风机线路", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Integer[] lineIds)
    {
        return toAjax(windLineService.deleteWindLineByLineIds(lineIds));
    }
}
