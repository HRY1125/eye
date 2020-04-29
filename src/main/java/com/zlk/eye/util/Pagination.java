package com.zlk.eye.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: eye
 * @description: 分页工具类
 * @author: zyx
 * @create: 2020-04-29 12:01
 */
@Setter
@Getter
public class Pagination {
    /**数据封装*/
    private List<?> list;
    /**当前页*/
    private Integer page;
    /**每页显示条数*/
    private Integer limit;
    /**总条数*/
    private Integer totalCount;
    /**总页数*/
    private Integer totalPage;
    /**起始页*/
    private Integer startPage;

    public Pagination() {
    }

    public Pagination(List<?> list, Integer page, Integer limit, Integer totalCount, Integer totalPage, Integer startPage) {
        this.list = list;
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.startPage = startPage;
    }
}
