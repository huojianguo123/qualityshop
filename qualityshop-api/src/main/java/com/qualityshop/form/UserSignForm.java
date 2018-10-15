package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 签到接口
 *
 * @author huojg
 */
@ApiModel(value = "签到表单")
public class UserSignForm {
    /**
     * 签到ID
     */
    @ApiModelProperty(value = "签到ID")
    private String sign_id;
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 签到积分
     */
    private String points;

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
    private String sign_time;

    /**
     *
     * 时间转换日期
     */
    private String arrays_time;
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

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
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

    public String getArrays_time() {
        return arrays_time;
    }

    public void setArrays_time(String arrays_time) {
        this.arrays_time = arrays_time;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }
}
