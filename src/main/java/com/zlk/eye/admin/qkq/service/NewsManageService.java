package com.zlk.eye.admin.qkq.service;

import com.zlk.eye.admin.qkq.entity.News;
import com.zlk.eye.admin.util.Pagination;

import java.util.List;

/**
 * @program: NewsManageService
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/6 13:51
 */
public interface NewsManageService {
    List<News> findNewsByAdmin(Pagination pagination);
    Integer findCountByAdmin(Pagination pagination);
    Integer deleteNewsByNewsId(String newsId);
    Integer addNews(News news);
    Integer updateNewsByNewsId(News news);
    Integer updateContentByTextArea(News news);
}
