package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分明细表
 *
 * @author huojg
 */
@TableName("user_detail_point")
public class UserDetailPointEntity implements Serializable {
    /**
     *积分默认ID
     */
    @TableId
    private String id;

    /**
     * 会员用户Id
     */
    private String userId;

    /**
     * 积分值
     */
    private String points;

    /**
     * 积分值开始时间
     */
    private Date startTime;
    /**
     * 积分过期时间
     */
    private  Date  expireTime;

    /**
     * 备注
     */
    private String remark;

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

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
