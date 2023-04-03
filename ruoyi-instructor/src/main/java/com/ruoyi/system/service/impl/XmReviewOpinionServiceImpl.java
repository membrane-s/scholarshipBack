package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmReviewOpinionMapper;
import com.ruoyi.system.domain.XmReviewOpinion;
import com.ruoyi.system.service.IXmReviewOpinionService;

/**
 * 审核意见Service业务层处理
 * 
 * @author xm
 * @date 2023-03-03
 */
@Service
public class XmReviewOpinionServiceImpl implements IXmReviewOpinionService 
{
    @Autowired
    private XmReviewOpinionMapper xmReviewOpinionMapper;

    /**
     * 查询审核意见
     * 
     * @param reviewId 审核意见主键
     * @return 审核意见
     */
    @Override
    public XmReviewOpinion selectXmReviewOpinionByReviewId(Long reviewId)
    {
        return xmReviewOpinionMapper.selectXmReviewOpinionByReviewId(reviewId);
    }

    /**
     * 查询审核意见列表
     * 
     * @param xmReviewOpinion 审核意见
     * @return 审核意见
     */
    @Override
    public List<XmReviewOpinion> selectXmReviewOpinionList(XmReviewOpinion xmReviewOpinion)
    {
        return xmReviewOpinionMapper.selectXmReviewOpinionList(xmReviewOpinion);
    }

    /**
     * 新增审核意见
     * 
     * @param xmReviewOpinion 审核意见
     * @return 结果
     */
    @Override
    public int insertXmReviewOpinion(XmReviewOpinion xmReviewOpinion)
    {
        return xmReviewOpinionMapper.insertXmReviewOpinion(xmReviewOpinion);
    }

    /**
     * 修改审核意见
     * 
     * @param xmReviewOpinion 审核意见
     * @return 结果
     */
    @Override
    public int updateXmReviewOpinion(XmReviewOpinion xmReviewOpinion)
    {
        return xmReviewOpinionMapper.updateXmReviewOpinion(xmReviewOpinion);
    }

    /**
     * 批量删除审核意见
     * 
     * @param reviewIds 需要删除的审核意见主键
     * @return 结果
     */
    @Override
    public int deleteXmReviewOpinionByReviewIds(Long[] reviewIds)
    {
        return xmReviewOpinionMapper.deleteXmReviewOpinionByReviewIds(reviewIds);
    }

    /**
     * 删除审核意见信息
     * 
     * @param reviewId 审核意见主键
     * @return 结果
     */
    @Override
    public int deleteXmReviewOpinionByReviewId(Long reviewId)
    {
        return xmReviewOpinionMapper.deleteXmReviewOpinionByReviewId(reviewId);
    }
}
