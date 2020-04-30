package com.zlk.eye.admin.lfx.service;

import com.zlk.eye.admin.lfx.entity.Admin;

public interface LoginService {
    Admin findAdminByAdminNameAndAdminPwd(String adminName,String adminPwd);
}
