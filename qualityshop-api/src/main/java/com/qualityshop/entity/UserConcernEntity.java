package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注表
 *
 * @author huojg
 */
@TableName("user_concern")
public class UserConcernEntity implements Serializable {
    /**
     * 关注ID
     */
    @TableId
    private String concernId;
    /**
     * 关注用户ID
     */
    private String userId;

    /**
     * 被关注用户ID
     */
    private String attentionUserId;


    /**
     * 是否关注
     */
    private int isConcern;

    /**
     * 是否数量
     */
    private int concernCount;

    /**
     *
     *
     * 关注时间
     */
    private Date create_time;
    /**
     *
     *
     * 关注者的头像
     */
    private String from_thumb_img;

    /**
     *
     * 关注者昵称
     */
private String from_nickname;

    public String getConcernId() {
        return concernId;
    }

    public void setConcernId(String concernId) {
        this.concernId = concernId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(String attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public int getIsConcern() {
        return isConcern;
    }

    public void setIsConcern(int isConcern) {
        this.isConcern = isConcern;
    }

    public int getConcernCount() {
        return concernCount;
    }

    public void setConcernCount(int concernCount) {
        this.concernCount = concernCount;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
            this.create_time = create_time;
    }

    public String getFrom_thumb_img() {
        return from_thumb_img;
    }

    public void setFrom_thumb_img(String from_thumb_img) {
        this.from_thumb_img = from_thumb_img;
    }

    public String getFrom_nickname() {
        return from_nickname;
    }

    public void setFrom_nickname(String from_nickname) {
        this.from_nickname = from_nickname;
    }
}
