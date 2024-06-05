package com.qbw.ojbackendjudgeservice.judge.codesandbox.impl;


import com.qbw.ojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.qbw.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.qbw.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.qbw.ojbackendmodel.model.codesandbox.JudgeInfo;
import com.qbw.ojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.qbw.ojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;

    }
}
