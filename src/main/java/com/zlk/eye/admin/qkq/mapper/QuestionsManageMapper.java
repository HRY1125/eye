package com.zlk.eye.admin.qkq.mapper;

import com.zlk.eye.admin.qkq.entity.Questions;
import com.zlk.eye.admin.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: QuestionsManageMapper
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/8 12:00
 */
@Mapper
public interface QuestionsManageMapper {
    List<Questions> findQuestionsByAdmin(Pagination pagination);
    Integer findCountByAdmin(Pagination pagination);
    Integer deleteQuestionsByQuestionId(String questionId);
    Integer addQuestions(Questions questions);
    Integer updateContentByTextArea(Questions questions);
    Integer updateAnswerByTextArea(Questions questions);
}
