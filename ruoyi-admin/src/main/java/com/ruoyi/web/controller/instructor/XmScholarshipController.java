package com.ruoyi.system.controller;

import java.security.Permission;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XmScholarshipDept;
import com.ruoyi.system.domain.XmScholarshipType;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.IXmScholarshipDeptService;
import com.ruoyi.system.service.IXmScholarshipTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XmScholarship;
import com.ruoyi.system.service.IXmScholarshipService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖学金信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-07
 */
@RestController
@RequestMapping("/instructor/scholarship")
public class XmScholarshipController extends BaseController
{
    @Autowired
    private IXmScholarshipService xmScholarshipService;

    @Autowired
    private IXmScholarshipDeptService xmScholarshipDeptService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IXmScholarshipTypeService xmScholarshipTypeService;
    /**
     * 查询奖学金信息列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmScholarship xmScholarship,@RequestParam(value = "deptId", required = false) Long deptId)
    {
        startPage();
        if(deptId == null) xmScholarship.setDeptId(SecurityUtils.getDeptId());
        else xmScholarship.setDeptId(deptId);
        //根据部门呢，去查询部门及以下的奖学金
        List<XmScholarship> list = xmScholarshipService.selectXmScholarshipList(xmScholarship);
        return getDataTable(list);
    }

    /**
     * 查询学生可以申请的奖学金信息列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:slist')")
    @GetMapping("/slist")
    public TableDataInfo slist(XmScholarship xmScholarship)
    {
        startPage();
        //根据部门呢，去查询部门及以下的奖学金
        xmScholarship.setDeptId(SecurityUtils.getDeptId());
        List<XmScholarship> list = xmScholarshipService.selectXmScholarshipList(xmScholarship);
        return getDataTable(list);
    }


    /**
     * 导出奖学金信息列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:export')")
    @Log(title = "奖学金信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmScholarship xmScholarship)
    {
        List<XmScholarship> list = xmScholarshipService.selectXmScholarshipList(xmScholarship);
        ExcelUtil<XmScholarship> util = new ExcelUtil<>(XmScholarship.class);
        util.exportExcel(response, list, "奖学金信息数据");
    }

    /**
     * 获取奖学金信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:query')")
    @GetMapping(value = { "/", "/{scholarshipId}" })
    public AjaxResult getInfo(@PathVariable(value = "scholarshipId", required = false) Long scholarshipId)
    {
        AjaxResult ajax = AjaxResult.success();

        ajax.put("types", xmScholarshipTypeService.selectXmScholarshipTypeAll());
        //ajax.put("depts", deptService.selectDeptTreeList(new SysDept()));
        if (StringUtils.isNotNull(scholarshipId))
        {
            XmScholarship xmScholarship = xmScholarshipService.selectXmScholarshipByScholarshipId(scholarshipId);
            ajax.put(AjaxResult.DATA_TAG, xmScholarship);
            ajax.put("checkedKeys", xmScholarship.getDepts().stream().map(SysDept::getDeptId).collect(Collectors.toList()));
            ajax.put("typeIds", xmScholarship.getTypes().stream().map(XmScholarshipType::getScholarshipTypeId).collect(
                    Collectors.toList()));
        }
        return ajax;
    }

    /**
     * 新增奖学金信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:add')")
    @Log(title = "奖学金信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmScholarship xmScholarship)
    {
        return toAjax(xmScholarshipService.insertXmScholarship(xmScholarship));
    }

    /**
     * 修改奖学金信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:edit')")
    @Log(title = "奖学金信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmScholarship xmScholarship)
    {
        return toAjax(xmScholarshipService.updateXmScholarship(xmScholarship));
    }

    /**
     * 删除奖学金信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarship:remove')")
    @Log(title = "奖学金信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scholarshipIds}")
    public AjaxResult remove(@PathVariable Long[] scholarshipIds)
    {
        return toAjax(xmScholarshipService.deleteXmScholarshipByScholarshipIds(scholarshipIds));
    }
}
