package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmScholarshipDept;

/**
 * 奖学金与部门类型关联Service接口
 * 
 * @author xm
 * @date 2023-03-09
 */
public interface IXmScholarshipDeptService 
{
    /**
     * 查询奖学金与部门类型关联
     * 
     * @param scholarshipId 奖学金与部门类型关联主键
     * @return 奖学金与部门类型关联
     */
    public XmScholarshipDept selectXmScholarshipDeptByScholarshipId(Long scholarshipId);

    /**
     * 查询奖学金与部门类型关联列表
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 奖学金与部门类型关联集合
     */
    public List<XmScholarshipDept> selectXmScholarshipDeptList(XmScholarshipDept xmScholarshipDept);

    /**
     * 新增奖学金与部门类型关联
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 结果
     */
    public int insertXmScholarshipDept(XmScholarshipDept xmScholarshipDept);

    /**
     * 修改奖学金与部门类型关联
     * 
     * @param xmScholarshipDept 奖学金与部门类型关联
     * @return 结果
     */
    public int updateXmScholarshipDept(XmScholarshipDept xmScholarshipDept);

    /**
     * 批量删除奖学金与部门类型关联
     * 
     * @param scholarshipIds 需要删除的奖学金与部门类型关联主键集合
     * @return 结果
     */
    public int deleteXmScholarshipDeptByScholarshipIds(Long[] scholarshipIds);

    /**
     * 删除奖学金与部门类型关联信息
     * 
     * @param scholarshipId 奖学金与部门类型关联主键
     * @return 结果
     */
    public int deleteXmScholarshipDeptByScholarshipId(Long scholarshipId);
    List<XmScholarshipDept> selectXmScholarshipDeptAll();
}
