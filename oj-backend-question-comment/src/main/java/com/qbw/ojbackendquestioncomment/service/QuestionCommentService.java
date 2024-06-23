package com.qbw.ojbackendquestioncomment.service;


import com.baomidou.mybatisplus.extension.service.IService;

import com.qbw.ojbackendmodel.model.entity.QuestionComment;
import com.qbw.ojbackendmodel.model.entity.User;
import com.qbw.ojbackendmodel.model.vo.QuestionCommentVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
* @author 10362
* @description 针对表【question_comment(评论)】的数据库操作Service
* @createDate 2024-06-13 17:24:53
*/
public interface QuestionCommentService extends IService<QuestionComment> {

    /**
     * 根据问题id获取到所有的评论列表
     * @param questionId 问题id
     * @return
     */
    List<QuestionCommentVO> getAllCommentList(@Param("questionId") long questionId);

    /**
     * 根据评论id删除一条记录[是本人评论的记录]
     * @param comment 评论对象中包含回复人的id也包含被回复人的id
     * @return
     */
    int deleteCommentById(QuestionComment comment, User loginUser);

    /**
     * 添加一条评论或回复记录
     * @param current 当前提交的新comment对象
     * @param  parent  当前被点击回复的对象[评论时不需要，回复需要根据他进行判断]
     * @return
     */
    boolean addComment(QuestionComment current,QuestionComment parent,User loginUser);


    /**
     * 修改点赞数量
     * @param questionComment 评论对象
     * @return
     */
    boolean updateLikeCount(QuestionComment questionComment);

}
