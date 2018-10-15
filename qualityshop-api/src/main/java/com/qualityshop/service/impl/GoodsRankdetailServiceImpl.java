package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.GoodsRankdetailDao;
import com.qualityshop.entity.GoodsRankdetailEntity;
import com.qualityshop.service.GoodsRankdetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品详情
 *
 * @author huojg
 */
@Service("goodsRankdetailService")
public class GoodsRankdetailServiceImpl extends ServiceImpl<GoodsRankdetailDao,GoodsRankdetailEntity> implements GoodsRankdetailService{
   @Resource
   private GoodsRankdetailDao goodsRankdetailDao;


    @Override
    public GoodsRankdetailEntity goodsRankdetailGet(String goodsId) {
        GoodsRankdetailEntity goodsRankdetailEntity=goodsRankdetailDao.goodsRankdetailGet(goodsId);
        return goodsRankdetailEntity;
    }

    @Override
    public void goodsRankdetailInsert(GoodsRankdetailEntity goodsRankdetailEntity) {
        goodsRankdetailDao.goodsRankdetailInsert(goodsRankdetailEntity);

    }

    @Override
    public void goodsRankdetailUpdate(GoodsRankdetailEntity goodsRankdetailEntity) {
        goodsRankdetailDao.goodsRankdetailUpdate(goodsRankdetailEntity);

    }

    @Override
    public void goodsRankdetailDelete(String goodsId) {
        goodsRankdetailDao.goodsRankdetailDelete(goodsId);

    }

    @Override
    public List<GoodsRankdetailEntity> queryByGoodsRankdetailCount(int offset, int end) {
        List<GoodsRankdetailEntity> list=goodsRankdetailDao.queryByGoodsRankdetailCount(offset,end);
        return list;
    }

    @Override
    public List<GoodsRankdetailEntity> queryByGoodsRankdetailCountId(String userId, int offset, int end) {
        List<GoodsRankdetailEntity> list=goodsRankdetailDao.queryByGoodsRankdetailCountId(userId,offset,end);
        return list;
    }
}
