package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserShopmemberEntity;

/**
 * 用户信息
 *
 * @author huojg
 */
public interface UserShopmemberDao  extends BaseMapper<UserShopmemberEntity> {
   UserShopmemberEntity queryByShopmember(String userId);
    UserShopmemberEntity queryOpenByShopmember(String openId);
    UserShopmemberEntity queryByShopmemberPhone(String userPhone);
    void   insertByShopmember(UserShopmemberEntity userShopmemberEntity);
    void shopmemberUpdate(UserShopmemberEntity userShopmemberEntity);
    void  shopmemberdelete(String userId);
}
