package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserDetailPointDao;
import com.qualityshop.entity.UserDetailPointEntity;
import com.qualityshop.service.UserDetailPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 积分明细表
 *
 * @author huojg
 */
@Service("userDetailPointService")
public class UserDetailPointServiceImpl extends ServiceImpl<UserDetailPointDao,UserDetailPointEntity> implements UserDetailPointService{

    @Resource
    private  UserDetailPointDao  userDetailPointDao;

    @Override
    public UserDetailPointEntity detailPointGet(String userId) {
        UserDetailPointEntity userDetailPointEntity= userDetailPointDao.detailPointGet(userId);
        return userDetailPointEntity;
    }

    @Override
    public void detailPointInsert(UserDetailPointEntity userDetailPointEntity) {
      userDetailPointDao.detailPointInsert(userDetailPointEntity);
    }

    @Override
    public void detailPointUpdate(UserDetailPointEntity userDetailPointEntity) {
        userDetailPointDao.detailPointUpdate(userDetailPointEntity);
    }

    @Override
    public void detailPointDelete(String userId) {
        userDetailPointDao.detailPointDelete(userId);
    }
}
