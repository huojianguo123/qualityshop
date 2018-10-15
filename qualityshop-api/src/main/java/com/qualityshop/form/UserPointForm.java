package com.qualityshop.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 积分总金额
 *
 * @author huojg
 */
@ApiModel(value = "积分表单")
public class UserPointForm {

    @ApiModelProperty(value = "积分总额表ID")
    @NotBlank(message="积分ID不能为空")
    private  String id;

    /**
     * 用户Id
     */
    @ApiModelProperty(value ="用户Id")
    private String userId;

    /**
     * 积分编码
     */
    @ApiModelProperty(value ="积分编码")
    private String code;

    /**
     *
     * 积分值
     */
    private String points;

    /**
     * 优先级
     */
    private  String prority;

    /**
     *开始时间
     */
    private Date beginTime;

    /**
     *结束时间
     */
    private  Date endTime;
    /**
     *状态
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPrority() {
        return prority;
    }

    public void setPrority(String prority) {
        this.prority = prority;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
