package com.zlk.eye.admin.qkq.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zlk.eye.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: News
 * @description:
 * @author: QianKeQin
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    //新闻ID uuid
    private String newsId;
    //新闻标题
    private String newsTitle;
    //新闻内容
    private String newsContent;
    //审核：0 审核中，1 已审核，2 审核未过
    private Integer approval;
    //发布时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //新闻和用户多对一关系
    private Users users;
}
