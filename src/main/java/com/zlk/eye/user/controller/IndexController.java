package com.zlk.eye.user.controller;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.service.IndexService;
import com.zlk.eye.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName： IndexController
 * @Description： 登录注册controller类
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

    /**
     * 跳转至注册页面
     * @return
     */
    @RequestMapping("toRegistered")
    public String registered(){
        return "registered";
    }

    /**
     * 普通用户登录方法
     * @param users
     * @return
     * @throws Exception
     */
    @RequestMapping("/userLogin")
    public ModelAndView userLogin(Users users,HttpServletRequest request)throws Exception{
        ModelAndView mv = new ModelAndView();
        if (users != null){
            Users user = indexService.findUserByNameAndPwd(users.getUserName(),users.getUserPwd());
            if (user == null){
                mv.addObject("wrong","用户名或密码错误，请重新登录！");
                mv.setViewName("firstpage");
                return mv;
            } else {
                request.getSession().setAttribute("user",user);
                mv.setViewName("homePageIn");
                mv.addObject("name",users.getUserName());
                return mv;
            }
        } else {
            mv.addObject("wrong","登录异常！");
            mv.setViewName("firstpage");
            return mv;
        }
    }

    /**
     * 医生登录方法
     * @param doctors
     * @return
     */
    @RequestMapping("/doctorLogin")
    public ModelAndView doctorLogin(Doctors doctors,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if (doctors != null){
            Doctors doctor = indexService.findDoctorByNameAndPwd(doctors.getDoctorName(),doctors.getDoctorPwd());
            if (doctor == null){
                mv.addObject("wrong","用户名或密码错误，请重新登录！");
                mv.setViewName("firstpage");
                return mv;
            } else {
                request.getSession().setAttribute("doctor",doctor);
                mv.setViewName("homePageIn");
                mv.addObject("name",doctors.getDoctorName());
                return mv;
            }
        } else {
            mv.addObject("wrong","登录异常！");
            mv.setViewName("firstpage");
            return mv;
        }
    }

    /**
     * 普通用户注册
     * @param users
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser")
    public ModelAndView addUser(Users users) throws Exception{
        ModelAndView mv = new ModelAndView();
        String uuid1 = UUIDUtil.getUUID();
        users.setUserId(uuid1);
        users.setUserName(users.getUserName());
        users.setUserPwd(users.getUserPwd());
        users.setUserPhonenum(users.getUserPhonenum());
        List<Users> usersList = indexService.findUserAll();
        for (Users user : usersList){
            if (user.getUserPhonenum().equals(users.getUserPhonenum())){
                mv.addObject("wrong","此手机号已注册，请直接登录！");
                mv.setViewName("firstpage");
                return mv;
            }
        }
        Integer flag = indexService.addUser(users);
        if (flag == 1){
            mv.addObject("wrong","注册成功，请登录！");
            mv.setViewName("firstpage");
            return mv;
        } else {
            mv.addObject("wrong","注册失败，请重新注册！");
            mv.setViewName("registered");
            return mv;
        }
    }

    /**
     * 医生注册
     * @param doctors
     * @return
     * @throws Exception
     */
    @RequestMapping("/addDoctor")
    public ModelAndView addDoctor(Doctors doctors) throws Exception{
        ModelAndView mv = new ModelAndView();
        String uuid1 = UUIDUtil.getUUID();
        doctors.setDoctorId(uuid1);
        doctors.setDoctorName(doctors.getDoctorName());
        doctors.setDoctorPwd(doctors.getDoctorPwd());
        doctors.setDoctorPhonenum(doctors.getDoctorPhonenum());
        List<Doctors> doctorsList = indexService.findDoctorAll();
        for (Doctors doctors1 : doctorsList){
            if (doctors1.getDoctorPhonenum().equals(doctors.getDoctorPhonenum())){
                mv.addObject("wrong","此手机号已注册，请直接登录！");
                mv.setViewName("firstpage");
                return mv;
            }
        }
        Integer flag = indexService.addDoctor(doctors);
        if (flag == 1){
            mv.addObject("wrong","注册成功，请登录！");
            mv.setViewName("firstpage");
            return mv;
        } else {
            mv.addObject("wrong","注册失败，请重新注册！");
            mv.setViewName("registered");
            return mv;
        }
    }
}
