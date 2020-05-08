package com.zlk.eye.admin.zzw.service;

import com.zlk.eye.admin.zzw.entity.Goods;
import com.zlk.eye.admin.zzw.util.Pagination;

import java.util.List;

/**
 * @author 张照伟
 * @program: GoodsService
 * @description:
 * @date 2020/4/29 10:03
 */
public interface GoodsService {

    /**
     * 新增商品
     * @param goods
     * @return
     */
    Integer addGoods(Goods goods);

    /**
     * 根据商品id删除商品
     * @param g_id
     * @return
     */
    Integer deleteGoodsByGoodsId(String g_id);

    /**
     * 根据商品id修改商品
     * @param goods
     * @return
     */
    Integer updateGoodsByGoodsId(Goods goods);

    /**
     * 根据商品名称查询商品
     * @param g_name
     * @return
     */
    List<Goods> selectGoodsByName(String g_name);

    /**
     * 根据商品名称模糊查询商品
     * @param pagination
     * @return
     */
    Integer selectCountByName(Pagination pagination);

    /**
     * 根据商品id查询商品
     * @param g_id
     * @return
     */
    Goods selectGoodsByGoodsId(String g_id);

    /**
     * 查询所有商品
     * @param goods
     * @return
     */
    List<Goods> findGoodsToGoodsEdit(Goods goods);

    /**
     * 分页查询商品
     * @param pagination
     * @return
     */
    List<Goods> selectGoodsByLimit(Pagination pagination);
}
