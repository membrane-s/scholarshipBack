package com.ruoyi.web.controller.instructor;

import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.system.domain.XmScholarshipApplication;
import com.ruoyi.system.service.IXmScholarshipApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖学金申请Controller
 * 
 * @author xm
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/instructor/application")
public class XmScholarshipApplicationController extends BaseController
{
    @Autowired
    private IXmScholarshipApplicationService xmScholarshipApplicationService;

    /**
     * 审核角色查询奖学金申请列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmScholarshipApplication xmScholarshipApplication)
    {
        startPage();
        List<XmScholarshipApplication> list = xmScholarshipApplicationService.selectXmScholarshipApplicationList(xmScholarshipApplication);
        return getDataTable(list);
    }

    /**
     * 学生个人查询奖学金申请列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:slist')")
    @GetMapping("/slist")
    public TableDataInfo slist(XmScholarshipApplication xmScholarshipApplication)
    {
        startPage();
        if(Objects.isNull(xmScholarshipApplication.getUserId()))    xmScholarshipApplication.setUserId(SecurityUtils.getUserId());
        List<XmScholarshipApplication> list = xmScholarshipApplicationService.selectXmScholarshipApplicationList(xmScholarshipApplication);
        return getDataTable(list);
    }


    /**
     * 用于查询学生的申请记录
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:applicationlist')")
    @GetMapping("/applicationlist")
    public TableDataInfo applicationlist()
    {
        startPage();
        //根据用户id获取相关的申请记录
        List<XmScholarshipApplication> list = xmScholarshipApplicationService.selectXmScholarshipApplicationListByUserId(SecurityUtils.getUserId());
        return getDataTable(list);
    }
    /**
     * 导出奖学金申请列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:export')")
    @Log(title = "奖学金申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmScholarshipApplication xmScholarshipApplication)
    {
        List<XmScholarshipApplication> list = xmScholarshipApplicationService.selectXmScholarshipApplicationList(xmScholarshipApplication);
        ExcelUtil<XmScholarshipApplication> util = new ExcelUtil<XmScholarshipApplication>(XmScholarshipApplication.class);
        util.exportExcel(response, list, "奖学金申请数据");
    }

    /**
     * 获取奖学金申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(xmScholarshipApplicationService.selectXmScholarshipApplicationByApplicationId(applicationId));
    }

    /**
     * 新增奖学金申请
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:add')")
    @Log(title = "奖学金申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmScholarshipApplication xmScholarshipApplication)
    {
        return xmScholarshipApplicationService.insertXmScholarshipApplication(xmScholarshipApplication);
    }

    /**
     * 修改奖学金申请
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:edit')")
    @Log(title = "奖学金申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmScholarshipApplication xmScholarshipApplication)
    {
        return toAjax(xmScholarshipApplicationService.updateXmScholarshipApplication(xmScholarshipApplication));
    }

    /**
     * 删除奖学金申请
     */
    @PreAuthorize("@ss.hasPermi('instructor:application:remove')")
    @Log(title = "奖学金申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(xmScholarshipApplicationService.deleteXmScholarshipApplicationByApplicationIds(applicationIds));
    }
}
