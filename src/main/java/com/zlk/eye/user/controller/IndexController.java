package com.zlk.eye.user.controller;

import com.zlk.eye.user.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName： IndexController
 * @Description： Index controller类
 * @Author： wy
 * @Date： 2020/4/28 10:57
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 跳转至登录页面
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "firstpage";
    }

}
