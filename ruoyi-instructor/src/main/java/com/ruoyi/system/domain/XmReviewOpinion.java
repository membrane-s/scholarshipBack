package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审核意见对象 xm_review_opinion
 * 
 * @author xm
 * @date 2023-03-03
 */
public class XmReviewOpinion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审核意见ID */
    private Long reviewId;

    /** 审核人 */
    @Excel(name = "审核人")
    private String userName;

    /** 审核意见ID */
    @Excel(name = "奖学金")
    private String scholarshipName;

    /** 审核人ID */
    private Long reviewerId;

    /** 审核日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewDate;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String opinion;

    /** 审核结果 */
    @Excel(name = "审核结果")
    private String reviewResult;

    /** 申请ID */
    @Excel(name = "申请ID")
    private Long applicationId;

    public void setReviewId(Long reviewId) 
    {
        this.reviewId = reviewId;
    }

    public Long getReviewId() 
    {
        return reviewId;
    }
    public void setReviewerId(Long reviewerId) 
    {
        this.reviewerId = reviewerId;
    }

    public Long getReviewerId() 
    {
        return reviewerId;
    }
    public void setReviewDate(Date reviewDate) 
    {
        this.reviewDate = reviewDate;
    }

    public Date getReviewDate() 
    {
        return reviewDate;
    }
    public void setOpinion(String opinion) 
    {
        this.opinion = opinion;
    }

    public String getOpinion() 
    {
        return opinion;
    }
    public void setReviewResult(String reviewResult) 
    {
        this.reviewResult = reviewResult;
    }

    public String getReviewResult() 
    {
        return reviewResult;
    }
    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
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
            .append("reviewId", getReviewId())
            .append("reviewerId", getReviewerId())
            .append("reviewDate", getReviewDate())
            .append("opinion", getOpinion())
            .append("reviewResult", getReviewResult())
            .append("applicationId", getApplicationId())
            .toString();
    }
}
