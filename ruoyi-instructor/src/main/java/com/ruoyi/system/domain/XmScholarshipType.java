package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖学金类型对象 xm_scholarship_type
 * 
 * @author xm
 * @date 2023-03-03
 */
public class XmScholarshipType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖学金类型ID */
    private Long scholarshipTypeId;

    /** 奖学金类型名称 */
    @Excel(name = "奖学金类型名称")
    private String scholarshipTypeName;

    public void setScholarshipTypeId(Long scholarshipTypeId) 
    {
        this.scholarshipTypeId = scholarshipTypeId;
    }

    public Long getScholarshipTypeId() 
    {
        return scholarshipTypeId;
    }
    public void setScholarshipTypeName(String scholarshipTypeName) 
    {
        this.scholarshipTypeName = scholarshipTypeName;
    }

    public String getScholarshipTypeName() 
    {
        return scholarshipTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scholarshipTypeId", getScholarshipTypeId())
            .append("scholarshipTypeName", getScholarshipTypeName())
            .toString();
    }
}
