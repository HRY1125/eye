package com.zlk.eye.eye.mapper;

import com.zlk.eye.eye.entity.Eye;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/4/29 11:33
 */
@Mapper
@Component
public interface EyeMapper {
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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Eye> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     *      * 通过实体作为筛选条件查询
     *      *
     * @param eye 实例对象
     * @return 对象列表
     */
    Eye queryAllByEye(Eye eye);

    /**
     * 新增数据
     *
     * @param eye 实例对象
     * @return 影响行数
     */
    int insert(Eye eye);

    /**
     * 修改数据
     *
     * @param eye 实例对象
     * @return 影响行数
     */
    int update(Eye eye);

    /**
     * 通过主键删除数据
     *
     * @param eyeId 主键
     * @return 影响行数
     */
    int deleteById(Integer eyeId);
}
