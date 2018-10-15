package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserPointDao;
import com.qualityshop.entity.UserPointEntity;
import com.qualityshop.service.UserPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 积分总额表
 *
 * @author huojg
 */
@Service("userPointService")
public class UserPointServiceImpl  extends ServiceImpl<UserPointDao,UserPointEntity> implements UserPointService{
    @Resource
    private UserPointDao userPointDao;

    @Override
    public UserPointEntity pointGet(String userId) {
        UserPointEntity userPointEntity= userPointDao.pointGet(userId);
        return userPointEntity;
    }

    @Override
    public void pointInsert(UserPointEntity userPointEntity) {
        userPointDao.pointInsert(userPointEntity);
    }

    @Override
    public void pointUpdate(UserPointEntity userPointEntity) {
        userPointDao.pointUpdate(userPointEntity);
    }

    @Override
    public void pointDelete(String userId) {
        userPointDao.pointDelete(userId);
    }
}
