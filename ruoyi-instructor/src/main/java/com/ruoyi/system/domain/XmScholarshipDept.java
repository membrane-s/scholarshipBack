package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖学金与部门类型关联对象 xm_scholarship_dept
 * 
 * @author xm
 * @date 2023-03-09
 */
public class XmScholarshipDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖学金id */
    private Long scholarshipId;

    /** 部门id */
    private Long deptId;

    public void setScholarshipId(Long scholarshipId) 
    {
        this.scholarshipId = scholarshipId;
    }

    public Long getScholarshipId() 
    {
        return scholarshipId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scholarshipId", getScholarshipId())
            .append("deptId", getDeptId())
            .toString();
    }
}
