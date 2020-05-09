package com.zlk.eye.admin.zzw.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.eye.admin.util.UUIDUtils;
import com.zlk.eye.admin.zzw.entity.Goods;
import com.zlk.eye.admin.zzw.service.GoodsService;
import com.zlk.eye.admin.zzw.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.*;

/**
 * @author 张照伟
 * @program: GoodsController
 * @description:
 * @date 2020/4/29 10:39
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 图片上传本地
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("g_url")MultipartFile file, Goods goods, HttpServletRequest request) throws IllegalStateException, IOException{
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();

        //String path = request.getSession().getServletContext().getRealPath("upload");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String path = "D:/eye/";
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        // String fileName = uuid.toString() + originalFilename;
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(path+fileName);
        File filepath = new File(path);
        System.out.println("路径=="+filepath.getParentFile());
        if(!filepath.getParentFile().exists()){
            filepath.getParentFile().mkdirs();
        }else{
            System.out.println(filepath.getParentFile());
        }

        file.transferTo(dir);
        //获得当前项目所在路径
        String pathRoot=request.getSession().getServletContext().getRealPath("");
        System.out.println("当前项目所在路径："+pathRoot);

        String sqlFile = "http://localhost:8080/"+fileName;
        goods.setG_url(sqlFile);
        goodsService.addGoods(goods);

        resUrl.put("src", sqlFile);
        res.put("code", 0);
        res.put("msg", "上传成功");
        res.put("data", resUrl);
        String str="";
        str = "{\"code\": 0,\"msg\": \"\",\"data\": {\"src\":\"" +dir + "\"}}";

        return res;

    }

    /**
     * 跳转到商品页面
     * @param condition
     * @return
     */
    @RequestMapping(value = "/toGoods")
    public ModelAndView toGoods(String condition){
        ModelAndView mv= new ModelAndView();
        mv.addObject("condition",condition);
        mv.setViewName("goodsManage");
        return mv;
    }

    /**
     * 商品管理接口，展示所有商品
     * @param pagination
     * @return
     */
    @RequestMapping(value = "/goodsManager")
    @ResponseBody
    public Map<String,Object> goods(Pagination pagination){
        Map<String,Object> map=new HashMap<>();
        List<Goods> goodsList = goodsService.selectGoodsByLimit(pagination);
        Integer count = goodsService.selectCountByName(pagination);
        map.put("code","0");
        map.put("data",goodsList);
        map.put("count",count);
        return map;
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping(value = "/insert")
    public ModelAndView insert(@Valid Goods goods, BindingResult bindingResult){
        ModelAndView mv=new ModelAndView();
        goods.setG_id(UUIDUtils.getId());

        Integer flag = goodsService.addGoods(goods);
        if(flag==1){
            mv.addObject("flag","true");
            mv.addObject("msg","添加成功");
            mv.setViewName("goodsManage");
            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","添加失败");
            mv.setViewName("goodsManage");
            return mv;
        }
    }



    /**
     *当前端页面传过来的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
     * @param binder
     */
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    /**
     * 通过商品id修改商品信息
     * @param goods
     * @param request
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ModelAndView update( Goods goods, HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        //修改商品信息，修改完成提交，提示:修改成功；否则，提示：修改失败
        Integer flag = goodsService.updateGoodsByGoodsId(goods);
        if(flag == 1){
            mv.addObject("flag","true");
            mv.addObject("msg","修改成功");
            mv.setViewName("goodsManage");

            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","修改失败");
            mv.setViewName("goodsManage");
            return mv;
        }
    }

    /**
     * 通过商品id删除商品
     * @param g_id
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(String g_id){

        goodsService.deleteGoodsByGoodsId(g_id);

        return "goodsManage";
    }


}
