package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 关注表单
 *
 * @author huojg
 */
@ApiModel(value = "关注表单")
public class UserConcernForm {
    @ApiModelProperty(value = "关注用户ID")
    @NotBlank(message="关注用户ID不能为空")
    private String userId;

    @ApiModelProperty(value = "被关注用户ID")
    @NotBlank(message="被关注用户ID不能为空")
    private String attentionUserId;


    /**
     * 是否关注
     */
    @ApiModelProperty(value = "是否关注")
    private int isConcern;

    /**
     * 关注数量
     */
    @ApiModelProperty(value = "关注数量")
    private int concernCount;

    /**
     *
     *
     * 关注时间
     */
    @ApiModelProperty(value = "关注日期")
    private Date create_time;
    /**
     *
     *
     * 关注者的头像
     */
    @ApiModelProperty(value = "关注者的头像")
    private String from_thumb_img;

    /**
     *
     * 关注者昵称
     */
    @ApiModelProperty(value = "关注者昵称")
    private String from_nickname;

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
