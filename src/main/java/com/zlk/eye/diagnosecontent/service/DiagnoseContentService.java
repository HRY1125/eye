package com.zlk.eye.diagnosecontent.service;

import com.zlk.eye.entity.DiagnoseContent;

import java.util.List;

public interface DiagnoseContentService {

    List<DiagnoseContent> selectAllByDiagnoseId(int diagnoseId, int page, int limit);

    Integer selectCountByDiagnoseId(int diagnoseId);

    Integer insertDiagnoseContent(DiagnoseContent diagnoseContent);

    Integer updateDCByDcId(DiagnoseContent diagnoseContent);

    Integer deleteByDcId(int dcId);
}
