package com.zlk.eye.goods.controller;

import com.zlk.eye.goods.entity.Goods;
import com.zlk.eye.goods.service.GoodsService;
import com.zlk.eye.goods.util.Pagination;
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
    public Map<String,Object> uploadImage(@RequestParam("g_url") MultipartFile file, HttpServletRequest request) {
        Assert.notNull(file, "上传文件不能为空");
        String filepath = request.getServletContext().getRealPath("/goods");
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
        //确保路径存在
        File file2 = new File(filepath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String savepath = filepath + "\\" + filename;
        System.out.println("图片保存路径:" + savepath);
        Map map = new HashMap<String, Object>();
        try {
            //保存文件到服务器
            file.transferTo(new File(savepath));
            //保存到数据库

            //返回json
            map.put("msg", "ok");
            map.put("code", 200);

        } catch (Exception e) {
            map.put("msg", "error");
            map.put("code", 0);
            e.printStackTrace();
        }

        return map;
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
        mv.setViewName("goods");
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
        /**判断商品id是否重复*/
        /*List<Goods> goodsByGoodsId = (List<Goods>) goodsService.selectGoodsByGoodsId(goods.getG_id());
        if(goodsByGoodsId != null){
            mv.addObject("flag","true");
            mv.addObject("msg","商品ID已存在");
            mv.setViewName("goods");

            return mv;
        }*/

        Integer flag = goodsService.addGoods(goods);
        if(flag==1){
            mv.addObject("flag","true");
            mv.addObject("msg","添加成功");
            mv.setViewName("goods");
            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","添加失败");
            mv.setViewName("goods");
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
    public ModelAndView update( Goods goods, HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        //判断商品是否更改，更改后判断更改后的商品是否存在
        List<Goods> goodsByName = goodsService.selectGoodsByName(goods.getG_name());
        Goods goodsByGoodsId = goodsService.selectGoodsByGoodsId(goods.getG_id());

        if(!goods.getG_name().equals(goodsByGoodsId.getG_name())&&goodsByName!=null){
            mv.addObject("flag","true");
            mv.addObject("msg","商品已存在");
            mv.setViewName("goods");
            return mv;
        }
        //修改商品信息，修改完成提交，提示:修改成功；否则，提示：修改失败
        Integer flag = goodsService.updateGoodsByGoodsId(goods);
        if(flag == 1){
            mv.addObject("flag","true");
            mv.addObject("msg","修改成功");
            mv.setViewName("goods");

            return mv;
        }else {
            mv.addObject("flag","true");
            mv.addObject("msg","修改失败");
            mv.setViewName("goods");
            return mv;
        }
    }

    /**
     * 通过商品id删除商品
     * @param g_id
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(String g_id,HttpServletRequest request){

        goodsService.deleteGoodsByGoodsId(g_id);

        return "goods";
    }


}
