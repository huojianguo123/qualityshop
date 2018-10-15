package com.qualityshop.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 手机用户信息表
 *
 * @author gaoj
 */
@ApiModel(value = "手机用户表单")
public class UserShopmemberForm {

    @ApiModelProperty(value = "手机用户ID")
    private String userId;
    /**
     * 用户昵称
     */
    private String userNickName;
    /**
     * 用户昵称头像
     */
    private String userNickImg;

    /**
     * 用户真实姓名
     */
    private String userAcutalName;

    /**
     * 用户会员等级
     */
    private String userMemberGrade;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     *用户生日
     */
    private String  userBirthday;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty(value = "微信openID")
    private String openId;
    private String alipayName;
    private String alipayAccount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickImg() {
        return userNickImg;
    }

    public void setUserNickImg(String userNickImg) {
        this.userNickImg = userNickImg;
    }

    public String getUserAcutalName() {
        return userAcutalName;
    }

    public void setUserAcutalName(String userAcutalName) {
        this.userAcutalName = userAcutalName;
    }

    public String getUserMemberGrade() {
        return userMemberGrade;
    }

    public void setUserMemberGrade(String userMemberGrade) {
        this.userMemberGrade = userMemberGrade;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }
}
