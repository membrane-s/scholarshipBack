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
import com.ruoyi.system.domain.XmReviewOpinion;
import com.ruoyi.system.service.IXmReviewOpinionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审核意见Controller
 * 
 * @author xm
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/instructor/opinion")
public class XmReviewOpinionController extends BaseController
{
    @Autowired
    private IXmReviewOpinionService xmReviewOpinionService;

    /**
     * 查询审核意见列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmReviewOpinion xmReviewOpinion)
    {
        startPage();
        List<XmReviewOpinion> list = xmReviewOpinionService.selectXmReviewOpinionList(xmReviewOpinion);
        return getDataTable(list);
    }

    /**
     * 导出审核意见列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:export')")
    @Log(title = "审核意见", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmReviewOpinion xmReviewOpinion)
    {
        List<XmReviewOpinion> list = xmReviewOpinionService.selectXmReviewOpinionList(xmReviewOpinion);
        ExcelUtil<XmReviewOpinion> util = new ExcelUtil<XmReviewOpinion>(XmReviewOpinion.class);
        util.exportExcel(response, list, "审核意见数据");
    }

    /**
     * 获取审核意见详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:query')")
    @GetMapping(value = "/{reviewId}")
    public AjaxResult getInfo(@PathVariable("reviewId") Long reviewId)
    {
        return success(xmReviewOpinionService.selectXmReviewOpinionByReviewId(reviewId));
    }

    /**
     * 新增审核意见
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:add')")
    @Log(title = "审核意见", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmReviewOpinion xmReviewOpinion)
    {
        return toAjax(xmReviewOpinionService.insertXmReviewOpinion(xmReviewOpinion));
    }

    /**
     * 修改审核意见
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:edit')")
    @Log(title = "审核意见", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmReviewOpinion xmReviewOpinion)
    {
        return toAjax(xmReviewOpinionService.updateXmReviewOpinion(xmReviewOpinion));
    }

    /**
     * 删除审核意见
     */
    @PreAuthorize("@ss.hasPermi('instructor:opinion:remove')")
    @Log(title = "审核意见", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reviewIds}")
    public AjaxResult remove(@PathVariable Long[] reviewIds)
    {
        return toAjax(xmReviewOpinionService.deleteXmReviewOpinionByReviewIds(reviewIds));
    }
}
