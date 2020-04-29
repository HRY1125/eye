package com.zlk.eye.admin.lfx.mapper;

import com.zlk.eye.admin.lfx.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Admin findAdminByAdminNameAndAdminPwd(String adminName,String adminPwd);
}
