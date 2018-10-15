package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品列表
 *
 * @author huojg
 */
@TableName("goods_ranklist")
public class GoodsRanklistEntity implements Serializable {
    /**
     * 商品Id
     */
    @TableId
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片
     */
    private String rankGoodImg;

    /**
     *实际价格
     */
    private BigDecimal actualPrice;
    /**
     * 券价
     */
    private BigDecimal cutPrice;
    /**
     *第三方名称
     */
    private String otherPlatform;
    /**
     * 第三方价格
     */
    private BigDecimal otherPrice;

    /**
     *访问次数
     */

    private String visitCount;

    /**
     * 推荐理由
     */
    private String recommendReason;

    /*
    *综合评分
     */
    private BigDecimal goodsGrade;
    /**
     *商品类型ID
     */
    private String goodsTypeid;

    private String userId;
    private Date createTime;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getRankGoodImg() {
        return rankGoodImg;
    }

    public void setRankGoodImg(String rankGoodImg) {
        this.rankGoodImg = rankGoodImg;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getCutPrice() {
        return cutPrice;
    }

    public void setCutPrice(BigDecimal cutPrice) {
        this.cutPrice = cutPrice;
    }

    public String getOtherPlatform() {
        return otherPlatform;
    }

    public void setOtherPlatform(String otherPlatform) {
        this.otherPlatform = otherPlatform;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason;
    }

    public BigDecimal getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(BigDecimal goodsGrade) {
        this.goodsGrade = goodsGrade;
    }

    public String getGoodsTypeid() {
        return goodsTypeid;
    }

    public void setGoodsTypeid(String goodsTypeid) {
        this.goodsTypeid = goodsTypeid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
