package com.zlk.eye.diagnosefront.mapper;

import com.zlk.eye.diagnosefront.entity.DiagnoseFont;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/5/7 16:39
 */
@Mapper
@Component
public interface DiagnoseFontMapper {

    /**
     * 查询数据条数
     * @return 数据条数
     */
    Integer queryCount();

    /**
     * 通过ID查询单条数据
     *
     * @param diagnoseId 主键
     * @return 实例对象
     */
    DiagnoseFont queryById(Integer diagnoseId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DiagnoseFont> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param diagnose 实例对象
     * @return 对象列表
     */
    List<DiagnoseFont> queryAllByDiagnose(DiagnoseFont diagnose);

    /**
     * 新增数据
     *
     * @param diagnose 实例对象
     * @return 影响行数
     */
    int insert(DiagnoseFont diagnose);

    /**
     * 修改数据
     *
     * @param diagnose 实例对象
     * @return 影响行数
     */
    int update(DiagnoseFont diagnose);

    /**
     * 通过主键删除数据
     *
     * @param diagnoseId 主键
     * @return 影响行数
     */
    int deleteById(Integer diagnoseId);
}
