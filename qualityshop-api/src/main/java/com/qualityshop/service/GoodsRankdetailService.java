package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.GoodsRankdetailEntity;

import java.util.List;

/**
 * 商品详情信息
 *
 * @author huojg
 */
public interface GoodsRankdetailService extends IService<GoodsRankdetailEntity> {
    public GoodsRankdetailEntity goodsRankdetailGet(String  goodsId);
    public void goodsRankdetailInsert(GoodsRankdetailEntity goodsRankdetailEntity);
    public void goodsRankdetailUpdate(GoodsRankdetailEntity goodsRankdetailEntity);
    public void goodsRankdetailDelete(String goodsId);

    List<GoodsRankdetailEntity> queryByGoodsRankdetailCount(int offset, int end);
    List<GoodsRankdetailEntity> queryByGoodsRankdetailCountId(String  userId, int offset, int end);

}
