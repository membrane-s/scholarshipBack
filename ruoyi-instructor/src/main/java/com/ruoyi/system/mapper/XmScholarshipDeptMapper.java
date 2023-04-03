package com.ruoyi.system.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.XmScholarshipDept;

/**
 * 奖学金与部门类型关联Mapper接口
 * 
 * @author xm
 * @date 2023-03-09
 */
public interface XmScholarshipDeptMapper 
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
     * 删除奖学金与部门类型关联
     * 
     * @param scholarshipId 奖学金与部门类型关联主键
     * @return 结果
     */
    public int deleteXmScholarshipDeptByScholarshipId(Long scholarshipId);

    /**
     * 批量删除奖学金与部门类型关联
     * 
     * @param scholarshipIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmScholarshipDeptByScholarshipIds(Long[] scholarshipIds);
    int batchScholarshipDept(ArrayList<XmScholarshipDept> list);
    List<XmScholarshipDept> selectXmScholarshipDeptAll();
    List<SysDept> selectDeptByScholarshipId(Long scholarshipId);
}
