package com.zlk.eye.admin.qkq.controller;

import com.zlk.eye.admin.qkq.entity.Questions;
import com.zlk.eye.admin.qkq.service.QuestionsManageService;
import com.zlk.eye.admin.util.Pagination;
import com.zlk.eye.admin.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: QuestionsManageController
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/8 12:23
 */
@Controller
@RequestMapping(value = "/adminQuestions")
public class QuestionsManageController {

    @Autowired
    private QuestionsManageService questionsManageService;

    @RequestMapping(value = "/toQuestionsManage")
    public ModelAndView toQuestionManager(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("questionsManage");
        return mv;
    }

    @RequestMapping(value = "/questionsManage")
    @ResponseBody
    public Map<String, Object> list(Pagination pagination) {
        List<Questions> questionsList=questionsManageService.findQuestionsByAdmin(pagination);
        Integer count=questionsManageService.findCountByAdmin(pagination);
        Map<String, Object> map=new HashMap<>();
        map.put("code","0");
        map.put("count",count);
        map.put("data",questionsList);
        return map;
    }

    @RequestMapping(value = "/deleteQuestions")
    @ResponseBody
    public Map<String, Object> delete(String questionId) {
        Integer flag=questionsManageService.deleteQuestionsByQuestionId(questionId);
        Map<String, Object> map=new HashMap<>();
        if(flag == 1) {
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/addQuestions")
    @ResponseBody
    public ModelAndView add(Questions questions) {
        ModelAndView mv=new ModelAndView();
        questions.setQuestionId(UUIDUtils.getId());
        questions.setCreateTime(new Date());
        Integer flag=questionsManageService.addQuestions(questions);
        if(flag == 1) {
            mv.addObject("flag","true");
            mv.addObject("msg","新增成功");
            mv.setViewName("questionsManage");
            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","新增失败");
            mv.setViewName("questionsManage");
            return mv;
        }
    }

    @RequestMapping(value = "/updateContent")
    @ResponseBody
    public ModelAndView updateContent(Questions questions) {
        ModelAndView mv=new ModelAndView();
        Integer flag=questionsManageService.updateContentByTextArea(questions);
        if(flag == 1) {
            mv.setViewName("questionsManage");
            return mv;
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/updateAnswer")
    @ResponseBody
    public ModelAndView updateAnswer(Questions questions) {
        ModelAndView mv=new ModelAndView();
        Integer flag=questionsManageService.updateAnswerByTextArea(questions);
        if(flag == 1) {
            mv.setViewName("questionsManage");
            return mv;
        }else {
            return null;
        }
    }
}
