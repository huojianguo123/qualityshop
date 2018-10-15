package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 评论表单
 *
 * @author huojg
 */
@ApiModel(value = "评论表单")
public class UserCommentForm {

    @ApiModelProperty(value = "评论ID")
    @NotBlank(message="评论ID不能为空")
    private String  id;
    private String artic_id;
    /**
     * 评论类型 1为回复评论，2为回复别人的回复
     *
     */
    private String reply_type;

    /**
     * 回复Id
     */

    private String reply_id;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户ID")
    @NotBlank(message="用户ID不能为空")
    private String user_id;

    /**
     * 评论id
     */
    @ApiModelProperty(value = "评论ID")
    @NotBlank(message="评论不能为空")
    private String comment_id;

    /**
     * 内容
     */
    private String content;

    /**
     * 回复目的Id
     */
    @ApiModelProperty(value = "回复目的ID")
    @NotBlank(message="回复目的不能为空")
    private String to_uid;

    /**
     * 回复用户Id
     */
    @ApiModelProperty(value = "回复用户ID")
    @NotBlank(message="回复用户不能为空")
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
