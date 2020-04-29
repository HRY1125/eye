package com.zlk.eye.diagnosecontent.service.impl;

import com.zlk.eye.diagnosecontent.mapper.DiagnoseContentMapper;
import com.zlk.eye.diagnosecontent.service.DiagnoseContentService;
import com.zlk.eye.entity.DiagnoseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: eye
 * @description: 诊断内容业务实现类
 * @author: zyx
 * @create: 2020-04-29 16:28
 */
@Service
public class DiagnoseContentServiceImpl implements DiagnoseContentService {

    @Autowired
    private DiagnoseContentMapper diagnoseContentMapper;

    @Override
    public List<DiagnoseContent> selectAllByDiagnoseId(int diagnoseId, int page, int limit) {
        int startPage = (page-1)*limit;
        return diagnoseContentMapper.selectAllByDiagnoseId(diagnoseId,startPage,limit);
    }

    @Override
    public Integer selectCountByDiagnoseId(int diagnoseId) {
        return diagnoseContentMapper.selectCountByDiagnoseId(diagnoseId);
    }

    @Override
    public Integer insertDiagnoseContent(DiagnoseContent diagnoseContent) {
        return diagnoseContentMapper.insertDiagnoseContent(diagnoseContent);
    }

    @Override
    public Integer updateDCByDcId(DiagnoseContent diagnoseContent) {
        return diagnoseContentMapper.updateDCByDcId(diagnoseContent);
    }

    @Override
    public Integer deleteByDcId(int dcId) {
        return diagnoseContentMapper.deleteByDcId(dcId);
    }
}
