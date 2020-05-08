package com.zlk.eye.admin.zzw.service.impl;

import com.zlk.eye.admin.zzw.entity.Goods;
import com.zlk.eye.admin.zzw.mapper.GoodsMapper;
import com.zlk.eye.admin.zzw.service.GoodsService;
import com.zlk.eye.admin.zzw.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张照伟
 * @program: GoodsServiceImpl
 * @description:
 * @date 2020/4/29 10:06
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @Override
    public Integer addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    /**
     * 根据商品id删除商品
     * @param g_id
     * @return
     */
    @Override
    public Integer deleteGoodsByGoodsId(String g_id) {
        return goodsMapper.deleteGoodsByGoodsId(g_id);
    }

    /**
     * 根据商品id修改商品
     * @param goods
     * @return
     */
    @Override
    public Integer updateGoodsByGoodsId(Goods goods) {
        return goodsMapper.updateGoodsByGoodsId(goods);
    }

    /**
     * 根据商品名称查询商品
     * @param g_name
     * @return
     */
    @Override
    public List<Goods> selectGoodsByName(String g_name) {
        return goodsMapper.selectGoodsByName(g_name);
    }

    /**
     * 根据商品名称模糊查询商品
     * @param pagination
     * @return
     */
    @Override
    public Integer selectCountByName(Pagination pagination) {
        return goodsMapper.selectCountByName(pagination);
    }

    /**
     * 根据商品id查询商品
     * @param g_id
     * @return
     */
    @Override
    public Goods selectGoodsByGoodsId(String g_id) {
        return goodsMapper.selectGoodsByGoodsId(g_id);
    }

    /**
     * 查询所有商品
     * @param goods
     * @return
     */
    @Override
    public List<Goods> findGoodsToGoodsEdit(Goods goods) {
        return goodsMapper.findGoodsToGoodsEdit(goods);
    }

    /**
     * 分页查询商品
     * @param pagination
     * @return
     */
    @Override
    public List<Goods> selectGoodsByLimit(Pagination pagination) {

        if (pagination.getLimit() == null) {
            pagination.setLimit(10);
        }
        if (pagination.getPage() == null) {
            pagination.setPage(1);
        }
        pagination.setStartPage((pagination.getPage() - 1) * pagination.getLimit());
        return goodsMapper.selectGoodsByLimit(pagination);
    }
}
