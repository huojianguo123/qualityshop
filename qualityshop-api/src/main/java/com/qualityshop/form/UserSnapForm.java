package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 点赞表单
 *
 * @author huojg
 */
@ApiModel(value = "点赞表单")
public class UserSnapForm {
    @ApiModelProperty(value = "点赞ID")
    @NotBlank(message="点赞ID不能为空")
    private String id;

    @ApiModelProperty(value = "点赞用户ID")
    @NotBlank(message="点赞用户ID不能为空")
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
