package com.zlk.eye.admin.qkq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: Questions
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/8 11:48
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questions {
    //问题ID uuid
    private String questionId;
    //问题标题
    private String questionTitle;
    //问题内容
    private String questionContent;
    //问题回答
    private String questionAnswer;
    //发布时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
