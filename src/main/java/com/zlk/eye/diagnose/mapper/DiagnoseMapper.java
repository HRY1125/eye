package com.zlk.eye.diagnose.mapper;

import com.zlk.eye.entity.Diagnose;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DiagnoseMapper {

    List<Diagnose> selectAllOrderByDate();

    Integer selectAllCount();
}
