package com.zlk.eye.admin.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: Pagination
 * @description: 后台管理分页
 * @author: QianKeQin
 * @date: 2020/5/6 13:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private Integer page;
    private Integer limit;
    private Integer startPage;
}
