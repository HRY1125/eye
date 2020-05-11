package com.zlk.eye.user.service;


import com.zlk.eye.user.entity.News;

import java.util.List;

/**
 * @ClassName： HomePageService
 * @Description： 首页service
 * @Author： yzh
 * @Date： 2020/5/1 23:32
 */
public interface HomePageService {
    /**
     * 根据用户ID查找新闻通知
     * @param nUserId
     * @return News
     */
    List<News> findNewsById(String nUserId);
}
