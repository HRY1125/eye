package com.zlk.eye.diagnosecontent.controller;

import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.diagnosecontent.service.DiagnoseContentService;
import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.entity.DiagnoseContent;
import com.zlk.eye.eye.entity.Eye;
import com.zlk.eye.eye.service.EyeService;
import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private EyeService eyeService;
    @Autowired
    private IndexService indexService;

    /**
     *  跳转至诊断具体信息页面
     *@method toContent
     *@params [request, diagnoseId]
     *@return org.springframework.web.servlet.ModelAndView
     *@author zhang
     *@time 2020/5/7  17:26
     */
    @RequestMapping(value = "/toDiagnoseContent")
    public ModelAndView toContent(HttpServletRequest request,@RequestParam Integer diagnoseId) throws Exception{
//        String userId = (String) request.getSession().getAttribute("userId");
//        String docterId = (String) request.getSession().getAttribute("docterId");
        String userId = null;
        String doctorId = "222";

        ModelAndView mv = new ModelAndView();
//        int diagnoseId = 3;
        mv.addObject("diagnoseId",diagnoseId);
        if (userId!=null){
            Users users = indexService.selectByUserId(userId);
            String userName = users.getUserName();
            mv.addObject("userName",userName);
        }
        if (doctorId!=null){
            Doctors doctors = indexService.selectByDoctorId(doctorId);
            String doctorName = doctors.getDoctorName();
            mv.addObject("doctorName",doctorName);
        }
        mv.setViewName("diagnose/diagnoseContent");
        return mv;
    }

    /**
     *  点击按钮发送数据
     *@method edit
     *@params [request, diagnoseId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/7  17:27
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String,Object> edit(HttpServletRequest request,@RequestParam Integer diagnoseId) throws Exception{
        Map<String, Object> map = new HashMap<>();
//        int diagnoseId = 3;
        map.put("diagnoseId",diagnoseId);
        return map;
    }

    /**
     *  查找全部诊断内容
     *@method selectDContent
     *@params [diagnoseId, page, limit]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/7  17:27
     */
    @RequestMapping(value = "/selectDContent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectDContent(@RequestParam Integer diagnoseId, Integer page, Integer limit) throws Exception {
        List<DiagnoseContent> diagnoseContents = diagnoseContentService.selectAllByDiagnoseId(diagnoseId, page, limit);
        Integer count = diagnoseContentService.selectCountByDiagnoseId(diagnoseId);
        Diagnose diagnose = diagnoseService.selectById(diagnoseId);
        String userId = diagnose.getUserId();
        String doctorId = diagnose.getDoctorId();
        Doctors doctors = indexService.selectByDoctorId(doctorId);
        Users users = indexService.selectByUserId(userId);
        String doctorName = doctors.getDoctorName();
        String userName = users.getUserName();
        Integer pages;
        if (count%limit==0){
            pages = count/limit;
        }else {
            pages = count/limit +1;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("diagnoseContents",diagnoseContents);
        map.put("pages",pages);
        map.put("userName",userName);
        map.put("doctorName",doctorName);
        return map;

    }

    /**
     *  增加回复信息
     *@method insertDContent
     *@params [request, diagnoseContent]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/7  17:27
     */
    @RequestMapping(value = "/insertDContent",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertDContent(HttpServletRequest request,DiagnoseContent diagnoseContent) throws Exception{
//        String userId = (String) request.getSession().getAttribute("userId");
        String docterId = (String) request.getSession().getAttribute("docterId");
        String userId = "111";
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

    /**
     *  删除回复信息
     *@method deleteDContent
     *@params [dcId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/7  17:28
     */
    @RequestMapping(value = "/deleteDContent",method = RequestMethod.POST)
    public Map<String, Object> deleteDContent(int dcId) throws Exception{
        Integer integer = diagnoseContentService.deleteByDcId(dcId);
        Map<String, Object> map = new HashMap<>();
        return map;

    }

    /**
     *  根据id和日期查找眼保情况
     *@method selectEyeByIdAndDate
     *@params [diagnoseId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  15:50
     */
    @RequestMapping(value = "/selectEyeByIdAndDate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectEyeByIdAndDate(int diagnoseId) throws Exception{
        Diagnose diagnose = diagnoseService.selectById(diagnoseId);
        String userId = diagnose.getUserId();
        Date date = diagnose.getDate();
        Eye e = new Eye();
        e.setUserId(userId);
        e.setDate(date);
        Eye eye = eyeService.queryAllByEye(e);
        Map<String,Object> map = new HashMap<>();
        map.put("eye",eye);
        return map;
    }

    @RequestMapping(value = "/selectTimes",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectTimes(int diagnoseId) throws Exception{
        Diagnose diagnose = diagnoseService.selectById(diagnoseId);
        String userId = diagnose.getUserId();
        Date date = diagnose.getDate();
        int index = 0;
        List<Eye> eyes = eyeService.selectByUserId(userId);
        for (int i=0;i<eyes.size();i++){
            if (date.equals(eyes.get(i).getDate())){
                System.out.println("两个日期相同");
                index = i;
            }
        }
        List<Eye> eyeList = new ArrayList<>();
        for (int j = index;j>index-14&&j>=0;j--){
            eyeList.add(eyes.get(j));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("eyeList",eyeList);
        return map;
    }


}
