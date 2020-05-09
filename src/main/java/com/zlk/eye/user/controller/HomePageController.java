package com.zlk.eye.user.controller;

import com.zlk.eye.user.entity.News;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName： HomePageController
 * @Description： 首页
 * @Author： yzh
 * @Date： 2020/5/1 23:32
 */
@Controller
@RequestMapping(value = "/homePageController")
public class HomePageController {
    @Autowired(required = false)
    private HomePageService homePageService;

    /**
     * 根据用户ID查找新闻通知
     * @return String
     */
    @RequestMapping(value = "/toIndex")
    public ModelAndView toIndex(HttpServletRequest httpServletRequest){
        ModelAndView mv =new ModelAndView();
        Users user = (Users) httpServletRequest.getSession().getAttribute("user");
        if (user != null){
            String nUserId = user.getUserId();
            List<News> newsList = homePageService.findNewsById(nUserId);
            mv.addObject("newsList",newsList);
            mv.addObject("nUserId",nUserId);
            mv.setViewName("homePage");
            return mv;
        }
        mv.setViewName("homePage");
        return mv;
    }
}
