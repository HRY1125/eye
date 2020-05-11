package com.zlk.eye.user.service.serviceimpl;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.mapper.IndexMapper;
import com.zlk.eye.user.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName： IndexServiceImpl
 * @Description： 登录业务逻辑层
 * @Author： wy
 * @Date： 2020/4/28 12:50
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private IndexMapper indexMapper;

    @Override
    public Users findUserByNameAndPwd(String userName, String userPwd) {
        return indexMapper.findUserByNameAndPwd(userName,userPwd);
    }

    @Override
    public Doctors findDoctorByNameAndPwd(String doctorName, String doctorPwd) {
        return indexMapper.findDoctorByNameAndPwd(doctorName,doctorPwd);
    }

    @Override
    public Integer addUser(Users users) {
        return indexMapper.addUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return indexMapper.findUserAll();
    }

    @Override
    public Integer addDoctor(Doctors doctors) {
        return indexMapper.addDoctor(doctors);
    }

    @Override
    public List<Doctors> findDoctorAll() {
        return indexMapper.findDoctorAll();
    }

    @Override
    public Doctors selectByDoctorId(String doctorId) {
        return indexMapper.selectByDoctorId(doctorId);
    }

    @Override
    public Users selectByUserId(String userId) {
        return indexMapper.selectByUserId(userId);
    }
}
