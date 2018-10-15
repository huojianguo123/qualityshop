package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.GoodsRanklistEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品列表
 *
 * @author huojg
 */
public interface GoodsRanklistService extends IService<GoodsRanklistEntity>{

    public GoodsRanklistEntity goodsRanklistGet(String  goodsId);
    public void goodsRanklistInsert(GoodsRanklistEntity goodsRanklistEntity);
    public void goodsRanklistUpdate(GoodsRanklistEntity goodsRanklistEntity);
    public void goodsRanklistDelete(String goodsId);

    List<GoodsRanklistEntity> queryByGoodsRanklistCount(int offset, int end);
    List<GoodsRanklistEntity> queryByGoodsRanklistCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);

}
