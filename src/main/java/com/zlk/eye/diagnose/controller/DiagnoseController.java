package com.zlk.eye.diagnose.controller;

import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.service.IndexService;
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
    @Autowired
    private IndexService indexService;

    /**
     *  跳转至诊断列表页面
     *@method toList
     *@params []
     *@return org.springframework.web.servlet.ModelAndView
     *@author zhang
     *@time 2020/5/11  16:57
     */
    @RequestMapping(value = "/toDiagnoseList")
    public ModelAndView toList() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("diagnose/diagnoseList");
        return mv;
    }

    /**
     *  查找全部诊断信息
     *@method selectAll
     *@params [request, page, limit]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  16:57
     */
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
        List<Diagnose> diagnoseList = diagnoseService.selectByHumanID(diagnose,page,limit);
        Integer count = diagnoseService.selectCountById(diagnose);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",diagnoseList);
        return map;

    }

    /**
     *  删除诊断信息
     *@method deleteDiagnose
     *@params [diagnoseId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  16:58
     */
    @RequestMapping(value = "/deleteDiagnose",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteDiagnose(int diagnoseId) throws Exception{
        String message = diagnoseService.deleteDiagnose(diagnoseId);
        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        return map;

    }

    /**
     *  根据诊断id查找诊断信息
     *@method selectById
     *@params [diagnoseId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  16:58
     */
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectById(int diagnoseId) throws Exception{
        Diagnose diagnose = diagnoseService.selectById(diagnoseId);
        Map<String,Object> map = new HashMap<>();
        map.put("diagnose",diagnose);
        return map;
    }

    /**
     *  根据医生id查找医生信息
     *@method selectByDoctorId
     *@params [doctorId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  17:16
     */
    @RequestMapping(value = "selectByDoctorId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectByDoctorId(String doctorId) throws Exception{
        Doctors doctor = indexService.selectByDoctorId(doctorId);
        Map<String,Object> map = new HashMap<>();
        map.put("doctorName",doctor.getDoctorName());
        return map;
    }

    /**
     *  根据用户id查找用户信息
     *@method selectByUserId
     *@params [userId]
     *@return java.util.Map<java.lang.String,java.lang.Object>
     *@author zhang
     *@time 2020/5/11  17:17
     */
    @RequestMapping(value = "selectByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectByUserId(String userId) throws Exception{
        Users user = indexService.selectByUserId(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("userName",user.getUserName());
        return map;
    }
}
