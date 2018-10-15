package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.common.utils.R;
import com.qualityshop.common.validator.ValidatorUtils;
import com.qualityshop.entity.GoodsRankdetailEntity;
import com.qualityshop.entity.GoodsRanklistEntity;
import com.qualityshop.form.GoodsRanklistForm;
import com.qualityshop.service.GoodsRankdetailService;
import com.qualityshop.service.GoodsRanklistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * 商品接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="商品接口")
public class GoodsRanklistController {

    @Autowired
    private GoodsRanklistService goodsRanklistService;

    @Autowired
    private GoodsRankdetailService goodsRankdetailService;

    @GetMapping("goodRank")
    @ApiOperation("商品查询")
    public JSONObject good(String mark, String  goodsId){
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        GoodsRanklistEntity goodsRanklistEntity=null;
        List<GoodsRanklistEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(mark==null){
            goodsRanklistEntity=goodsRanklistService.goodsRanklistGet(goodsId);
        }else if(Integer.parseInt(mark)==0){
            offset=1;
            end=10;
            list=goodsRanklistService.queryByGoodsRanklistCountId(goodsId, offset,end);
        }else if(Integer.parseInt(mark)>=1){
            offset=Integer.parseInt(mark)*10+1;
            end=Integer.parseInt(mark)*10;
            list=goodsRanklistService.queryByGoodsRanklistCountId(goodsId, offset,end);
        }
        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("list",list);

        return json;
    }

    @PostMapping("goodInsert")
    @ApiOperation("新增商品")
    public R commentInsert(GoodsRanklistForm goodsRanklistForm){
        GoodsRanklistEntity goodsRanklistEntity =new GoodsRanklistEntity();
        //表单校验
        ValidatorUtils.validateEntity(goodsRanklistForm);
        BeanUtils.copyProperties(goodsRanklistForm,goodsRanklistEntity);
        goodsRanklistService.goodsRanklistInsert(goodsRanklistEntity);
        //同步商品详情表中
        GoodsRanklistEntity GoodsRanklist= goodsRanklistService.goodsRanklistGet(goodsRanklistEntity.getGoodsId());
        String goodsDetailId= UUID.randomUUID().toString().replaceAll("-", "");
        GoodsRankdetailEntity goodsRankdetailEntity=new GoodsRankdetailEntity();
        goodsRankdetailEntity.setGoodsDetailId(goodsDetailId);
        goodsRankdetailEntity.setGoodsId(GoodsRanklist.getGoodsId());
        //商品详情信息
        goodsRankdetailEntity.setGoodsDetailTitle(GoodsRanklist.getGoodsName());
        goodsRankdetailEntity.setGoodsDetailImgId("");
        //评测id
        goodsRankdetailEntity.setEvalId("");
        //评论Id
        goodsRankdetailEntity.setCommentId("");
        //点赞
        goodsRankdetailEntity.setSupportCount("0");
        //跳转的连接
        goodsRankdetailEntity.setGoodsBuyLink("www.baidu.com");
        goodsRankdetailEntity.setActualPrice(GoodsRanklist.getActualPrice());
        goodsRankdetailEntity.setCutPrice(GoodsRanklist.getCutPrice());
        goodsRankdetailEntity.setOtherPrice(GoodsRanklist.getOtherPrice());
        goodsRankdetailEntity.setVisitCount(GoodsRanklist.getVisitCount());
        goodsRankdetailService.goodsRankdetailInsert(goodsRankdetailEntity);
        return R.ok();
    }

    @PostMapping("goodUpdate")
    @ApiOperation("修改商品")
    public R goodUpdate(GoodsRanklistForm goodsRanklistForm){
        GoodsRanklistEntity goodsRanklistEntity =new GoodsRanklistEntity();
        //表单校验
        ValidatorUtils.validateEntity(goodsRanklistForm);
        BeanUtils.copyProperties(goodsRanklistForm,goodsRanklistEntity);
        goodsRanklistService.goodsRanklistUpdate(goodsRanklistEntity);

        //同步商品详情表中
        GoodsRanklistEntity GoodsRanklist= goodsRanklistService.goodsRanklistGet(goodsRanklistEntity.getGoodsId());
        GoodsRankdetailEntity goodsRankdetailEntity=goodsRankdetailService.goodsRankdetailGet(goodsRanklistEntity.getGoodsId());
        goodsRankdetailEntity.setGoodsId(GoodsRanklist.getGoodsId());
        //商品详情信息
        goodsRankdetailEntity.setGoodsDetailTitle(GoodsRanklist.getGoodsName());
        goodsRankdetailEntity.setGoodsDetailImgId("");
        //评测id
        goodsRankdetailEntity.setEvalId("");
        //评论Id
        goodsRankdetailEntity.setCommentId("");
        //点赞
        goodsRankdetailEntity.setSupportCount("0");
        //跳转的连接
        goodsRankdetailEntity.setGoodsBuyLink("www.baidu.com");
        goodsRankdetailEntity.setActualPrice(GoodsRanklist.getActualPrice());
        goodsRankdetailEntity.setCutPrice(GoodsRanklist.getCutPrice());
        goodsRankdetailEntity.setOtherPrice(GoodsRanklist.getOtherPrice());
        goodsRankdetailEntity.setVisitCount(GoodsRanklist.getVisitCount());
        goodsRankdetailService.goodsRankdetailUpdate(goodsRankdetailEntity);
        return R.ok();
    }
}
