package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmScholarshipScholarshiptypeMapper;
import com.ruoyi.system.domain.XmScholarshipScholarshiptype;
import com.ruoyi.system.service.IXmScholarshipScholarshiptypeService;

/**
 * 奖学金与奖学金类型关联Service业务层处理
 * 
 * @author xm
 * @date 2023-03-03
 */
@Service
public class XmScholarshipScholarshiptypeServiceImpl implements IXmScholarshipScholarshiptypeService 
{
    @Autowired
    private XmScholarshipScholarshiptypeMapper xmScholarshipScholarshiptypeMapper;

    /**
     * 查询奖学金与奖学金类型关联
     * 
     * @param scholarshipTypeId 奖学金与奖学金类型关联主键
     * @return 奖学金与奖学金类型关联
     */
    @Override
    public XmScholarshipScholarshiptype selectXmScholarshipScholarshiptypeByScholarshipTypeId(Long scholarshipTypeId)
    {
        return xmScholarshipScholarshiptypeMapper.selectXmScholarshipScholarshiptypeByScholarshipTypeId(scholarshipTypeId);
    }

    /**
     * 查询奖学金与奖学金类型关联列表
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 奖学金与奖学金类型关联
     */
    @Override
    public List<XmScholarshipScholarshiptype> selectXmScholarshipScholarshiptypeList(XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        return xmScholarshipScholarshiptypeMapper.selectXmScholarshipScholarshiptypeList(xmScholarshipScholarshiptype);
    }

    /**
     * 新增奖学金与奖学金类型关联
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 结果
     */
    @Override
    public int insertXmScholarshipScholarshiptype(XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        return xmScholarshipScholarshiptypeMapper.insertXmScholarshipScholarshiptype(xmScholarshipScholarshiptype);
    }

    /**
     * 修改奖学金与奖学金类型关联
     * 
     * @param xmScholarshipScholarshiptype 奖学金与奖学金类型关联
     * @return 结果
     */
    @Override
    public int updateXmScholarshipScholarshiptype(XmScholarshipScholarshiptype xmScholarshipScholarshiptype)
    {
        return xmScholarshipScholarshiptypeMapper.updateXmScholarshipScholarshiptype(xmScholarshipScholarshiptype);
    }

    /**
     * 批量删除奖学金与奖学金类型关联
     * 
     * @param scholarshipTypeIds 需要删除的奖学金与奖学金类型关联主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipScholarshiptypeByScholarshipTypeIds(Long[] scholarshipTypeIds)
    {
        return xmScholarshipScholarshiptypeMapper.deleteXmScholarshipScholarshiptypeByScholarshipTypeIds(scholarshipTypeIds);
    }

    /**
     * 删除奖学金与奖学金类型关联信息
     * 
     * @param scholarshipTypeId 奖学金与奖学金类型关联主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipScholarshiptypeByScholarshipTypeId(Long scholarshipTypeId)
    {
        return xmScholarshipScholarshiptypeMapper.deleteXmScholarshipScholarshiptypeByScholarshipTypeId(scholarshipTypeId);
    }
}
