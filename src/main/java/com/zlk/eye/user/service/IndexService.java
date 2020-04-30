package com.zlk.eye.user.service;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;

import java.util.List;

/**
 * @ClassName： IndexService
 * @Description：
 * @Author： wy
 * @Date： 2020/4/28 12:49
 */
public interface IndexService {
    /**
     * 用户登录方法
     * @param userName
     * @param userPwd
     * @return
     */
    Users findUserByNameAndPwd(String userName,String userPwd);

    /**
     * 医生登录方法
     * @param doctors
     * @return
     */
    Doctors findDoctorByNameAndPwd(Doctors doctors);

    /**
     * 用户注册
     * @param users
     * @return
     */
    Integer addUser(Users users);

    /**
     * 查找所有用户，对比用户手机号
     * @return
     */
    List<Users> findUserAll();
}
