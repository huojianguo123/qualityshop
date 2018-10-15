package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserShopmemberDao;
import com.qualityshop.entity.UserShopmemberEntity;
import com.qualityshop.service.UserShopmemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息
 *
 * @author huojg
 */
@Service("UserShopmemberService")
public class UserShopmemberServiceImpl extends ServiceImpl<UserShopmemberDao,UserShopmemberEntity> implements UserShopmemberService {
    @Resource
    private UserShopmemberDao UserShopmemberDao;

   @Override
    public UserShopmemberEntity queryByShopmember(String userId) {
       UserShopmemberEntity userShopmemberEntity=UserShopmemberDao.queryByShopmember(userId);
        return userShopmemberEntity;
    }

    @Override
    public UserShopmemberEntity queryOpenByShopmember(String openId) {
        UserShopmemberEntity userShopmemberEntity=UserShopmemberDao.queryOpenByShopmember(openId);
        return userShopmemberEntity;
    }

    @Override
    public void insertByShopmember(UserShopmemberEntity userShopmemberEntity) {
       UserShopmemberDao.insertByShopmember(userShopmemberEntity);
    }

    @Override
    public void shopmemberUpdate(UserShopmemberEntity userShopmemberEntity) {
        UserShopmemberDao.shopmemberUpdate(userShopmemberEntity);
    }

    @Override
    public UserShopmemberEntity queryByShopmemberPhone(String userPhone) {
        UserShopmemberEntity userShopmemberEntity=UserShopmemberDao.queryByShopmemberPhone(userPhone);
        return userShopmemberEntity;
    }

    @Override
    public void shopmemberdelete(String userId) {
        UserShopmemberDao.shopmemberdelete(userId);
    }
}
