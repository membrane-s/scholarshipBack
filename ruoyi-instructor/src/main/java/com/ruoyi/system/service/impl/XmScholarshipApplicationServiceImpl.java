package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.XmCondition;
import com.ruoyi.system.service.IXmConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmScholarshipApplicationMapper;
import com.ruoyi.system.domain.XmScholarshipApplication;
import com.ruoyi.system.service.IXmScholarshipApplicationService;

/**
 * 奖学金申请Service业务层处理
 * 
 * @author xm
 * @date 2023-03-03
 */
@Service
public class XmScholarshipApplicationServiceImpl implements IXmScholarshipApplicationService 
{
    @Autowired
    private XmScholarshipApplicationMapper xmScholarshipApplicationMapper;

    @Autowired
    private IXmConditionService xmConditionService;

    /**
     * 查询奖学金申请
     * 
     * @param applicationId 奖学金申请主键
     * @return 奖学金申请
     */
    @Override
    public XmScholarshipApplication selectXmScholarshipApplicationByApplicationId(Long applicationId)
    {
        return xmScholarshipApplicationMapper.selectXmScholarshipApplicationByApplicationId(applicationId);
    }

    /**
     * 查询奖学金申请列表
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 奖学金申请
     */
    @Override
    public List<XmScholarshipApplication> selectXmScholarshipApplicationList(XmScholarshipApplication xmScholarshipApplication)
    {
        return xmScholarshipApplicationMapper.selectXmScholarshipApplicationList(xmScholarshipApplication);
    }

    /**
     * 新增奖学金申请
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 结果
     */
    @Override
    public AjaxResult insertXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication)
    {
        xmScholarshipApplication.setUserId(SecurityUtils.getUserId());
        xmScholarshipApplication.setApplicationDate(new Date());
        xmScholarshipApplication.setStatus(Constants.APPLICATION_STATUS_FIRST);
        List<XmCondition> alldata = xmConditionService.selectXmConditionListByScholarshipId(xmScholarshipApplication.getScholarshipId());
        List<XmCondition> approve = xmConditionService.selectXmConditionListByUserId(SecurityUtils.getUserId());
        //预申请档案里包含了必须填写的申请基础条件，以及按照模型提取出来能综合体现学生能力的申请条件
        //奖金申请前要求满足申请的基本条件基本条件不满足则不允许申请，那么不允许申请，并返回对应提示信息。

        List<XmCondition> collect = alldata.stream().filter(o -> !approve.contains(o)).collect(Collectors.toList());

        if(approve.size() < Constants.CONDITION_NECCESSITY_NUMBER){
            return AjaxResult.warn("请完整填写预申请档案以审核您的申请资格！");
        }
        //alldata为奖学金所需所有条件，需要检查是否有学生未填信息
        else if(collect.size() != 0)
        {
            return AjaxResult.warn("请补充完整申请奖学金对应条件",collect.stream().map(XmCondition::getCondition).collect(
                    Collectors.toList()));
        }

        //学生填写信息之后，奖金要求与学生信息进行对比判断条件是否符合，如果不符合则直接返回
        //申请基本条件审核,即进行对比
        //问题是如何进行条件的审核？



        //奖学金必填条件审核，进行奖金条件的对比




        //特殊规则过滤，如果判断是特殊申请，多处理一下而已

        //优秀学生奖与其他将不可重复获取，即获取优秀学生奖后则不允许申请其他奖项

        //在这里记录一点不在此实现的功能。院系在计算通过社会实践奖学金，团学工作奖，文体活动奖人数不得超过9%，在审核人通过时需要进行检测是否符合这个条件

        xmScholarshipApplicationMapper.insertXmScholarshipApplication(xmScholarshipApplication);
        return AjaxResult.success();
    }

    /**
     * 修改奖学金申请
     * @param xmScholarshipApplication 奖学金申请
     * @return 结果
     */
    @Override
    public int updateXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication)
    {
        return xmScholarshipApplicationMapper.updateXmScholarshipApplication(xmScholarshipApplication);
    }

    /**
     * 批量删除奖学金申请
     * 
     * @param applicationIds 需要删除的奖学金申请主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipApplicationByApplicationIds(Long[] applicationIds)
    {
        return xmScholarshipApplicationMapper.deleteXmScholarshipApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除奖学金申请信息
     * 
     * @param applicationId 奖学金申请主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipApplicationByApplicationId(Long applicationId)
    {
        return xmScholarshipApplicationMapper.deleteXmScholarshipApplicationByApplicationId(applicationId);
    }
    @Override
    public List<XmScholarshipApplication> selectXmScholarshipApplicationListByUserId(Long userId)
    {
        return xmScholarshipApplicationMapper.selectXmScholarshipApplicationListByUserId(userId);
    }
}
