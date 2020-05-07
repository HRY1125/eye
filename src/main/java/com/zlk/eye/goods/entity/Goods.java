package com.zlk.eye.goods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 张照伟
 * @program: Goods 商品实体类  商品清单
 * @description:
 * @date 2020/4/28 21:55
 */
@Getter
@Setter
public class Goods {
    /*商品ID*/
    private String g_id;
    /*商品名称*/
    private String g_name;
    /*商品简介*/
    private String g_profile;
    /*商品图片地址*/
    private String g_url;
    /*商品单价*/
    private double g_money;
    /*商品数量*/
    private int g_count;
    /*商品生产日期*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date g_date;

    public Goods() {
    }

    public Goods(String g_id, String g_name, String g_profile, String g_url, double g_money, int g_count, Date g_date) {
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_profile = g_profile;
        this.g_url = g_url;
        this.g_money = g_money;
        this.g_count = g_count;
        this.g_date = g_date;
    }
}
