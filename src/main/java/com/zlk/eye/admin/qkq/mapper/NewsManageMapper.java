package com.zlk.eye.admin.qkq.mapper;

import com.zlk.eye.admin.qkq.entity.News;
import com.zlk.eye.admin.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: NewsManageMapper
 * @description:
 * @author: QianKeQin
 * @date: 2020/5/6 13:52
 */
@Mapper
public interface NewsManageMapper {
    List<News> findNewsByAdmin(Pagination pagination);
    Integer findCountByAdmin(Pagination pagination);
    Integer deleteNewsByNewsId(String newsId);
    Integer addNews(News news);
    Integer updateNewsByNewsId(News news);
    Integer updateContentByTextArea(News news);
}
