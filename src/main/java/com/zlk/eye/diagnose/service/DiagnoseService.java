package com.zlk.eye.diagnose.service;

import com.zlk.eye.entity.Diagnose;

import java.util.List;

public interface DiagnoseService {

    List<Diagnose> selectAllOrderByDate();

    Integer selectAllCount();
}
