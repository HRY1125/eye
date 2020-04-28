package com.zlk.eye.user.entity;

/**
 * @ClassName： Users
 * @Description： 用户实体类
 * @Author： wy
 * @Date： 2020/4/28 10:24
 */
public class Users {
    /*用户id*/
    private String userId;
    /*用户姓名*/
    private String userName;
    /*用户密码*/
    private String userPwd;
    /*用户手机号码*/
    private String userPhonenum;

    public Users() {
    }

    public Users(String userId, String userName, String userPwd, String userPhonenum) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhonenum = userPhonenum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhonenum() {
        return userPhonenum;
    }

    public void setUserPhonenum(String userPhonenum) {
        this.userPhonenum = userPhonenum;
    }
}
