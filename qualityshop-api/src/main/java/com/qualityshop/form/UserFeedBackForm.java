package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 反馈
 *
 * @author gaoj
 */
@ApiModel(value = "反馈表单")
public class UserFeedBackForm {

    @ApiModelProperty(value = "反馈ID")
    private  String id;
    @ApiModelProperty(value = "反馈用户ID")
    private String userId;

    private String content;

    private Date create_time;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
