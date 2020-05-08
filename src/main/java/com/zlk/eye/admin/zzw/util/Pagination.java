package com.zlk.eye.admin.zzw.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 张照伟
 * @program: Pagination
 * @description:
 * @date 2020/4/29 9:15
 */
@Getter
@Setter
public class Pagination {
    //总页数
    private Integer totalCount;
    //当前页码
    private Integer page;
    //页面大小
    private Integer limit;
    //总页数
    private Integer totalPage;
    //起始页码
    private Integer startPage;
    //模糊查询条件
    private String condition;
}
