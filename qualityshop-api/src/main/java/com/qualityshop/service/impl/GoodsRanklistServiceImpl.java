package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.GoodsRanklistDao;
import com.qualityshop.entity.GoodsRanklistEntity;
import com.qualityshop.service.GoodsRanklistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品列表
 *
 * @author huojg
 */
@Service("goodsRanklistService")
public class GoodsRanklistServiceImpl extends ServiceImpl<GoodsRanklistDao,GoodsRanklistEntity> implements GoodsRanklistService{

    @Resource
    private GoodsRanklistDao goodsRanklistDao;

    @Override
    public GoodsRanklistEntity goodsRanklistGet(String goodsId) {
        GoodsRanklistEntity goodsRanklistEntity=goodsRanklistDao.goodsRanklistGet(goodsId);
        return goodsRanklistEntity;
    }

    @Override
    public void goodsRanklistInsert(GoodsRanklistEntity goodsRanklistEntity) {
        goodsRanklistDao.goodsRanklistInsert(goodsRanklistEntity);

    }

    @Override
    public void goodsRanklistUpdate(GoodsRanklistEntity goodsRanklistEntity) {
        goodsRanklistDao.goodsRanklistUpdate(goodsRanklistEntity);

    }

    @Override
    public void goodsRanklistDelete(String goodsId) {
        goodsRanklistDao.goodsRanklistDelete(goodsId);
    }

    @Override
    public List<GoodsRanklistEntity> queryByGoodsRanklistCount(int offset, int end) {
        List<GoodsRanklistEntity> list=goodsRanklistDao.queryByGoodsRanklistCount(offset,end);
        return list;
    }

    @Override
    public List<GoodsRanklistEntity> queryByGoodsRanklistCountId(String userId, int offset, int end) {
        List<GoodsRanklistEntity> list=goodsRanklistDao.queryByGoodsRanklistCountId(userId,offset,end);
        return list;
    }
}
