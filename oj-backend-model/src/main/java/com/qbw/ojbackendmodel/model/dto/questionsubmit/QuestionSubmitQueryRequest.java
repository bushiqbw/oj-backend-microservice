package com.qbw.ojbackendmodel.model.dto.questionsubmit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.qbw.ojbackendcommon.common.PageRequest;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/liqbw">qbw</a>
  
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;
    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 用户代码
     */
    private Long userId;

    /**
     * 题目 id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}