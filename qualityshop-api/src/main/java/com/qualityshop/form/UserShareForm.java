package com.qualityshop.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 分享表单
 *
 * @author huojg
 */
@ApiModel(value = "分享表单")
public class UserShareForm {
    @ApiModelProperty(value = "分享ID")
    @NotBlank(message="分享ID不能为空")
    private String id;
    @ApiModelProperty(value = "用户ID")
    @NotBlank(message="用户ID不能为空")
    private String user_id;
    /**
     * 分享内容
     */
    private String share_message;

    /**
     * 分享名称
     */
    private String share_name;

    /**
     * 分享类型
     */
    private String share_type;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;

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

    public String getShare_message() {
        return share_message;
    }

    public void setShare_message(String share_message) {
        this.share_message = share_message;
    }

    public String getShare_name() {
        return share_name;
    }

    public void setShare_name(String share_name) {
        this.share_name = share_name;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
