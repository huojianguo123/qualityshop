package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserShopmemberEntity;

/**
 * 用户信息
 *
 * @author huojg
 */
public interface UserShopmemberService extends IService<UserShopmemberEntity> {
    UserShopmemberEntity queryByShopmember(String userId);
    UserShopmemberEntity queryOpenByShopmember(String openId);
    void   insertByShopmember(UserShopmemberEntity userShopmemberEntity);
    void shopmemberUpdate(UserShopmemberEntity userShopmemberEntity);
    UserShopmemberEntity queryByShopmemberPhone(String userPhone);
    void  shopmemberdelete(String userId);
}
