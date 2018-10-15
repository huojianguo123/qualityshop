package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserSignDao;
import com.qualityshop.entity.UserSignEntity;
import com.qualityshop.service.UserSignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 签到
 *
 * @author huojg
 */
@Service("userSignService")
public class UserSignServiceImpl extends ServiceImpl<UserSignDao,UserSignEntity> implements UserSignService {

    @Resource
    private UserSignDao UserSignDao;
    @Override
    public List<UserSignEntity> queryBySign(String userId) {
        List<UserSignEntity>  userSignEnti=UserSignDao.queryBySign(userId);
        return userSignEnti;
    }

    @Override
    public void insertBySign(UserSignEntity userSignEntity) {
     UserSignDao.insertBySign(userSignEntity);
    }

    @Override
    public void signUpdate(UserSignEntity userSignEntity) {
        UserSignDao.signUpdate(userSignEntity);
    }

    @Override
    public void signdelete(String userId) {
        UserSignDao.signdelete(userId);

    }
    @Override
    public int querySignDate(String userId,String datetime) {
        int count=UserSignDao.querySignDate(userId,datetime);
        return count;
    }

    @Override
    public UserSignEntity firstSignDate(String userId) {
        return UserSignDao.firstSignDate(userId);
    }
}
