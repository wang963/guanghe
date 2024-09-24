package com.yh.fanmonitor.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.yh.fanmonitor.domain.WindPersonGroup;
import com.yh.fanmonitor.service.IWindPersonGroupService;
import com.yh.common.utils.poi.ExcelUtil;
import com.yh.common.core.page.TableDataInfo;

/**
 * 人员分组管理Controller
 *
 * @author wyy
 * @date 2024-09-13
 */
@RestController
@RequestMapping("/fanmonitor/group")
public class WindPersonGroupController extends BaseController {
    @Autowired
    private IWindPersonGroupService windPersonGroupService;

    /**
     * 查询人员分组管理列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(WindPersonGroup windPersonGroup) {
        startPage();
        List<WindPersonGroup> list = windPersonGroupService.selectWindPersonGroupList(windPersonGroup);
        return getDataTable(list);
    }

    /**
     * 导出人员分组管理列表
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:export')")
    @Log(title = "人员分组管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WindPersonGroup windPersonGroup) {
        List<WindPersonGroup> list = windPersonGroupService.selectWindPersonGroupList(windPersonGroup);
        ExcelUtil<WindPersonGroup> util = new ExcelUtil<WindPersonGroup>(WindPersonGroup.class);
        util.exportExcel(response, list, "人员分组管理数据");
    }

    /**
     * 获取人员分组管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(windPersonGroupService.selectWindPersonGroupById(id));
    }

    /**
     * 新增人员分组管理
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:add')")
    @Log(title = "人员分组管理", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody WindPersonGroup windPersonGroup) {
        String s = "";
        try {
            s = windPersonGroupService.insertWindPersonGroup(windPersonGroup);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        if ("success".equals(s)){
            return ResponseEntity.ok("添加成功");
        }
        return ResponseEntity.status(500).body("添加失败");
    }

    /**
     * 修改人员分组管理
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:edit')")
    @Log(title = "人员分组管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WindPersonGroup windPersonGroup) {
        return toAjax(windPersonGroupService.updateWindPersonGroup(windPersonGroup));
    }

    /**
     * 删除人员分组管理
     */
    @PreAuthorize("@ss.hasPermi('fanmonitor:group:remove')")
    @Log(title = "人员分组管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(windPersonGroupService.deleteWindPersonGroupByIds(ids));
    }
}
