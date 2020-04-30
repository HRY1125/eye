package com.zlk.eye.eye.service;

import com.zlk.eye.eye.entity.Eye;

import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/4/29 11:30
 */
public interface EyeService {

    /**
     *      * 通过实体作为筛选条件查询
     *      *
     * @param eye 实例对象
     * @return 对象列表
     */
    List<Eye> queryAllByEye(Eye eye);

    /**
     * 查询全部数据
     *
     * @return 实例对象
     */
    List<Eye> queryAll();
    /**
     * 通过ID查询单条数据
     *
     * @param eyeId 主键
     * @return 实例对象
     */
    Eye queryById(Integer eyeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Eye> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param eye 实例对象
     * @return 实例对象
     */
    Eye insert(Eye eye);

    /**
     * 修改数据
     *
     * @param eye 实例对象
     * @return 实例对象
     */
    Eye update(Eye eye);

    /**
     * 通过主键删除数据
     *
     * @param eyeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer eyeId);
}
