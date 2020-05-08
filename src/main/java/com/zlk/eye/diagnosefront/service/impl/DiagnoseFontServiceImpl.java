package com.zlk.eye.diagnosefront.service.impl;

import com.zlk.eye.diagnosefront.entity.DiagnoseFont;
import com.zlk.eye.diagnosefront.mapper.DiagnoseFontMapper;
import com.zlk.eye.diagnosefront.service.DiagnoseFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzheng
 * @version 1.0
 * @date 2020/5/7 16:41
 */
@Service
public class DiagnoseFontServiceImpl implements DiagnoseFrontService {
    @Autowired
    private DiagnoseFontMapper diagnoseMapper;

    @Override
    public Integer queryCount() {
        return diagnoseMapper.queryCount();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param diagnoseId 主键
     * @return 实例对象
     */
    @Override
    public DiagnoseFont queryById(Integer diagnoseId) {
        return this.diagnoseMapper.queryById(diagnoseId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DiagnoseFont> queryAllByLimit(int offset, int limit) {
        return this.diagnoseMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param diagnose 实例对象
     * @return 实例对象
     */
    @Override
    public DiagnoseFont insert(DiagnoseFont diagnose) {
        this.diagnoseMapper.insert(diagnose);
        return diagnose;
    }

    /**
     * 修改数据
     *
     * @param diagnose 实例对象
     * @return 实例对象
     */
    @Override
    public DiagnoseFont update(DiagnoseFont diagnose) {
        this.diagnoseMapper.update(diagnose);
        return this.queryById(diagnose.getDiagnoseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param diagnoseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer diagnoseId) {
        return this.diagnoseMapper.deleteById(diagnoseId) > 0;
    }

    @Override
    public List<DiagnoseFont> queryAllByDiagnose(DiagnoseFont diagnose) {
        return diagnoseMapper.queryAllByDiagnose(diagnose);
    }
}
