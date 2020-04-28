package com.zlk.eye.user.service;

import com.zlk.eye.user.entity.Doctors;
import org.apache.catalina.User;

/**
 * @ClassName： IndexService
 * @Description：
 * @Author： wy
 * @Date： 2020/4/28 12:49
 */
public interface IndexService {
    /**
     * 根据手机号查询用户
     * @param userPhonenum
     * @return
     */
    User findUserByPhone(String userPhonenum);

    /**
     * 根据手机号查询医生
     * @param doctorPhonenum
     * @return
     */
    Doctors findDoctorByPhone(String doctorPhonenum);
}
