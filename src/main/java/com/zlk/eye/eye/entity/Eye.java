package com.zlk.eye.eye.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/4/29 11:26
 */
@Getter
@Setter
public class Eye {
    private Integer eyeId;

    private String userId;

    private Integer eyeTime;

    private Integer wangyuanTime;

    private Integer yunyanTime;

    private Integer xiyanTime;

    private Date date;
}
