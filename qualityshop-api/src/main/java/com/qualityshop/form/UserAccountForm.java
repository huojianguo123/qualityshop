package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 佣金表
 *
 * @author huojg
 */
@ApiModel(value = "佣金表单")
public class UserAccountForm {
    @ApiModelProperty(value = "佣金ID")
    @NotBlank(message="佣金ID不能为空")
    private String id;

    /**
     *
     */
    @ApiModelProperty(value = "用户ID")
    @NotBlank(message="用户不能为空")
    private String userId;

    /**
     * 总佣金
     */
    private BigDecimal total_account;

    /**
     * 已使用佣金
     */
    private BigDecimal use_account;
    /**
     * 未使用佣金
     */
    private BigDecimal unuse_account;

    /**
     *
     * 创建时间
     */
    private Date create_time;

    /**
     *
     * 佣金状态 0，正常，1，冻结，2，解冻
     */
    private String state;

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

    public BigDecimal getTotal_account() {
        return total_account;
    }

    public void setTotal_account(BigDecimal total_account) {
        this.total_account = total_account;
    }

    public BigDecimal getUse_account() {
        return use_account;
    }

    public void setUse_account(BigDecimal use_account) {
        this.use_account = use_account;
    }

    public BigDecimal getUnuse_account() {
        return unuse_account;
    }

    public void setUnuse_account(BigDecimal unuse_account) {
        this.unuse_account = unuse_account;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
