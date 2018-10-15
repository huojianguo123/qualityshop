package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品详情表
 *
 * @author huojg
 */
@TableName("goods_rankdetail")
public class GoodsRankdetailEntity implements Serializable{
    /**
     * 商品详情Id
     */
    @TableId
    private String goodsDetailId;
    /**
     * 商品id'
     */
    private String goodsId;
    private String goodsDetailTitle;
    private String goodsDetailImgId;
    private  String evalId;
    private String commentId;
    private String supportCount;
    /**
     * 商品购买链接
     */
    private String goodsBuyLink;
    private BigDecimal actualPrice;
    private BigDecimal cutPrice;
    private BigDecimal otherPrice;
    private String visitCount;
    private String userId;
    private Date createTime;

    public String getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(String goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDetailTitle() {
        return goodsDetailTitle;
    }

    public void setGoodsDetailTitle(String goodsDetailTitle) {
        this.goodsDetailTitle = goodsDetailTitle;
    }

    public String getGoodsDetailImgId() {
        return goodsDetailImgId;
    }

    public void setGoodsDetailImgId(String goodsDetailImgId) {
        this.goodsDetailImgId = goodsDetailImgId;
    }

    public String getEvalId() {
        return evalId;
    }

    public void setEvalId(String evalId) {
        this.evalId = evalId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(String supportCount) {
        this.supportCount = supportCount;
    }

    public String getGoodsBuyLink() {
        return goodsBuyLink;
    }

    public void setGoodsBuyLink(String goodsBuyLink) {
        this.goodsBuyLink = goodsBuyLink;
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
