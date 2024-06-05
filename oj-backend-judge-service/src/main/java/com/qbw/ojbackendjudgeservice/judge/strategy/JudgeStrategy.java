package com.qbw.ojbackendjudgeservice.judge.strategy;


import com.qbw.ojbackendmodel.model.codesandbox.JudgeInfo;

/**
 * 判题策略接口
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}

