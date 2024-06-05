package com.qbw.ojbackendjudgeservice.judge;


import com.qbw.ojbackendmodel.model.entity.QuestionSubmit;

public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
