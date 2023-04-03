package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 申请条件对象 xm_condition
 * 
 * @author xm
 * @date 2023-03-03
 */
public class XmCondition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请条件ID */
    private Long conditionId;

    /** 申请条件描述 */
    @Excel(name = "申请条件描述")
    private String condition;

    /** 必填条件 */
    @Excel(name = "必填条件")
    private Integer isNecessity;

    private boolean bindCondition;

    private Integer weight;

    public void setConditionId(Long conditionId)
    {
        this.conditionId = conditionId;
    }

    public Long getConditionId() 
    {
        return conditionId;
    }
    public void setCondition(String condition) 
    {
        this.condition = condition;
    }

    public String getCondition() 
    {
        return condition;
    }
    public void setIsNecessity(Integer isNecessity)
    {
        this.isNecessity = isNecessity;
    }

    public Integer getIsNecessity()
    {
        return isNecessity;
    }
    public Integer getWeight()
    {
        return weight;
    }
    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
    public boolean isBindCondition()
    {
        return bindCondition;
    }
    public void setBindCondition(boolean bindCondition)
    {
        this.bindCondition = bindCondition;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("conditionId", getConditionId())
            .append("condition", getCondition())
            .append("isNecessity", getIsNecessity())
            .toString();
    }
}
