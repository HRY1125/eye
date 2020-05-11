package com.zlk.eye.user.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName： News
 * @Description： 新闻实体类
 * @Author： yzh
 * @Date： 2020/5/2 15:20
 */
@Setter
@Getter
public class News {
    /**新闻ID*/
    private Integer nId;
    /**新闻标题*/
    private String nTitle;
    /**新闻正文*/
    private String nArtical;
    /**用户ID*/
    private String nUserId;

    public News(Integer nId, String nTitle, String nArtical, String nUserId) {
        this.nId = nId;
        this.nTitle = nTitle;
        this.nArtical = nArtical;
        this.nUserId = nUserId;
    }

    public News() {
    }
}
