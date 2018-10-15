package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 短信表单
 *
 * @author changjian
 */
@ApiModel(value = "短信表单")
public class SmsMessageForm {

    @ApiModelProperty(value = "短信ID")
    @NotBlank(message="短信ID不能为空")
    private String id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 短信通知码
     */
    private String code;

    /**
     * 短信通知创建时间
     */
    private Date create_time;

    /**
     * 超时时间
     */
    private Date expire_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }
}
