package com.zlk.eye.admin.qkq.service;

import com.zlk.eye.admin.qkq.entity.Questions;
import com.zlk.eye.admin.util.Pagination;

import java.util.List;

/**
 * @program: QuestionsManageService
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/8 11:52
 */
public interface QuestionsManageService {
    List<Questions> findQuestionsByAdmin(Pagination pagination);
    Integer findCountByAdmin(Pagination pagination);
    Integer deleteQuestionsByQuestionId(String questionId);
    Integer addQuestions(Questions questions);
    Integer updateContentByTextArea(Questions questions);
    Integer updateAnswerByTextArea(Questions questions);
}
