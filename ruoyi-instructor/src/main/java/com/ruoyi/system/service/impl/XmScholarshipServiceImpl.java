package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.XmCondition;
import com.ruoyi.system.domain.XmScholarshipDept;
import com.ruoyi.system.domain.XmScholarshipScholarshiptype;
import com.ruoyi.system.domain.XmScholarshipType;
import com.ruoyi.system.mapper.XmScholarshipDeptMapper;
import com.ruoyi.system.mapper.XmScholarshipScholarshiptypeMapper;
import com.ruoyi.system.mapper.XmScholarshipTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmScholarshipMapper;
import com.ruoyi.system.domain.XmScholarship;
import com.ruoyi.system.service.IXmScholarshipService;

/**
 * 奖学金信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-07
 */
@Service
public class XmScholarshipServiceImpl implements IXmScholarshipService 
{
    @Autowired
    private XmScholarshipMapper xmScholarshipMapper;

    @Autowired
    private XmScholarshipDeptMapper xmScholarshipDeptMapper;

    @Autowired
    private XmScholarshipTypeMapper xmScholarshipTypeMapper;


    @Autowired
    private XmScholarshipScholarshiptypeMapper xmScholarshipScholarshiptypeMapper;

    /**
     * 查询奖学金信息
     * 
     * @param scholarshipId 奖学金信息主键
     * @return 奖学金信息
     */
    @Override
    public XmScholarship selectXmScholarshipByScholarshipId(Long scholarshipId)
    {
        XmScholarship xmScholarship = xmScholarshipMapper.selectXmScholarshipByScholarshipId(scholarshipId);
        //如果申请条件为选择的话，不进行解析返回结果应该为
        if(xmScholarship.getConditionContent() != null){
            List<XmCondition> conditions = JSON.parseObject(xmScholarship.getConditionContent(), new TypeReference<List<XmCondition>>()
            {
            });
            xmScholarship.setConditions(conditions);
        }

        return xmScholarship;
    }

    /**
     * 查询奖学金信息列表
     * 
     * @param xmScholarship 奖学金信息
     * @return 奖学金信息
     */
    @Override
    public List<XmScholarship> selectXmScholarshipList(XmScholarship xmScholarship)
    {

        List<XmScholarship> xmScholarships = xmScholarship.getDeptId() == null ? xmScholarshipMapper.selectXmScholarshipList(xmScholarship) : xmScholarshipMapper.selectXmScholarshipListByDeptId(xmScholarship);
        xmScholarships.stream().forEach(xmScholarship1 -> {
            xmScholarship1.setDepts(xmScholarshipDeptMapper.selectDeptByScholarshipId(xmScholarship1.getScholarshipId()));
            xmScholarship1.setTypes(xmScholarshipTypeMapper.selectTypeByScholarshipId(xmScholarship1.getScholarshipId()));
        });
        return xmScholarships;
    }

    /**
     * 新增奖学金信息
     * 
     * @param xmScholarship 奖学金信息
     * @return 结果
     */
    @Override
    public int insertXmScholarship(XmScholarship xmScholarship)
    {
        xmScholarship.setCreateTime(DateUtils.getNowDate());
        xmScholarship.setCreatetorId(SecurityUtils.getUserId());
        xmScholarship.setConditionContent(JSON.toJSONString(xmScholarship.getConditions()));
        //新增奖学金信息
        int rows = xmScholarshipMapper.insertXmScholarship(xmScholarship);
        //新增奖学金类型关联
        insertXmScholarshipScholarshipType(xmScholarship);
        //新增奖学金部门关联
        insertXmScholarshipDept(xmScholarship);

        return rows;
    }
    private void insertXmScholarshipDept(XmScholarship xmScholarship)
    {
        Long[] deptIds = xmScholarship.getDeptIds();
        if(StringUtils.isNotEmpty(deptIds))
        {
            ArrayList<XmScholarshipDept> list = new ArrayList<>(deptIds.length);
            for(Long deptid : deptIds)
            {
                XmScholarshipDept sd = new XmScholarshipDept();
                sd.setScholarshipId(xmScholarship.getScholarshipId());
                sd.setDeptId(deptid);
                list.add(sd);
            }
            xmScholarshipDeptMapper.batchScholarshipDept(list);
        }
    }
    private void insertXmScholarshipScholarshipType(XmScholarship xmScholarship)
    {
        Long[] types = xmScholarship.getTypeIds();
        if(StringUtils.isNotEmpty(types))
        {
            ArrayList<XmScholarshipScholarshiptype> list = new ArrayList<>(types.length);
            for(Long type : types)
            {
                XmScholarshipScholarshiptype sst = new XmScholarshipScholarshiptype();
                sst.setScholarshipId(xmScholarship.getScholarshipId());
                sst.setScholarshipTypeId(type);
                list.add(sst);
            }
            xmScholarshipScholarshiptypeMapper.batchinsert(list);
        }
    }

    /**
     * 修改奖学金信息
     * 
     * @param xmScholarship 奖学金信息
     * @return 结果
     */
    @Override
    public int updateXmScholarship(XmScholarship xmScholarship)
    {
        Long scholarshipId = xmScholarship.getScholarshipId();
        //删除奖学金与奖学金类型关联后新增
        xmScholarshipScholarshiptypeMapper.deleteXmScholarshipScholarshiptypeByScholarshipId(scholarshipId);
        insertXmScholarshipScholarshipType(xmScholarship);
        //删除奖学金与部门关联后新增
        xmScholarshipDeptMapper.deleteXmScholarshipDeptByScholarshipId(scholarshipId);
        insertXmScholarshipDept(xmScholarship);
        xmScholarship.setConditionContent(JSON.toJSONString(xmScholarship.getConditions()));
        return xmScholarshipMapper.updateXmScholarship(xmScholarship);
    }

    /**
     * 批量删除奖学金信息
     * 
     * @param scholarshipIds 需要删除的奖学金信息主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipByScholarshipIds(Long[] scholarshipIds)
    {
        for(Long scholarshipId : scholarshipIds)
        {
            //删除奖学金与奖学金类型关联后新增
            xmScholarshipScholarshiptypeMapper.deleteXmScholarshipScholarshiptypeByScholarshipTypeId(scholarshipId);
            //删除奖学金与部门关联后新增
            xmScholarshipDeptMapper.deleteXmScholarshipDeptByScholarshipId(scholarshipId);
        }
        return xmScholarshipMapper.deleteXmScholarshipByScholarshipIds(scholarshipIds);
    }

    /**
     * 删除奖学金信息信息
     * 
     * @param scholarshipId 奖学金信息主键
     * @return 结果
     */
    @Override
    public int deleteXmScholarshipByScholarshipId(Long scholarshipId)
    {
        //删除奖学金与奖学金类型关联后新增
        xmScholarshipScholarshiptypeMapper.deleteXmScholarshipScholarshiptypeByScholarshipTypeId(scholarshipId);
        //删除奖学金与部门关联后新增
        xmScholarshipDeptMapper.deleteXmScholarshipDeptByScholarshipId(scholarshipId);
        return xmScholarshipMapper.deleteXmScholarshipByScholarshipId(scholarshipId);
    }
}
