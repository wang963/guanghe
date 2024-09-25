package com.yh.windnacelle.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yh.windnacelle.service.IWindPersonService;
import org.springframework.http.ResponseEntity;
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
import com.yh.windnacelle.domain.WindPerson;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 人员信息Controller
 *
 * @author wyy
 * @date 2024-09-13
 */
@RestController
@RequestMapping("/fanmonitor/person")
public class WindPersonController extends BaseController
{
    @Autowired
    private IWindPersonService windPersonService;

    /**
     * 查询人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindPerson windPerson)
    {
        startPage();
        List<WindPerson> list = windPersonService.selectWindPersonList(windPerson);
        return getDataTable(list);
    }

    /**
     * 导出人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:export')")
    @Log(title = "人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindPerson windPerson)
    {
        List<WindPerson> list = windPersonService.selectWindPersonList(windPerson);
        ExcelUtil<WindPerson> util = new ExcelUtil<WindPerson>(WindPerson.class);
        util.exportExcel(response, list, "人员信息数据");
    }

    /**
     * 获取人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(windPersonService.selectWindPersonById(id));
    }

    /**
     * 新增人员信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:add')")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody WindPerson windPerson)
    {
        String s = "";
        try {
            s = windPersonService.insertWindPerson(windPerson);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        if ("success".equals(s)){
            return ResponseEntity.ok("添加成功");
        }
        return ResponseEntity.status(500).body("添加失败");

    }

    /**
     * 修改人员信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:edit')")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindPerson windPerson)
    {
        return toAjax(windPersonService.updateWindPerson(windPerson));
    }

    /**
     * 删除人员信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:person:remove')")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(windPersonService.deleteWindPersonByIds(ids));
    }
}
