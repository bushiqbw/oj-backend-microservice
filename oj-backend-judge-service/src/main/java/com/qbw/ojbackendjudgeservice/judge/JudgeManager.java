package com.qbw.ojbackendjudgeservice.judge;

import com.qbw.ojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.qbw.ojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.qbw.ojbackendjudgeservice.judge.strategy.JudgeContext;
import com.qbw.ojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.qbw.ojbackendmodel.model.codesandbox.JudgeInfo;
import com.qbw.ojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理，根据不同策略选择不同的实现类
 */
@Service
public class JudgeManager {

    /**
     * 执行不同策略的判断模式
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
