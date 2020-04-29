package com.zlk.eye.diagnose.mapper;

import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.util.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DiagnoseMapper {

    List<Diagnose> selectByID(Diagnose diagnose);

    Integer selectCountById(Diagnose diagnose);

    Integer deleteDiagnose(int diagnoseId);
}
