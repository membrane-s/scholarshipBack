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
import com.ruoyi.system.domain.XmScholarshipScholarshiptype;
import com.ruoyi.system.service.IXmScholarshipScholarshiptypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖学金与奖学金类型关联Controller
 * 
 * @author xm
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/instructor/scholarshiptype")
public class XmScholarshipScholarshiptypeController extends BaseController
{
    @Autowired
    private IXmScholarshipScholarshiptypeService xmScholarshipScholarshiptypeService;

    /**
     * 查询奖学金与奖学金类型关联列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        startPage();
        List<XmScholarshipScholarshiptype> list = xmScholarshipScholarshiptypeService.selectXmScholarshipScholarshiptypeList(xmScholarshipScholarshiptype);
        return getDataTable(list);
    }

    /**
     * 导出奖学金与奖学金类型关联列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:export')")
    @Log(title = "奖学金与奖学金类型关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        List<XmScholarshipScholarshiptype> list = xmScholarshipScholarshiptypeService.selectXmScholarshipScholarshiptypeList(xmScholarshipScholarshiptype);
        ExcelUtil<XmScholarshipScholarshiptype> util = new ExcelUtil<XmScholarshipScholarshiptype>(XmScholarshipScholarshiptype.class);
        util.exportExcel(response, list, "奖学金与奖学金类型关联数据");
    }

    /**
     * 获取奖学金与奖学金类型关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:query')")
    @GetMapping(value = "/{scholarshipTypeId}")
    public AjaxResult getInfo(@PathVariable("scholarshipTypeId") Long scholarshipTypeId)
    {
        return success(xmScholarshipScholarshiptypeService.selectXmScholarshipScholarshiptypeByScholarshipTypeId(scholarshipTypeId));
    }

    /**
     * 新增奖学金与奖学金类型关联
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:add')")
    @Log(title = "奖学金与奖学金类型关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        return toAjax(xmScholarshipScholarshiptypeService.insertXmScholarshipScholarshiptype(xmScholarshipScholarshiptype));
    }

    /**
     * 修改奖学金与奖学金类型关联
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:edit')")
    @Log(title = "奖学金与奖学金类型关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        return toAjax(xmScholarshipScholarshiptypeService.updateXmScholarshipScholarshiptype(xmScholarshipScholarshiptype));
    }

    /**
     * 删除奖学金与奖学金类型关联
     */
    @PreAuthorize("@ss.hasPermi('instructor:scholarshiptype:remove')")
    @Log(title = "奖学金与奖学金类型关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scholarshipTypeIds}")
    public AjaxResult remove(@PathVariable Long[] scholarshipTypeIds)
    {
        return toAjax(xmScholarshipScholarshiptypeService.deleteXmScholarshipScholarshiptypeByScholarshipTypeIds(scholarshipTypeIds));
    }
}
