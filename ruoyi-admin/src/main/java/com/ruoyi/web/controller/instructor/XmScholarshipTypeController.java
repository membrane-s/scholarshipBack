package com.ruoyi.web.controller.instructor;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XmScholarshipType;
import com.ruoyi.system.service.IXmScholarshipTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖学金类型Controller
 * 
 * @author xm
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/instructor/type")
public class XmScholarshipTypeController extends BaseController
{
    @Autowired
    private IXmScholarshipTypeService xmScholarshipTypeService;

    /**
     * 查询奖学金类型列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmScholarshipType xmScholarshipType)
    {
        startPage();
        List<XmScholarshipType> list = xmScholarshipTypeService.selectXmScholarshipTypeList(xmScholarshipType);
        return getDataTable(list);
    }

    /**
     * 导出奖学金类型列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:export')")
    @Log(title = "奖学金类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmScholarshipType xmScholarshipType)
    {
        List<XmScholarshipType> list = xmScholarshipTypeService.selectXmScholarshipTypeList(xmScholarshipType);
        ExcelUtil<XmScholarshipType> util = new ExcelUtil<XmScholarshipType>(XmScholarshipType.class);
        util.exportExcel(response, list, "奖学金类型数据");
    }

    /**
     * 获取奖学金类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:query')")
    @GetMapping(value = "/{scholarshipTypeId}")
    public AjaxResult getInfo(@PathVariable("scholarshipTypeId") Long scholarshipTypeId)
    {
        return success(xmScholarshipTypeService.selectXmScholarshipTypeByScholarshipTypeId(scholarshipTypeId));
    }

    /**
     * 新增奖学金类型
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:add')")
    @Log(title = "奖学金类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmScholarshipType xmScholarshipType)
    {
        return toAjax(xmScholarshipTypeService.insertXmScholarshipType(xmScholarshipType));
    }

    /**
     * 修改奖学金类型
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:edit')")
    @Log(title = "奖学金类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmScholarshipType xmScholarshipType)
    {
        return toAjax(xmScholarshipTypeService.updateXmScholarshipType(xmScholarshipType));
    }

    /**
     * 删除奖学金类型
     */
    @PreAuthorize("@ss.hasPermi('instructor:type:remove')")
    @Log(title = "奖学金类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scholarshipTypeIds}")
    public AjaxResult remove(@PathVariable Long[] scholarshipTypeIds)
    {
        return toAjax(xmScholarshipTypeService.deleteXmScholarshipTypeByScholarshipTypeIds(scholarshipTypeIds));
    }
}
