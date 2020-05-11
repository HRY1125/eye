package com.zlk.eye.user.mapper;

import com.zlk.eye.user.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName： HomePageMapper
 * @Description： 首页Mapper
 * @Author： yzh
 * @Date： 2020/5/1 23:32
 */
@Mapper
public interface HomePageMapper {
    /**
     * 根据用户ID查找新闻通知
     * @param nUserId
     * @return News
     */
    List<News> findNewsById(String nUserId);
}
