package com.ruoyi.web.controller.instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.XmCondition;
import com.ruoyi.system.service.IXmConditionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * @author xm
 * @date 2023-03-03
 */
@RestController
@RequestMapping("/instructor/condition")
public class XmConditionController extends BaseController
{
    @Autowired
    private IXmConditionService xmConditionService;


    /**
     * 查询申请条件列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:list')")
    @GetMapping("/list")
    public TableDataInfo list(XmCondition xmCondition)
    {
        startPage();
        List<XmCondition> list = xmConditionService.selectXmConditionList(xmCondition);
        return getDataTable(list);
    }

    /**
     * 根据奖金ID查询对应申请条件列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:slistCondition')")
    @GetMapping(value = "/slistCondition/{scholarshipId}")
    public AjaxResult slistCondition(@PathVariable("scholarshipId") Long scholarshipId)
    {

        //奖学金要求的申请条件  --> all data
        List<XmCondition> list = xmConditionService.selectXmConditionListByScholarshipId(scholarshipId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("alldata",list);

        //学生实际的申请条件，肯定也是在奖学金要求的子集内，因此需要将学生的申请条件都查询出来
        // 置灰条件 = all data - alldata与list1的交际
 /*     List<XmCondition> list1 = xmConditionService.selectXmConditionListByUserId(SecurityUtils.getUserId());
        if(Objects.isNull(list1) || list1.size() == 0)   return AjaxResult.warn("您还未填写预申请档案，请先填写！");

        List<XmCondition> result = list.stream()
                .filter(item -> list1.stream().noneMatch(item1 -> item1.getConditionId().equals(item.getConditionId())))
                .collect(Collectors.toList());
        jsonObject.put("no_approve",result);*/
        XmCondition xmCondition = list.get(0);
        ArrayList<XmCondition> xmConditions = new ArrayList<>();
        xmConditions.add(xmCondition);
        jsonObject.put("no_approve",xmConditions);

        return success(jsonObject);
    }

    /**
     * 导出申请条件列表
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:export')")
    @Log(title = "申请条件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XmCondition xmCondition)
    {
        List<XmCondition> list = xmConditionService.selectXmConditionList(xmCondition);
        ExcelUtil<XmCondition> util = new ExcelUtil<XmCondition>(XmCondition.class);
        util.exportExcel(response, list, "申请条件数据");
    }

    /**
     * 获取申请条件详细信息
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:query')")
    @GetMapping(value = "/{conditionId}")
    public AjaxResult getInfo(@PathVariable("conditionId") Long conditionId)
    {
        return success(xmConditionService.selectXmConditionByConditionId(conditionId));
    }

    /**
     * 新增申请条件
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:add')")
    @Log(title = "申请条件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XmCondition xmCondition)
    {
        return toAjax(xmConditionService.insertXmCondition(xmCondition));
    }

    /**
     * 修改申请条件
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:edit')")
    @Log(title = "申请条件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XmCondition xmCondition)
    {
        return toAjax(xmConditionService.updateXmCondition(xmCondition));
    }

    /**
     * 删除申请条件
     */
    @PreAuthorize("@ss.hasPermi('instructor:condition:remove')")
    @Log(title = "申请条件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{conditionIds}")
    public AjaxResult remove(@PathVariable Long[] conditionIds)
    {
        return toAjax(xmConditionService.deleteXmConditionByConditionIds(conditionIds));
    }
}
