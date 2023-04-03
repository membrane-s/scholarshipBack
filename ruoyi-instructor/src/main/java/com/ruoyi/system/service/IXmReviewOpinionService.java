package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmReviewOpinion;

/**
 * 审核意见Service接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface IXmReviewOpinionService 
{
    /**
     * 查询审核意见
     * 
     * @param reviewId 审核意见主键
     * @return 审核意见
     */
    public XmReviewOpinion selectXmReviewOpinionByReviewId(Long reviewId);

    /**
     * 查询审核意见列表
     * 
     * @param xmReviewOpinion 审核意见
     * @return 审核意见集合
     */
    public List<XmReviewOpinion> selectXmReviewOpinionList(XmReviewOpinion xmReviewOpinion);

    /**
     * 新增审核意见
     * 
     * @param xmReviewOpinion 审核意见
     * @return 结果
     */
    public int insertXmReviewOpinion(XmReviewOpinion xmReviewOpinion);

    /**
     * 修改审核意见
     * 
     * @param xmReviewOpinion 审核意见
     * @return 结果
     */
    public int updateXmReviewOpinion(XmReviewOpinion xmReviewOpinion);

    /**
     * 批量删除审核意见
     * 
     * @param reviewIds 需要删除的审核意见主键集合
     * @return 结果
     */
    public int deleteXmReviewOpinionByReviewIds(Long[] reviewIds);

    /**
     * 删除审核意见信息
     * 
     * @param reviewId 审核意见主键
     * @return 结果
     */
    public int deleteXmReviewOpinionByReviewId(Long reviewId);
}
