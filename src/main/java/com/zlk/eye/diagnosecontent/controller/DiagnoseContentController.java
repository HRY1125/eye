package com.zlk.eye.diagnosecontent.controller;

import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.diagnosecontent.service.DiagnoseContentService;
import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.entity.DiagnoseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: eye
 * @description: 诊断内容控制器
 * @author: zyx
 * @create: 2020-04-29 16:32
 */
@Controller
@RequestMapping(value = "/dContent")
public class DiagnoseContentController {

    @Autowired
    private DiagnoseContentService diagnoseContentService;
    @Autowired
    private DiagnoseService diagnoseService;

    @RequestMapping(value = "/toDiagnoseContent")
    public ModelAndView toContent(HttpServletRequest request,@RequestParam Integer diagnoseId) throws Exception{
//        String userId = (String) request.getSession().getAttribute("userId");
//        String docterId = (String) request.getSession().getAttribute("docterId");
        String userId = null;
        String docterId = "医生";
        ModelAndView mv = new ModelAndView();
//        int diagnoseId = 3;
        mv.addObject("diagnoseId",diagnoseId);
        mv.addObject("userId",userId);
        mv.addObject("docterId",docterId);
        mv.setViewName("diagnose/diagnoseContent");
        return mv;
    }

    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String,Object> edit(HttpServletRequest request,@RequestParam Integer diagnoseId) throws Exception{
        Map<String, Object> map = new HashMap<>();
//        int diagnoseId = 3;
        map.put("diagnoseId",diagnoseId);
        return map;
    }

    @RequestMapping(value = "/selectDContent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectDContent(@RequestParam Integer diagnoseId, Integer page, Integer limit) throws Exception {
        List<DiagnoseContent> diagnoseContents = diagnoseContentService.selectAllByDiagnoseId(diagnoseId, page, limit);
        Integer count = diagnoseContentService.selectCountByDiagnoseId(diagnoseId);
        Diagnose diagnose = diagnoseService.selectById(diagnoseId);
        String userId = diagnose.getUserId();
        String doctorId = diagnose.getDoctorId();
        Integer pages;
        if (count%limit==0){
            pages = count/limit;
        }else {
            pages = count/limit +1;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("diagnoseContents",diagnoseContents);
        map.put("pages",pages);
        map.put("userId",userId);
        map.put("doctorId",doctorId);
        return map;
    }

    @RequestMapping(value = "/insertDContent",method = RequestMethod.POST)
    public Map<String, Object> insertDContent(HttpServletRequest request,DiagnoseContent diagnoseContent) throws Exception{
        String userId = (String) request.getSession().getAttribute("userId");
        String docterId = (String) request.getSession().getAttribute("docterId");
        if (userId != null){
            diagnoseContent.setRole("1");
        }else if (docterId !=null){
            diagnoseContent.setRole("2");
        }
        diagnoseContent.setDate(new Date());
        Integer integer = diagnoseContentService.insertDiagnoseContent(diagnoseContent);
        Map<String, Object> map = new HashMap<>();
        return map;
    }

//    @RequestMapping(value = "/updateDContent",method = RequestMethod.POST)
//    public Map<String, Object> updateDContent(HttpServletRequest request,DiagnoseContent diagnoseContent) throws Exception{
//        String userId = (String) request.getSession().getAttribute("userId");
//        String docterId = (String) request.getSession().getAttribute("docterId");
//        if (userId != null){
//            diagnoseContent.setRole("1");
//        }else if (docterId !=null){
//            diagnoseContent.setRole("2");
//        }
//        diagnoseContent.setDate(new Date());
//        Integer integer = diagnoseContentService.updateDCByDcId(diagnoseContent);
//        Map<String, Object> map = new HashMap<>();
//        return map;
//    }

    @RequestMapping(value = "/deleteDContent",method = RequestMethod.POST)
    public Map<String, Object> deleteDContent(int dcId) throws Exception{
        Integer integer = diagnoseContentService.deleteByDcId(dcId);
        Map<String, Object> map = new HashMap<>();
        return map;
    }


}
