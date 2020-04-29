package com.zlk.eye.admin.lfx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName Questions
 * @Description: 常见问题Controller
 * @Author lufengxiang
 * Date 2020/4/29 9:00
 **/
@Controller
@RequestMapping(value = "/adminQuestion")
public class QuestionsController {

    @RequestMapping(value = "/toQuestionManager")
    public ModelAndView toQuestionManager(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("questionManager");
        return mv;
    }

}
