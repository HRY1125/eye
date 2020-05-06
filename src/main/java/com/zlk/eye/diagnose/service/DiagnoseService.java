package com.zlk.eye.diagnose.service;

import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.util.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiagnoseService {

    List<Diagnose> selectByHumanID(Diagnose diagnose,Integer page,Integer limit);

    Integer selectCountById(Diagnose diagnose);

    String deleteDiagnose(int diagnoseId);

    Diagnose selectById(int diagnoseId);
}
