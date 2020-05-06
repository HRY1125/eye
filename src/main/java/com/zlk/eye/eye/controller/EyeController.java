package com.zlk.eye.eye.controller;

import com.zlk.eye.eye.entity.Eye;
import com.zlk.eye.eye.service.EyeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/4/29 11:31
 */
@Controller
@RequestMapping("eye")
public class EyeController {
    /**
     * 服务对象
     */
    @Resource
    private EyeService eyeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Eye selectOne(Integer id) {
        return this.eyeService.queryById(id);
    }
    /**
     * 通过主键查询数据
     *
     * @return 数据
     */
    @RequestMapping("queryAll")
    @ResponseBody
    public Eye queryAll() {
        Eye e = new Eye();
        e.setUserId("111");
        e.setDate(new Date());
        return eyeService.queryAllByEye(e);
    }

    /**
     * 跳转计时页面
     * @return
     */
    @RequestMapping("exercisetime")
    public String exercisetime() {
        return "exercisetime";
    }

    /**
     * 添加计时的时间
     * @param s
     * @return
     */
    @RequestMapping("updateye")
    @ResponseBody
    public Eye updateye(Integer s){
        long current=System.currentTimeMillis();//当前时间毫秒数
        //今天零点零分零秒的毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        String userId = "1111";
        Eye e =new Eye();
        e.setUserId(userId);
        e.setDate(new Date(zero));
        Eye ey = eyeService.queryAllByEye(e);
        if(ey!=null){
            ey.setEyeTime(ey.getEyeTime()+s);
            return eyeService.update(ey);
        }
        e.setEyeTime(s);
        return eyeService.insert(e);
    }
}
