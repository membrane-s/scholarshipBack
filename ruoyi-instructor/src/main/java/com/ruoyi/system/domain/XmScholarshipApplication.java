package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖学金申请对象 xm_scholarship_application
 * 
 * @author xm
 * @date 2023-03-03
 */
public class XmScholarshipApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID */
    private Long applicationId;

    /** 申请人 */
    @Excel(name = "申请人")
    private String userName;

    /** 申请奖金 */
    @Excel(name = "奖学金")
    private String scholarshipName;

    /** 用户ID */
    private Long userId;

    /** 奖学金ID */

    private Long scholarshipId;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationDate;

    /** 奖金申请审核ID */
    @Excel(name = "奖金申请审核ID")
    private Long reviewId;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String status;

    /** 申请附件 */
    @Excel(name = "申请附件")
    private String adjunct;

    /** 申请条件及权重 */
    @Excel(name = "申请条件及权重")
    private String conditionContent;

    /** 是否是特殊申请 */
    @Excel(name = "申请类型")
    private Long special;

    /** 特殊申请原因 */
    @Excel(name = "特殊申请原因")
    private String specialReason;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setScholarshipId(Long scholarshipId) 
    {
        this.scholarshipId = scholarshipId;
    }

    public Long getScholarshipId() 
    {
        return scholarshipId;
    }
    public void setApplicationDate(Date applicationDate) 
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() 
    {
        return applicationDate;
    }
    public void setReviewId(Long reviewId) 
    {
        this.reviewId = reviewId;
    }

    public Long getReviewId() 
    {
        return reviewId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAdjunct(String adjunct) 
    {
        this.adjunct = adjunct;
    }

    public String getAdjunct() 
    {
        return adjunct;
    }
    public void setConditionContent(String conditionContent) 
    {
        this.conditionContent = conditionContent;
    }

    public String getConditionContent() 
    {
        return conditionContent;
    }
    public void setSpecial(Long special) 
    {
        this.special = special;
    }

    public Long getSpecial() 
    {
        return special;
    }
    public void setSpecialReason(String specialReason) 
    {
        this.specialReason = specialReason;
    }

    public String getSpecialReason() 
    {
        return specialReason;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getScholarshipName()
    {
        return scholarshipName;
    }
    public void setScholarshipName(String scholarshipName)
    {
        this.scholarshipName = scholarshipName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicationId", getApplicationId())
            .append("userId", getUserId())
            .append("scholarshipId", getScholarshipId())
            .append("applicationDate", getApplicationDate())
            .append("reviewId", getReviewId())
            .append("status", getStatus())
            .append("adjunct", getAdjunct())
            .append("conditionContent", getConditionContent())
            .append("special", getSpecial())
            .append("specialReason", getSpecialReason())
            .toString();
    }
}
