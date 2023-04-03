package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.spring.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmScholarshipTypeMapper;
import com.ruoyi.system.domain.XmScholarshipType;
import com.ruoyi.system.service.IXmScholarshipTypeService;

/**
 * 奖学金类型Service业务层处理
 * 
 * @author xm
 * @date 2023-03-03
 */
@Service
public class XmScholarshipTypeServiceImpl implements IXmScholarshipTypeService 
{
    @Autowired
    private XmScholarshipTypeMapper xmScholarshipTypeMapper;

    /**
     * 查询奖学金类型
     * 
     * @param scholarshipTypeId 奖学金类型主键
     * @return 奖学金类型
     */
    @Override
    public XmScholarshipType selectXmScholarshipTypeByScholarshipTypeId(Long scholarshipTypeId)
    {
        return xmScholarshipTypeMapper.selectXmScholarshipTypeByScholarshipTypeId(scholarshipTypeId);
    }

    /**
     * 查询奖学金类型列表
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 奖学金类型
     */
    @Override
    public List<XmScholarshipType> selectXmScholarshipTypeList(XmScholarshipType xmScholarshipType)
    {
        return xmScholarshipTypeMapper.selectXmScholarshipTypeList(xmScholarshipType);
    }

    /**
     * 新增奖学金类型
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 结果
     */
    @Override
    public int insertXmScholarshipType(XmScholarshipType xmScholarshipType)
    {
        return xmScholarshipTypeMapper.insertXmScholarshipType(xmScholarshipType);
    }

    /**
     * 修改奖学金类型
     * 
     * @param xmScholarshipType 奖学金类型
     * @return 结果
     */
    @Override
    public int updateXmScholarshipType(XmScholarshipType xmScholarshipType)
    {
        return xmScholarshipTypeMapper.updateXmScholarshipType(xmScholarshipType);
    }

    /**
     * 批量删除奖学金类型
     * 
     * @param scholarshipTypeIds 需要删除的奖学金类型主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipTypeByScholarshipTypeIds(Long[] scholarshipTypeIds)
    {
        return xmScholarshipTypeMapper.deleteXmScholarshipTypeByScholarshipTypeIds(scholarshipTypeIds);
    }

    /**
     * 删除奖学金类型信息
     * 
     * @param scholarshipTypeId 奖学金类型主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipTypeByScholarshipTypeId(Long scholarshipTypeId)
    {
        return xmScholarshipTypeMapper.deleteXmScholarshipTypeByScholarshipTypeId(scholarshipTypeId);
    }
    @Override
    public List<XmScholarshipType> selectXmScholarshipTypeAll()
    {
        return xmScholarshipTypeMapper.selectAll();
    }

}
