package com.zlk.eye.admin.qkq.service.impl;

import com.zlk.eye.admin.qkq.entity.News;
import com.zlk.eye.admin.qkq.mapper.NewsManageMapper;
import com.zlk.eye.admin.qkq.service.NewsManageService;
import com.zlk.eye.admin.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: NewsManageServiceImpl
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/6 14:28
 */
@Service
public class NewsManageServiceImpl implements NewsManageService {

    @Autowired
    private NewsManageMapper newsManageMapper;

    @Override
    public List<News> findNewsByAdmin(Pagination pagination) {
        Integer page=pagination.getPage();
        Integer limit=pagination.getLimit();
        Integer startPage=(page-1)*limit;
        pagination.setStartPage(startPage);
        return newsManageMapper.findNewsByAdmin(pagination);
    }

    @Override
    public Integer findCountByAdmin(Pagination pagination) {
        return newsManageMapper.findCountByAdmin(pagination);
    }

    @Override
    public Integer deleteNewsByNewsId(String newsId) {
        return newsManageMapper.deleteNewsByNewsId(newsId);
    }

    @Override
    public Integer addNews(News news) {
        return newsManageMapper.addNews(news);
    }

    @Override
    public Integer updateNewsByNewsId(News news) {
        return newsManageMapper.updateNewsByNewsId(news);
    }

    @Override
    public Integer updateContentByTextArea(News news) {
        return newsManageMapper.updateContentByTextArea(news);
    }
}
