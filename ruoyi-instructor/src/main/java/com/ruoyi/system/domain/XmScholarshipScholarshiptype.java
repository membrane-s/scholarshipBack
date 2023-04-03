package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖学金与奖学金类型关联对象 xm_scholarship_scholarshiptype
 * 
 * @author xm
 * @date 2023-03-03
 */
public class XmScholarshipScholarshiptype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖学金类型id */
    private Long scholarshipTypeId;

    /** 奖学金类型ID */
    @Excel(name = "奖学金类型ID")
    private Long scholarshipId;

    public void setScholarshipTypeId(Long scholarshipTypeId) 
    {
        this.scholarshipTypeId = scholarshipTypeId;
    }

    public Long getScholarshipTypeId() 
    {
        return scholarshipTypeId;
    }
    public void setScholarshipId(Long scholarshipId) 
    {
        this.scholarshipId = scholarshipId;
    }

    public Long getScholarshipId() 
    {
        return scholarshipId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scholarshipTypeId", getScholarshipTypeId())
            .append("scholarshipId", getScholarshipId())
            .toString();
    }
}
