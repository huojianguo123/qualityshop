package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 支付宝交易表
 *
 * @author huojg
 */
@TableName("user_alipay")
public class UserAlipayEntity implements Serializable {
    @TableId
    private String id;
    /**
     * 用户
     */
    private String userId;
    /**
     * 支付名称
     */
    private String pay_name;
    /**
     * 支付宝账号
     */
    private String  out_biz_no;
    /**
     * 支付宝订单号
     */
    private String order_id;
    /**
     * 入账时间
     */
    private String accountTime;

    /**
     * 提款金额
     * @return
     */
    private String amount;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPay_name() {
        return pay_name;
    }

    public void setPay_name(String pay_name) {
        this.pay_name = pay_name;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(String accountTime) {
        this.accountTime = accountTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
