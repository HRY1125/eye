package com.zlk.eye.user.mapper;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName： UserMapper
 * @Description： index mapper接口
 * @Author： wy
 * @Date： 2020/4/28 10:34
 */
@Mapper
public interface IndexMapper {
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
