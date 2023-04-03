package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖学金信息对象 xm_scholarship
 * 
 * @author ruoyi
 * @date 2023-03-07
 */
public class XmScholarship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖学金ID */
    private Long scholarshipId;

    /** 创建用户ID */
    private Long createtorId;

    /** 奖学金名称 */
    @Excel(name = "奖学金名称")
    private String scholarshipName;

    /** 奖学金金额 */
    @Excel(name = "奖学金金额")
    private BigDecimal amount;

    private Long deptId;

    private List<SysDept> depts;

    private List<XmCondition> conditions;

    private List<XmScholarshipType> types;

    /** 部门组 */
    private Long[] deptIds;

    /** 类型组 */
    private Long[] typeIds;
    public Long[] getDeptIds()
    {
        return deptIds;
    }
    public void setDeptIds(Long[] deptIds)
    {
        this.deptIds = deptIds;
    }
    public Long[] getTypeIds()
    {
        return typeIds;
    }
    public void setTypeIds(Long[] typeIds)
    {
        this.typeIds = typeIds;
    }
    public List<SysDept> getDepts()
    {
        return depts;
    }
    public void setDepts(List<SysDept> depts)
    {
        this.depts = depts;
    }
    public List<XmScholarshipType> getTypes()
    {
        return types;
    }
    public void setTypes(List<XmScholarshipType> types)
    {
        this.types = types;
    }
    /** 申请条件及权重集合 */
    private String conditionContent;

    /** 修改者id */
    private Long modifier;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    public void setScholarshipId(Long scholarshipId) 
    {
        this.scholarshipId = scholarshipId;
    }

    public Long getScholarshipId() 
    {
        return scholarshipId;
    }
    public void setCreatetorId(Long createtorId) 
    {
        this.createtorId = createtorId;
    }

    public Long getCreatetorId() 
    {
        return createtorId;
    }
    public void setScholarshipName(String scholarshipName)
    {
        this.scholarshipName = scholarshipName;
    }

    public String getScholarshipName()
    {
        return scholarshipName;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setConditionContent(String conditionContent) 
    {
        this.conditionContent = conditionContent;
    }

    public String getConditionContent() 
    {
        return conditionContent;
    }
    public void setModifier(Long modifier) 
    {
        this.modifier = modifier;
    }

    public Long getModifier() 
    {
        return modifier;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }
    public List<XmCondition> getConditions()
    {
        return conditions;
    }
    public void setConditions(List<XmCondition> conditions)
    {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scholarshipId", getScholarshipId())
            .append("createtorId", getCreatetorId())
            .append("scholarshipName", getScholarshipName())
            .append("amount", getAmount())
            .append("conditionContent", getConditionContent())
            .append("createTime", getCreateTime())
            .append("modifier", getModifier())
            .append("modifyTime", getModifyTime())
            .toString();
    }
}
