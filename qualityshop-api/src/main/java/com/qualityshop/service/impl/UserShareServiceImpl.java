package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserShareDao;
import com.qualityshop.entity.UserShareEntity;
import com.qualityshop.service.UserShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author gaoj
 */
@Service("UserShareService")
public class UserShareServiceImpl extends ServiceImpl<UserShareDao,UserShareEntity> implements UserShareService {
    @Resource
    private UserShareDao userShareDao;

    @Override
    public List<UserShareEntity> queryByShare(String userId) {
        List<UserShareEntity> list=userShareDao.queryByShare(userId);
        return list;
    }

    @Override
    public List<UserShareEntity> queryByShareAll() {
        List<UserShareEntity> list=userShareDao.queryByShareAll();
        return list;
    }

    @Override
    public List<UserShareEntity> queryByShareCount(int offset, int end) {
        List<UserShareEntity> list=userShareDao.queryByShareCount(offset,end);
        return list;
    }

    @Override
    public List<UserShareEntity> queryByShareCountId(String userId, int offset, int end) {
        List<UserShareEntity> list=userShareDao.queryByShareCountId(userId,offset,end);
        return list;
    }

    @Override
    public void insertByShare(UserShareEntity userConcernEntity) {
        userShareDao.insertByShare(userConcernEntity);

    }
}
