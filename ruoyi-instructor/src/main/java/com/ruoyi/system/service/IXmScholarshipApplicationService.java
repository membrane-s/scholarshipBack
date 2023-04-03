package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.XmScholarshipApplication;

/**
 * 奖学金申请Service接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface IXmScholarshipApplicationService 
{
    /**
     * 查询奖学金申请
     * 
     * @param applicationId 奖学金申请主键
     * @return 奖学金申请
     */
    public XmScholarshipApplication selectXmScholarshipApplicationByApplicationId(Long applicationId);

    /**
     * 查询奖学金申请列表
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 奖学金申请集合
     */
    public List<XmScholarshipApplication> selectXmScholarshipApplicationList(XmScholarshipApplication xmScholarshipApplication);

    /**
     * 新增奖学金申请
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 结果
     */
    public AjaxResult insertXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication);

    /**
     * 修改奖学金申请
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 结果
     */
    public int updateXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication);

    /**
     * 批量删除奖学金申请
     * 
     * @param applicationIds 需要删除的奖学金申请主键集合
     * @return 结果
     */
    public int deleteXmScholarshipApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除奖学金申请信息
     * 
     * @param applicationId 奖学金申请主键
     * @return 结果
     */
    public int deleteXmScholarshipApplicationByApplicationId(Long applicationId);
    List<XmScholarshipApplication> selectXmScholarshipApplicationListByUserId(Long userId);
}
