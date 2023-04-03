package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XmReviewOpinion;

/**
 * 审核意见Mapper接口
 * 
 * @author xm
 * @date 2023-03-03
 */
public interface XmReviewOpinionMapper 
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
     * 删除审核意见
     * 
     * @param reviewId 审核意见主键
     * @return 结果
     */
    public int deleteXmReviewOpinionByReviewId(Long reviewId);

    /**
     * 批量删除审核意见
     * 
     * @param reviewIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmReviewOpinionByReviewIds(Long[] reviewIds);
}
