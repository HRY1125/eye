package com.zlk.eye.diagnose.controller;

import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        ModelAndView mv = new ModelAndView();
        mv.setViewName("diagnose/diagnoseList");
        return mv;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectAll(HttpServletRequest request,Integer page, Integer limit) throws Exception{
//        String userId = "111";
//        String userId = null;
        String userId = (String) request.getSession().getAttribute("userId");
//        String docterId = null;
//        String docterId = "111";
        String docterId = (String) request.getSession().getAttribute("docterId");
        Diagnose diagnose = new Diagnose();
        diagnose.setUserId(userId);
        diagnose.setDoctorId(docterId);
//        page=1;
//        limit = 5;
        List<Diagnose> diagnoseList = diagnoseService.selectByID(diagnose,page,limit);
        Integer count = diagnoseService.selectCountById(diagnose);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",diagnoseList);
        return map;
    }

    @RequestMapping(value = "/deleteDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteDiagnose(int diagnoseId) throws Exception{
        String message = diagnoseService.deleteDiagnose(diagnoseId);
        Map<String,Object> map = new HashMap<>();
        return map;
    }
}
