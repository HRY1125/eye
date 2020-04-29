package com.zlk.eye.user.entity;

/**
 * @ClassName： Doctors
 * @Description： 医生实体类
 * @Author： wy
 * @Date： 2020/4/28 10:32
 */
public class Doctors {
    /*医生id*/
    private String doctorId;
    /*医生姓名*/
    private String doctorName;
    /*医生密码*/
    private String doctorPwd;
    /*医生手机号码*/
    private String doctorPhonenum;

    public Doctors() {
    }

    public Doctors(String doctorId, String doctorName, String doctorPwd, String doctorPhonenum) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorPwd = doctorPwd;
        this.doctorPhonenum = doctorPhonenum;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPwd() {
        return doctorPwd;
    }

    public void setDoctorPwd(String doctorPwd) {
        this.doctorPwd = doctorPwd;
    }

    public String getDoctorPhonenum() {
        return doctorPhonenum;
    }

    public void setDoctorPhonenum(String doctorPhonenum) {
        this.doctorPhonenum = doctorPhonenum;
    }
}
