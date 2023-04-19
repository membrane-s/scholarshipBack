package com.ruoyi.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.XmCondition;

/**
 * 申请条件Service接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface IXmConditionService 
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
     * 批量删除申请条件
     * 
     * @param conditionIds 需要删除的申请条件主键集合
     * @return 结果
     */
    public int deleteXmConditionByConditionIds(Long[] conditionIds);

    /**
     * 删除申请条件信息
     * 
     * @param conditionId 申请条件主键
     * @return 结果
     */
    public int deleteXmConditionByConditionId(Long conditionId);
    List<XmCondition> selectXmConditionListByScholarshipId(Long scholarshipId);
    List<XmCondition> selectXmConditionListByUserId(Long userId);
    List<XmCondition> selectNeedXmConditionListByUserId(Long userId);
    List<XmCondition> selectUnNeedXmConditionListByUserId(Long userId);
    JSONObject selectXmConditionAllList();
}
