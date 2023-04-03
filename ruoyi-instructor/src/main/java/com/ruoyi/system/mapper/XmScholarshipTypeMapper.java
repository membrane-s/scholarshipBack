package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XmScholarshipType;

/**
 * 奖学金类型Mapper接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface XmScholarshipTypeMapper 
{
    /**
     * 查询奖学金类型
     * 
     * @param scholarshipTypeId 奖学金类型主键
     * @return 奖学金类型
     */
    public XmScholarshipType selectXmScholarshipTypeByScholarshipTypeId(Long scholarshipTypeId);

    /**
     * 查询奖学金类型列表
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 奖学金类型集合
     */
    public List<XmScholarshipType> selectXmScholarshipTypeList(XmScholarshipType xmScholarshipType);

    /**
     * 新增奖学金类型
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 结果
     */
    public int insertXmScholarshipType(XmScholarshipType xmScholarshipType);

    /**
     * 修改奖学金类型
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 结果
     */
    public int updateXmScholarshipType(XmScholarshipType xmScholarshipType);

    /**
     * 删除奖学金类型
     * 
     * @param scholarshipTypeId 奖学金类型主键
     * @return 结果
     */
    public int deleteXmScholarshipTypeByScholarshipTypeId(Long scholarshipTypeId);

    /**
     * 批量删除奖学金类型
     * 
     * @param scholarshipTypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmScholarshipTypeByScholarshipTypeIds(Long[] scholarshipTypeIds);
    List<XmScholarshipType> selectAll();
    List<XmScholarshipType> selectTypeByScholarshipId(Long scholarshipId);
}
