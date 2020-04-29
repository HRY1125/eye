package com.zlk.eye.user.service.serviceimpl;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.mapper.IndexMapper;
import com.zlk.eye.user.service.IndexService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName： IndexServiceImpl
 * @Description：
 * @Author： wy
 * @Date： 2020/4/28 12:50
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired(required = false)
    private IndexMapper indexMapper;

    @Override
    public User findUserByPhone(String userPhonenum) {
        return indexMapper.findUserByPhone(userPhonenum);
    }

    @Override
    public Doctors findDoctorByPhone(String doctorPhonenum) {
        return indexMapper.findDoctorByPhone(doctorPhonenum);
    }
}
