package com.qualityshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.qualityshop.entity.GoodsRanklistEntity;
import com.qualityshop.entity.UserShopmemberEntity;
import com.qualityshop.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 评测，发现，榜单接口
 *
 * @author huojg
 */
@Controller
@RequestMapping("/api")
@Api(tags="外部接口")
public class UfxApiController {

    @Autowired
    private UserShopmemberService userShopmemberService;
    @Autowired
    private UserPointService userPointService;
    @Autowired
    private UserDetailPointService userDetailPointService;
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private GoodsRanklistService goodsRanklistService;
    @Autowired
    private GoodsRankdetailService goodsRankdetailService;

    @GetMapping("evaluating")
    @ApiOperation("评测接口")
    public JSONObject evaluating(String mark, String userId) {

        //1.根据当前用户，查询当前用户信息，
        UserShopmemberEntity userShop=  userShopmemberService.queryByShopmember(userId);
        //2.根据当前用户，查询当前商品信息，
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        GoodsRanklistEntity goodsRanklistEntity=null;
        List<GoodsRanklistEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(Integer.parseInt(mark)==0){
            offset=1;
            end=10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }else if(Integer.parseInt(mark)>=1){
            offset=Integer.parseInt(mark)*10+1;
            end=Integer.parseInt(mark)*10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }

        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("GoodsRanklistEntity",list);
        //2.根据当前用户，查询当前商品信息，


        return json;
    }

    @GetMapping("find")
    @ApiOperation("发现接口")
    public JSONObject find(String mark, String userId) {

        //1.根据当前用户，查询当前用户信息，
        UserShopmemberEntity userShop=  userShopmemberService.queryByShopmember(userId);
        //2.根据当前用户，查询当前商品信息，
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        GoodsRanklistEntity goodsRanklistEntity=null;
        List<GoodsRanklistEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(Integer.parseInt(mark)==0){
            offset=1;
            end=10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }else if(Integer.parseInt(mark)>=1){
            offset=Integer.parseInt(mark)*10+1;
            end=Integer.parseInt(mark)*10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }

        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("GoodsRanklistEntity",list);
        //2.根据当前用户，查询当前商品信息，


        return json;
    }
    @GetMapping("billBoard")
    @ApiOperation("榜单接口")
    public JSONObject billboard(String mark, String userId) {

        //1.根据当前用户，查询当前用户信息，
        UserShopmemberEntity userShop=  userShopmemberService.queryByShopmember(userId);
        //2.根据当前用户，查询当前商品信息，
        int  offset=0;
        int  end=0;
        Map<String, Object> map=null;
        GoodsRanklistEntity goodsRanklistEntity=null;
        List<GoodsRanklistEntity> list=null;
        //表单校验
        //ValidatorUtils.validateEntity(form);
        //关注查询
        if(Integer.parseInt(mark)==0){
            offset=1;
            end=10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }else if(Integer.parseInt(mark)>=1){
            offset=Integer.parseInt(mark)*10+1;
            end=Integer.parseInt(mark)*10;
            list=goodsRanklistService.queryByGoodsRanklistCount(offset,end);
        }

        JSONObject json =new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("GoodsRanklistEntity",list);
        //2.根据当前用户，查询当前商品信息，


        return json;
    }

}
