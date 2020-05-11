package com.zlk.eye.diagnosefront.controller;

import com.zlk.eye.diagnosefront.service.DiagnoseFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/5/7 16:41
 */
@Controller
@RequestMapping("diagnosefront")
public class DiagnoseFrontController {
    /**
     * 服务对象
     */
    @Autowired
    private DiagnoseFrontService diagnoseService;

    /**
     * 查询的方法
     * @param page
     * @param limit
     * @return 带有diagnoseList数据的map
     */
    @RequestMapping("queryAllByDiagnose")
    @ResponseBody
    public Map queryAllByDiagnose(Integer page,Integer limit){
        Map map =new HashMap();
        Integer userId = 111;
        Integer number = diagnoseService.queryCount();
        Integer slnumber = number/limit;
        if(number%limit!=0){ slnumber++; }
        int offset = (page-1)*limit;
        map.put("number",slnumber);
        map.put("diagnoseList",diagnoseService.queryAllByLimit(userId,offset,limit));
        return map;
    }

    /**
     * 跳转诊断页面
     * @return 诊断页面
     */
    @RequestMapping("toDiagnoseFront")
    public String toDiagnoseFront(){
        return "diagnose/diagnosefront";
    }
}
