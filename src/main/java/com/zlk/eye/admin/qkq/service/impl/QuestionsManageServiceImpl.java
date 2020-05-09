package com.zlk.eye.admin.qkq.service.impl;

import com.zlk.eye.admin.qkq.entity.Questions;
import com.zlk.eye.admin.qkq.mapper.QuestionsManageMapper;
import com.zlk.eye.admin.qkq.service.QuestionsManageService;
import com.zlk.eye.admin.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: QuestionsManageServiceImpl
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/8 12:18
 */
@Service
public class QuestionsManageServiceImpl implements QuestionsManageService {

    @Autowired
    private QuestionsManageMapper questionsManageMapper;

    @Override
    public List<Questions> findQuestionsByAdmin(Pagination pagination) {
        Integer page=pagination.getPage();
        Integer limit=pagination.getLimit();
        Integer startPage=(page-1)*limit;
        pagination.setStartPage(startPage);
        return questionsManageMapper.findQuestionsByAdmin(pagination);
    }

    @Override
    public Integer findCountByAdmin(Pagination pagination) {
        return questionsManageMapper.findCountByAdmin(pagination);
    }

    @Override
    public Integer deleteQuestionsByQuestionId(String questionId) {
        return questionsManageMapper.deleteQuestionsByQuestionId(questionId);
    }

    @Override
    public Integer addQuestions(Questions questions) {
        return questionsManageMapper.addQuestions(questions);
    }

    @Override
    public Integer updateContentByTextArea(Questions questions) {
        return questionsManageMapper.updateContentByTextArea(questions);
    }

    @Override
    public Integer updateAnswerByTextArea(Questions questions) {
        return questionsManageMapper.updateAnswerByTextArea(questions);
    }
}
