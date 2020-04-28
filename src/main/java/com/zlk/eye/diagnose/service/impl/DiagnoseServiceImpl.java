package com.zlk.eye.diagnose.service.impl;

import com.zlk.eye.diagnose.mapper.DiagnoseMapper;
import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.entity.Diagnose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: eye
 * @description: diagnose业务实现类
 * @author: zyx
 * @create: 2020-04-28 16:08
 */
@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    @Autowired
    private DiagnoseMapper diagnoseMapper;

    @Override
    public List<Diagnose> selectAllOrderByDate() {
        return diagnoseMapper.selectAllOrderByDate();
    }

    @Override
    public Integer selectAllCount() {
        return diagnoseMapper.selectAllCount();
    }
}
