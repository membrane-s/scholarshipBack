package com.ruoyi.system.service.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmConditionMapper;
import com.ruoyi.system.domain.XmCondition;
import com.ruoyi.system.service.IXmConditionService;

/**
 * 申请条件Service业务层处理
 * 
 * @author xm
 * @date 2023-03-03
 */
@Service
public class XmConditionServiceImpl implements IXmConditionService 
{
    @Autowired
    private XmConditionMapper xmConditionMapper;

    /**
     * 查询申请条件
     * 
     * @param conditionId 申请条件主键
     * @return 申请条件
     */
    @Override
    public XmCondition selectXmConditionByConditionId(Long conditionId)
    {
        return xmConditionMapper.selectXmConditionByConditionId(conditionId);
    }

    /**
     * 查询申请条件列表
     * 
     * @param xmCondition 申请条件
     * @return 申请条件
     */
    @Override
    public List<XmCondition> selectXmConditionList(XmCondition xmCondition)
    {
        return xmConditionMapper.selectXmConditionList(xmCondition);
    }

    /**
     * 新增申请条件
     * 
     * @param xmCondition 申请条件
     * @return 结果
     */
    @Override
    public int insertXmCondition(XmCondition xmCondition)
    {
        return xmConditionMapper.insertXmCondition(xmCondition);
    }

    /**
     * 修改申请条件
     * 
     * @param xmCondition 申请条件
     * @return 结果
     */
    @Override
    public int updateXmCondition(XmCondition xmCondition)
    {
        return xmConditionMapper.updateXmCondition(xmCondition);
    }

    /**
     * 批量删除申请条件
     * 
     * @param conditionIds 需要删除的申请条件主键
     * @return 结果
     */
    @Override
    public int deleteXmConditionByConditionIds(Long[] conditionIds)
    {
        return xmConditionMapper.deleteXmConditionByConditionIds(conditionIds);
    }

    /**
     * 删除申请条件信息
     * 
     * @param conditionId 申请条件主键
     * @return 结果
     */
    @Override
    public int deleteXmConditionByConditionId(Long conditionId)
    {
        return xmConditionMapper.deleteXmConditionByConditionId(conditionId);
    }
    @Override
    public List<XmCondition> selectXmConditionListByScholarshipId(Long scholarshipId)
    {
        String str = xmConditionMapper.selectXmConditionListByScholarshipId(scholarshipId);
        return JSON.parseArray(str, XmCondition.class);
    }
    @Override
    public List<XmCondition> selectXmConditionListByUserId(Long userId)
    {
        String str = xmConditionMapper.selectXmConditionListByUserId(userId);
        return JSON.parseArray(str, XmCondition.class);
    }

    @Override
    public List<XmCondition> selectNeedXmConditionListByUserId(Long userId)
    {
        String str = xmConditionMapper.selectNeesXmConditionListByUserId(userId);
        return JSON.parseArray(str, XmCondition.class);
    }
    @Override
    public List<XmCondition> selectUnNeedXmConditionListByUserId(Long userId)
    {
        String str = xmConditionMapper.selectUnNeedXmConditionListByUserId(userId);
        return JSON.parseArray(str, XmCondition.class);
    }
    @Override
    public JSONObject selectXmConditionAllList()
    {
        List<XmCondition> xmConditions = xmConditionMapper.selectXmConditionAllList();

        List<XmCondition> xmConditions1 = xmConditionMapper.selectUnXmConditionAllList();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("conditionContent", xmConditions);
        jsonObject.put("unConditionContent", xmConditions1);
        return jsonObject;
    }
}
