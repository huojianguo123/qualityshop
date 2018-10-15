package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论
 *
 * @author huojg
 */
@TableName("user_comment")
public class UserCommentEntity implements Serializable{
    /**
     * 评论Id
     */
    @TableId
    private String  id;
    /**
     * 文章ID
     */
    private String artic_id;
    /**
     * 评论类型 1为回复评论，2为回复别人的回复
     *
     */
    /**
     * 用户Id
     *
     */
    private String user_id;
    private String reply_type;

    /**
     * 回复Id
     */

    private String reply_id;

    /**
     * 评论id
     */
    private String comment_id;

    /**
     * 内容
     */
    private String content;

    /**
     * 回复目的Id
     */
   private String to_uid;

    /**
     * 回复用户Id
     */
    private String from_uid;
    /**
     * 回复者的头像
     */
    private String from_thumb_img;
    /**
     * 回复者的昵称
     */
    private String from_nickname;
    /**
     * 评论时间
     */
    private Date create_time;
    /**
     * 0为普通回复，1为后台管理员回复
     */
    private  String is_author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtic_id() {
        return artic_id;
    }

    public void setArtic_id(String artic_id) {
        this.artic_id = artic_id;
    }

    public String getReply_type() {
        return reply_type;
    }

    public void setReply_type(String reply_type) {
        this.reply_type = reply_type;
    }

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(String to_uid) {
        this.to_uid = to_uid;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIs_author() {
        return is_author;
    }

    public void setIs_author(String is_author) {
        this.is_author = is_author;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
