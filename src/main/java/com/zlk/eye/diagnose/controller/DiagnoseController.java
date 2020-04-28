package com.zlk.eye.diagnose.controller;

import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.entity.Diagnose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: eye
 * @description: diagnose控制器
 * @author: zyx
 * @create: 2020-04-28 16:59
 */
@Controller
@RequestMapping(value = "/diagnose")
public class DiagnoseController {

    @Autowired
    private DiagnoseService diagnoseService;

    @RequestMapping(value = "/toDiagnoseList")
    public ModelAndView toList() throws Exception{
        List<Diagnose> diagnoseList = diagnoseService.selectAllOrderByDate();
        ModelAndView mv = new ModelAndView();
        mv.addObject("diagnoseList",diagnoseList);
        mv.setViewName("diagnose/diagnoseList");
        return mv;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectAll() throws Exception{
        List<Diagnose> diagnoseList = diagnoseService.selectAllOrderByDate();
        Integer count = diagnoseService.selectAllCount();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",diagnoseList);
        return map;
    }
}
