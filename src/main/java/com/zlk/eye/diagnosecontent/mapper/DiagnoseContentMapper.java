package com.zlk.eye.diagnosecontent.mapper;

import com.zlk.eye.entity.DiagnoseContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DiagnoseContentMapper {

    List<DiagnoseContent> selectAllByDiagnoseId(int diagnoseId, int startPage, int limit);

    Integer selectCountByDiagnoseId(int diagnoseId);

    Integer insertDiagnoseContent(DiagnoseContent diagnoseContent);

    Integer updateDCByDcId(DiagnoseContent diagnoseContent);

    Integer deleteByDcId(int dcId);

    Integer deleteByDiagnoseId(int diagnoseId);
}
