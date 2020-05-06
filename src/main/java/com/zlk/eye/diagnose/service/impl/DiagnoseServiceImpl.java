package com.zlk.eye.diagnose.service.impl;

import com.zlk.eye.diagnose.mapper.DiagnoseMapper;
import com.zlk.eye.diagnose.service.DiagnoseService;
import com.zlk.eye.diagnosecontent.mapper.DiagnoseContentMapper;
import com.zlk.eye.diagnosecontent.service.DiagnoseContentService;
import com.zlk.eye.entity.Diagnose;
import com.zlk.eye.util.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private DiagnoseContentMapper diagnoseContentMapper;

    @Override
    public List<Diagnose> selectByHumanID(Diagnose diagnose,Integer page,Integer limit) {
        Integer startPage = (page-1)*limit;
        diagnose.setStartPage(startPage);
        diagnose.setLimit(limit);
        return diagnoseMapper.selectByHumanID(diagnose);
    }

    @Override
    public Integer selectCountById(Diagnose diagnose) {
        return diagnoseMapper.selectCountById(diagnose);
    }

    @Override
    @Transactional
    public String deleteDiagnose(int diagnoseId) {
        String message;
        Integer integer = diagnoseMapper.deleteDiagnose(diagnoseId);
        Integer integer1 = diagnoseContentMapper.deleteByDiagnoseId(diagnoseId);
        if (integer>0 && integer1 >0){
            message = "删除成功";
        }else {
            message = "删除失败";
        }
        return message;
    }

    @Override
    public Diagnose selectById(int diagnoseId) {
        return diagnoseMapper.selectById(diagnoseId);
    }
}
