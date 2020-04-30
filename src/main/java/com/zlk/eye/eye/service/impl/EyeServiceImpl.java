package com.zlk.eye.eye.service.impl;

import com.zlk.eye.eye.entity.Eye;
import com.zlk.eye.eye.mapper.EyeMapper;
import com.zlk.eye.eye.service.EyeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/4/29 11:30
 */
@Service
public class EyeServiceImpl implements EyeService {
    @Resource
    private EyeMapper eyeMapper;

    @Override
    public List<Eye> queryAllByEye(Eye eye) {
        return eyeMapper.queryAllByEye(eye);
    }

    @Override
    public List<Eye> queryAll() {
        return eyeMapper.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param eyeId 主键
     * @return 实例对象
     */
    @Override
    public Eye queryById(Integer eyeId) {
        return this.eyeMapper.queryById(eyeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Eye> queryAllByLimit(int offset, int limit) {
        return this.eyeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param eye 实例对象
     * @return 实例对象
     */
    @Override
    public Eye insert(Eye eye) {
        this.eyeMapper.insert(eye);
        return eye;
    }

    /**
     * 修改数据
     *
     * @param eye 实例对象
     * @return 实例对象
     */
    @Override
    public Eye update(Eye eye) {
        this.eyeMapper.update(eye);
        return this.queryById(eye.getEyeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param eyeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer eyeId) {
        return this.eyeMapper.deleteById(eyeId) > 0;
    }
}
