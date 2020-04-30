package com.zlk.eye.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: eye
 * @description: 诊断内容实体类
 * @author: zyx
 * @create: 2020-04-29 14:49
 */
@Setter
@Getter
public class DiagnoseContent {

    /* 诊断内容id 对应数据库表中dc_id字段*/
    private int dcId;
    /* 诊断内容 对应数据库表中content字段*/
    private String content;
    /* 发出内容的人的身份 对应数据库表中role字段*/
    private String role;
    /* 发出诊断内容的时间 对应数据库表中date字段*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    /* 诊断请求id 对应数据库表中diagnose_id字段*/
    private int diagnoseId;

    public DiagnoseContent() {
    }

    public DiagnoseContent(int dcId, String content, String role, Date date, int diagnoseId) {
        this.dcId = dcId;
        this.content = content;
        this.role = role;
        this.date = date;
        this.diagnoseId = diagnoseId;
    }
}
