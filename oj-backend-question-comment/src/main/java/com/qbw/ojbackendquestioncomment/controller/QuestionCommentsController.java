package com.qbw.ojbackendquestioncomment.controller;


import com.qbw.ojbackendcommon.common.BaseResponse;
import com.qbw.ojbackendcommon.common.ErrorCode;
import com.qbw.ojbackendcommon.common.ResultUtils;
import com.qbw.ojbackendcommon.exception.BusinessException;
import com.qbw.ojbackendmodel.model.dto.questioncomment.CommentAddRequest;
import com.qbw.ojbackendmodel.model.entity.QuestionComment;
import com.qbw.ojbackendmodel.model.entity.User;
import com.qbw.ojbackendmodel.model.vo.QuestionCommentVO;
import com.qbw.ojbackendquestioncomment.service.QuestionCommentService;
import com.qbw.ojbackenduserservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 帖子接口
 *
 * @author <a href="https://github.com/liyupi">程序员小新</a>
 */
@RestController
@RequestMapping("/")
@Slf4j
public class QuestionCommentsController {


    @Resource
    private UserService userService;

    @Resource
    private QuestionCommentService questionCommentService;

    // region 增删改查

    /**
     * 获取该问题的所有评论
     *
     * @param id
     * @return
     */
    @GetMapping("/getCommentList")
    public BaseResponse<List<QuestionCommentVO>> getCommentList(long id) {
        return ResultUtils.success(questionCommentService.getAllCommentList(id));
    }


    @PostMapping("/addComment")
    public BaseResponse<Boolean> addQuestionComment(@RequestBody QuestionComment currentComment, @RequestBody(required = false) QuestionComment parent, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        boolean b = questionCommentService.addComment(currentComment, parent, loginUser);
        return ResultUtils.success(b);
    }

    @PostMapping("/wrap/addComment")
    public BaseResponse<Boolean> addQuestionCommentWrap(@RequestBody CommentAddRequest commentAddRequest, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        QuestionComment currentComment = commentAddRequest.getCurrentComment();
        QuestionComment parent = commentAddRequest.getParentComment();
        boolean b = questionCommentService.addComment(currentComment, parent, loginUser);
        return ResultUtils.success(b);
    }


    /**
     * 删除
     *
     * @param currentComment
     * @return
     */
    @PostMapping("/deleteComment")
    public BaseResponse<Integer> deleteQuestion(@RequestBody QuestionComment currentComment,HttpServletRequest request) {
        if (currentComment == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "不能删除空评论");
        }
        User loginUser = userService.getLoginUser(request);
        int updateCount = questionCommentService.deleteCommentById(currentComment, loginUser);
        return ResultUtils.success(updateCount);
    }

    /**
     * 更新（仅管理员）
     *
     * @param currentComment
     * @return
     */
    @PostMapping("/updateLikeCount")
    public BaseResponse<Boolean> updateQuestionComment(@RequestBody QuestionComment currentComment) {
        boolean updateLikeCount = questionCommentService.updateLikeCount(currentComment);
        return ResultUtils.success(updateLikeCount);
    }


}
