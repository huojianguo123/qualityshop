package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.GoodsRankdetailEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品详情接口
 *
 * @author huojg
 */
public interface GoodsRankdetailDao extends BaseMapper<GoodsRankdetailEntity>{
    public GoodsRankdetailEntity goodsRankdetailGet(String  goodsId);
    public void goodsRankdetailInsert(GoodsRankdetailEntity goodsRankdetailEntity);
    public void goodsRankdetailUpdate(GoodsRankdetailEntity goodsRankdetailEntity);
    public void goodsRankdetailDelete(String goodsId);
    List<GoodsRankdetailEntity> queryByGoodsRankdetailCount(int offset, int end);
    List<GoodsRankdetailEntity> queryByGoodsRankdetailCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);


}
