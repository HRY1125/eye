package com.zlk.eye.user.service.serviceimpl;

import com.zlk.eye.user.entity.Doctors;
import com.zlk.eye.user.entity.Users;
import com.zlk.eye.user.mapper.IndexMapper;
import com.zlk.eye.user.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： IndexServiceImpl
 * @Description： 登录业务逻辑层
 * @Author： wy
 * @Date： 2020/4/28 12:50
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Override
    public Users findUserByNameAndPwd(String userName, String userPwd) {
        return indexMapper.findUserByNameAndPwd(userName,userPwd);
    }

    @Override
    public Doctors findDoctorByNameAndPwd(Doctors doctors) {
        return indexMapper.findDoctorByNameAndPwd(doctors);
    }

    @Override
    public Integer addUser(Users users) {
        return indexMapper.addUser(users);
    }

    @Override
    public List<Users> findUserAll() {
        return indexMapper.findUserAll();
    }
}
