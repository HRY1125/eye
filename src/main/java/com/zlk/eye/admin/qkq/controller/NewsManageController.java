package com.zlk.eye.admin.qkq.controller;

import com.zlk.eye.admin.qkq.entity.News;
import com.zlk.eye.admin.qkq.service.NewsManageService;
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
 * @program: NewsManageController
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/6 13:51
 */
@Controller
@RequestMapping(value = "/adminNews")
public class NewsManageController {

    @Autowired
    private NewsManageService newsManageService;

    @RequestMapping(value = "/toNewsManage")
    public ModelAndView toQuestionManager(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("newsManage");
        return mv;
    }

    @RequestMapping(value = "/newsManage")
    @ResponseBody
    public Map<String, Object> list(Pagination pagination) {
        List<News> newsList=newsManageService.findNewsByAdmin(pagination);
        Integer count=newsManageService.findCountByAdmin(pagination);
        Map<String, Object> map=new HashMap<>();
        map.put("code","0");
        map.put("count",count);
        map.put("data",newsList);
        return map;
    }

    @RequestMapping(value = "deleteNews")
    @ResponseBody
    public Map<String, Object> delete(String newsId) {
        Integer flag=newsManageService.deleteNewsByNewsId(newsId);
        Map<String, Object> map=new HashMap<>();
        if(flag == 1) {
            map.put("msg","删除成功");
        }else {
            map.put("msg","删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/addNews")
    @ResponseBody
    public ModelAndView add(News news) {
        ModelAndView mv=new ModelAndView();
        news.setNewsId(UUIDUtils.getId());
        news.setCreateTime(new Date());
        news.setApproval(1);
        Integer flag=newsManageService.addNews(news);
        if(flag == 1) {
            mv.addObject("flag","true");
            mv.addObject("msg","新增成功");
            mv.setViewName("newsManage");
            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","新增失败");
            mv.setViewName("newsManage");
            return mv;
        }
    }

    @RequestMapping(value = "/updateNews")
    @ResponseBody
    public ModelAndView update(News news) {
        ModelAndView mv=new ModelAndView();
        Integer flag=newsManageService.updateNewsByNewsId(news);
        if(flag == 1) {
            mv.addObject("flag","true");
            mv.addObject("msg","修改成功");
            mv.setViewName("newsManage");
            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","修改失败");
            mv.setViewName("newsManage");
            return mv;
        }
    }

    @RequestMapping(value = "/textAreaUpdate")
    @ResponseBody
    public ModelAndView textAreaUpdate(News news) {
        ModelAndView mv=new ModelAndView();
        Integer flag=newsManageService.updateContentByTextArea(news);
        if(flag == 1) {
            mv.setViewName("newsManage");
            return mv;
        }else {
            return null;
        }
    }
}
