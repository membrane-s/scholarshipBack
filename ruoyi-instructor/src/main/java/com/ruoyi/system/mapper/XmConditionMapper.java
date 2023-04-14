package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Objects;

import com.ruoyi.system.domain.XmCondition;

/**
 * 申请条件Mapper接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface XmConditionMapper 
{
    /**
     * 查询申请条件
     * 
     * @param conditionId 申请条件主键
     * @return 申请条件
     */
    public XmCondition selectXmConditionByConditionId(Long conditionId);

    /**
     * 查询申请条件列表
     * 
     * @param xmCondition 申请条件
     * @return 申请条件集合
     */
    public List<XmCondition> selectXmConditionList(XmCondition xmCondition);

    /**
     * 新增申请条件
     * 
     * @param xmCondition 申请条件
     * @return 结果
     */
    public int insertXmCondition(XmCondition xmCondition);

    /**
     * 修改申请条件
     * 
     * @param xmCondition 申请条件
     * @return 结果
     */
    public int updateXmCondition(XmCondition xmCondition);

    /**
     * 删除申请条件
     * 
     * @param conditionId 申请条件主键
     * @return 结果
     */
    public int deleteXmConditionByConditionId(Long conditionId);

    /**
     * 批量删除申请条件
     * 
     * @param conditionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmConditionByConditionIds(Long[] conditionIds);
    String selectXmConditionListByScholarshipId(Long scholarshipId);
    String selectNeesXmConditionListByUserId(Long userId);
    String selectUnNeedXmConditionListByUserId(Long userId);
    String selectXmConditionListByUserId(Long userId);
}
