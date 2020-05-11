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
     * @param doctorName
     * @param doctorPwd
     * @return
     */
    Doctors findDoctorByNameAndPwd(String doctorName,String doctorPwd);

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

    /**
     * 医生注册
     * @param doctors
     * @return
     */
    Integer addDoctor(Doctors doctors);

    /**
     * 查找所有医生，对比医生手机号
     * @return
     */
    List<Doctors> findDoctorAll();

    /**
     * 根据医生id查找医生信息
     * @return
     */
    Doctors selectByDoctorId(String doctorId);

    /**
     * 根据用户id查找用户信息
     * @return
     */
    Users selectByUserId(String userId);
}
