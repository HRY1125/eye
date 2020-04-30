package com.zlk.eye.admin.lfx.service.impl;

import com.zlk.eye.admin.lfx.entity.Admin;
import com.zlk.eye.admin.lfx.mapper.LoginMapper;
import com.zlk.eye.admin.lfx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description: 管理员登陆业务逻辑层
 * @Author lufengxiang
 * Date 2020/4/29 19:11
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Admin findAdminByAdminNameAndAdminPwd(String adminName, String adminPwd) {
        return loginMapper.findAdminByAdminNameAndAdminPwd(adminName,adminPwd);
    }
}
