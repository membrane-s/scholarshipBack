package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XmScholarshipApplication;

/**
 * 奖学金申请Mapper接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface XmScholarshipApplicationMapper 
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
    public int insertXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication);

    /**
     * 修改奖学金申请
     * 
     * @param xmScholarshipApplication 奖学金申请
     * @return 结果
     */
    public int updateXmScholarshipApplication(XmScholarshipApplication xmScholarshipApplication);

    /**
     * 删除奖学金申请
     * 
     * @param applicationId 奖学金申请主键
     * @return 结果
     */
    public int deleteXmScholarshipApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除奖学金申请
     * 
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmScholarshipApplicationByApplicationIds(Long[] applicationIds);
    List<XmScholarshipApplication> selectXmScholarshipApplicationListByUserId(Long userId);
}
