package com.zlk.eye.admin.lfx.controller;

import com.zlk.eye.admin.lfx.entity.Admin;
import com.zlk.eye.admin.lfx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Login
 * @Description: 管理员登陆controller
 * @Author lufengxiang
 * Date 2020/4/29 18:58
 **/
@Controller
@RequestMapping(value = "/loginController")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminLogin");
        return mv;
    }

    /**
     * @Author lufengxiang
     * @Description //TODO 登陆页面点击登陆
     * @Date 17:31 2019/11/18
     * @Param [request, admin]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, Admin admin) {
        ModelAndView mv = new ModelAndView();
        Admin findAdmin = loginService.findAdminByAdminNameAndAdminPwd(admin.getAdminName(), admin.getAdminPwd());
        if ((findAdmin==null)){
            mv.setViewName("adminLogin");
            mv.addObject("flag",true);
            mv.addObject("error","用户名或密码错误");
            return mv;
        }else {
            mv.setViewName("adminSuccess");
            return mv;
        }
    }

    @RequestMapping(value = "/toSuccess")
    public ModelAndView toSuccess(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminSuccess");
        return mv;
    }
}
