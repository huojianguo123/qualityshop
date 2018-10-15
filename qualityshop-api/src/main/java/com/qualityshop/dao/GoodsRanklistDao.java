package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.GoodsRanklistEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品接口
 *
 * @author huojg
 */
public interface GoodsRanklistDao extends BaseMapper<GoodsRanklistEntity> {
    public GoodsRanklistEntity goodsRanklistGet(String  goodsId);
    public void goodsRanklistInsert(GoodsRanklistEntity goodsRanklistEntity);
    public void goodsRanklistUpdate(GoodsRanklistEntity goodsRanklistEntity);
    public void goodsRanklistDelete(String goodsId);

    List<GoodsRanklistEntity> queryByGoodsRanklistCount(int offset, int end);
    List<GoodsRanklistEntity> queryByGoodsRanklistCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);

}
