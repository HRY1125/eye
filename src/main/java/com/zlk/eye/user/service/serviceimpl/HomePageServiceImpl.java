package com.zlk.eye.user.service.serviceimpl;

import com.zlk.eye.user.entity.News;
import com.zlk.eye.user.mapper.HomePageMapper;
import com.zlk.eye.user.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName： HomePageServiceImpl
 * @Description： HomePageService实现类
 * @Author： yzh
 * @Date： 2020/5/1 23:44
 */
@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired(required = false)
    private HomePageMapper homePageMapper;

    /**
     * 根据用户ID查找新闻通知
     * @param nUserId
     * @return News
     */
    @Override
    public List<News> findNewsById(String nUserId) {
        return homePageMapper.findNewsById(nUserId);
    }
}
