package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmScholarship;

/**
 * 奖学金信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-07
 */
public interface IXmScholarshipService 
{
    /**
     * 查询奖学金信息
     * 
     * @param scholarshipId 奖学金信息主键
     * @return 奖学金信息
     */
    public XmScholarship selectXmScholarshipByScholarshipId(Long scholarshipId);

    /**
     * 查询奖学金信息列表
     * 
     * @param xmScholarship 奖学金信息
     * @return 奖学金信息集合
     */
    public List<XmScholarship> selectXmScholarshipList(XmScholarship xmScholarship);

    /**
     * 新增奖学金信息
     * 
     * @param xmScholarship 奖学金信息
     * @return 结果
     */
    public int insertXmScholarship(XmScholarship xmScholarship);

    /**
     * 修改奖学金信息
     * 
     * @param xmScholarship 奖学金信息
     * @return 结果
     */
    public int updateXmScholarship(XmScholarship xmScholarship);

    /**
     * 批量删除奖学金信息
     * 
     * @param scholarshipIds 需要删除的奖学金信息主键集合
     * @return 结果
     */
    public int deleteXmScholarshipByScholarshipIds(Long[] scholarshipIds);

    /**
     * 删除奖学金信息信息
     * 
     * @param scholarshipId 奖学金信息主键
     * @return 结果
     */
    public int deleteXmScholarshipByScholarshipId(Long scholarshipId);
}
