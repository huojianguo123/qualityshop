package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 点赞表
 *
 * @author huojg
 */
@TableName("user_sanp")
public class UserSnapEntity implements Serializable {
    /**
     * 点赞ID
     */
    @TableId
    private String id;

    /**
     * 用户ID
     */
    private String user_id;

    /**
     * 文章ID
     */
    private String therm_id;

    /**
     * 开始时间
     */
    private Date vote_time;

    /**
     * 状态 状态  0点赞1，取消
     */
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTherm_id() {
        return therm_id;
    }

    public void setTherm_id(String therm_id) {
        this.therm_id = therm_id;
    }

    public Date getVote_time() {
        return vote_time;
    }

    public void setVote_time(Date vote_time) {
        this.vote_time = vote_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
