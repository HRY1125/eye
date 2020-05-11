package com.zlk.eye.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: eye
 * @description: 诊断信息实体类
 * @author: zyx
 * @create: 2020-04-28 15:39
 */
@Setter
@Getter
public class Diagnose {

    /* 诊断信息id 对应数据库表中diagnose_id字段*/
    private int diagnoseId;
    /* 普通用户id 对应数据库表中user_id字段*/
    private String userId;
    /* 医生用户id 对应数据库表中doctor_id字段*/
    private String doctorId;
    /* 诊断信息说明 对应数据库表中diagnose_title字段*/
    private String diagnoseTitle;
    /* 请求诊断日期 对应数据库表中date字段*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private int startPage;
    private int limit;

    public Diagnose() {
    }

    public Diagnose(int diagnoseId, String userId, String doctorId, String diagnoseTitle, Date date) {
        this.diagnoseId = diagnoseId;
        this.userId = userId;
        this.doctorId = doctorId;
        this.diagnoseTitle = diagnoseTitle;
        this.date = date;
    }
}
