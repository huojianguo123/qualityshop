package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 签到接口
 *
 * @author huojg
 */
@TableName("user_sign")
public class UserSignEntity implements Serializable {
    /**
     * 签到ID
     */
    @TableId
    private String sign_id;
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 签到积分
     */
    private String sign_poins;

    /**
     * 签到状态
     */
    private String sign_state;

    /*
    * 连续签到天数
     */
    private int sign_count;
    /*
     * 签到日期
     */
    private Date sign_time;

    /*
    *时间数组
     */

    private String arrays_time;

    private String [] week;

    public String getSign_id() {
        return sign_id;
    }

    public void setSign_id(String sign_id) {
        this.sign_id = sign_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSign_poins() {
        return sign_poins;
    }

    public void setSign_poins(String sign_poins) {
        this.sign_poins = sign_poins;
    }

    public String getSign_state() {
        return sign_state;
    }

    public void setSign_state(String sign_state) {
        this.sign_state = sign_state;
    }

    public int getSign_count() {
        return sign_count;
    }

    public void setSign_count(int sign_count) {
        this.sign_count = sign_count;
    }

    public Date getSign_time() {
        return sign_time;
    }

    public void setSign_time(Date sign_time) {
        this.sign_time = sign_time;
    }

    public String getArrays_time() {
        return arrays_time;
    }

    public void setArrays_time(String arrays_time) {
        this.arrays_time = arrays_time;
    }

    public String[] getWeek() {
        return week;
    }

    public void setWeek(String[] week) {
        this.week = week;
    }
}
