package com.zlk.eye.user.mapper;

import com.zlk.eye.user.entity.Doctors;
import org.apache.catalina.User;

import java.util.List;

/**
 * @ClassName： UserMapper
 * @Description： index mapper接口
 * @Author： wy
 * @Date： 2020/4/28 10:34
 */
public interface IndexMapper {
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
