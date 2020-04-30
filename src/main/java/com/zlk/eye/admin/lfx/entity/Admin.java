package com.zlk.eye.admin.lfx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Admin
 * @Description: 管理员实体类
 * @Author lufengxiang
 * Date 2020/4/29 19:02
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    //管理员ID
    private Integer adminId;
    //管理员用户名
    private String adminName;
    //管理员密码
    private String adminPwd;
}
