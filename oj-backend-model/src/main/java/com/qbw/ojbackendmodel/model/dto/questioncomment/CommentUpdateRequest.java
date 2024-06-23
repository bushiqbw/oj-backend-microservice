package com.qbw.ojbackendmodel.model.dto.questioncomment;

import com.qbw.ojbackendmodel.model.entity.QuestionComment;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 15712
 */
@Data
public class CommentUpdateRequest implements Serializable {

    /**
     * 当前评论
     */
    private QuestionComment currentComment;
//    private Long id;
//
//    /**
//     * 点赞数
//     */
//    private Integer likeCount;

}
