package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmScholarshipScholarshiptype;

/**
 * 奖学金与奖学金类型关联Service接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface IXmScholarshipScholarshiptypeService 
{
    /**
     * 查询奖学金与奖学金类型关联
     * 
     * @param scholarshipTypeId 奖学金与奖学金类型关联主键
     * @return 奖学金与奖学金类型关联
     */
    public XmScholarshipScholarshiptype selectXmScholarshipScholarshiptypeByScholarshipTypeId(Long scholarshipTypeId);

    /**
     * 查询奖学金与奖学金类型关联列表
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 奖学金与奖学金类型关联集合
     */
    public List<XmScholarshipScholarshiptype> selectXmScholarshipScholarshiptypeList(XmScholarshipScholarshiptype xmScholarshipScholarshiptype);

    /**
     * 新增奖学金与奖学金类型关联
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 结果
     */
    public int insertXmScholarshipScholarshiptype(XmScholarshipScholarshiptype xmScholarshipScholarshiptype);

    /**
     * 修改奖学金与奖学金类型关联
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 结果
     */
    public int updateXmScholarshipScholarshiptype(XmScholarshipScholarshiptype xmScholarshipScholarshiptype);

    /**
     * 批量删除奖学金与奖学金类型关联
     * 
     * @param scholarshipTypeIds 需要删除的奖学金与奖学金类型关联主键集合
     * @return 结果
     */
    public int deleteXmScholarshipScholarshiptypeByScholarshipTypeIds(Long[] scholarshipTypeIds);

    /**
     * 删除奖学金与奖学金类型关联信息
     * 
     * @param scholarshipTypeId 奖学金与奖学金类型关联主键
     * @return 结果
     */
    public int deleteXmScholarshipScholarshiptypeByScholarshipTypeId(Long scholarshipTypeId);
}
