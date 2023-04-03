package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmScholarshipDeptMapper;
import com.ruoyi.system.domain.XmScholarshipDept;
import com.ruoyi.system.service.IXmScholarshipDeptService;

/**
 * 奖学金与部门类型关联Service业务层处理
 * 
 * @author xm
 * @date 2023-03-09
 */
@Service
public class XmScholarshipDeptServiceImpl implements IXmScholarshipDeptService 
{
    @Autowired
    private XmScholarshipDeptMapper xmScholarshipDeptMapper;

    /**
     * 查询奖学金与部门类型关联
     * 
     * @param scholarshipId 奖学金与部门类型关联主键
     * @return 奖学金与部门类型关联
     */
    @Override
    public XmScholarshipDept selectXmScholarshipDeptByScholarshipId(Long scholarshipId)
    {
        return xmScholarshipDeptMapper.selectXmScholarshipDeptByScholarshipId(scholarshipId);
    }

    /**
     * 查询奖学金与部门类型关联列表
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 奖学金与部门类型关联
     */
    @Override
    public List<XmScholarshipDept> selectXmScholarshipDeptList(XmScholarshipDept xmScholarshipDept)
    {
        return xmScholarshipDeptMapper.selectXmScholarshipDeptList(xmScholarshipDept);
    }

    /**
     * 新增奖学金与部门类型关联
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 结果
     */
    @Override
    public int insertXmScholarshipDept(XmScholarshipDept xmScholarshipDept)
    {
        return xmScholarshipDeptMapper.insertXmScholarshipDept(xmScholarshipDept);
    }

    /**
     * 修改奖学金与部门类型关联
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 结果
     */
    @Override
    public int updateXmScholarshipDept(XmScholarshipDept xmScholarshipDept)
    {
        return xmScholarshipDeptMapper.updateXmScholarshipDept(xmScholarshipDept);
    }

    /**
     * 批量删除奖学金与部门类型关联
     * 
     * @param scholarshipIds 需要删除的奖学金与部门类型关联主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipDeptByScholarshipIds(Long[] scholarshipIds)
    {
        return xmScholarshipDeptMapper.deleteXmScholarshipDeptByScholarshipIds(scholarshipIds);
    }

    /**
     * 删除奖学金与部门类型关联信息
     * 
     * @param scholarshipId 奖学金与部门类型关联主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipDeptByScholarshipId(Long scholarshipId)
    {
        return xmScholarshipDeptMapper.deleteXmScholarshipDeptByScholarshipId(scholarshipId);
    }
    @Override
    public List<XmScholarshipDept> selectXmScholarshipDeptAll()
    {
        return xmScholarshipDeptMapper.selectXmScholarshipDeptAll();
    }
}
