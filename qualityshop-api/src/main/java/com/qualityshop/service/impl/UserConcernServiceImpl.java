package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserConcernDao;
import com.qualityshop.entity.UserConcernEntity;
import com.qualityshop.service.UserConcernService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 关注接口实现
 *
 * @author huojg
 */
@Service("userConcernService")
public class UserConcernServiceImpl extends ServiceImpl<UserConcernDao, UserConcernEntity> implements UserConcernService{
    @Resource
    private UserConcernDao userConcernDao;

    @Override
    public List<UserConcernEntity> queryByConcern(String userId) {
        List<UserConcernEntity> userConcernEntity=userConcernDao.queryByConcern(userId);
        return userConcernEntity;
    }

    @Override
    public List<UserConcernEntity> queryByConcernAll() {
        List<UserConcernEntity> userConcernEntity=userConcernDao.queryByConcernAll();
        return userConcernEntity;
    }

    @Override
    public List<UserConcernEntity> queryByConcernCount(int offset, int end) {
        List<UserConcernEntity> userConcernEntity=userConcernDao.queryByConcernCount(offset,end);
        return userConcernEntity;
    }

    @Override
    public List<UserConcernEntity> queryByConcernCountId(String userId, int offset, int end) {
        List<UserConcernEntity> userConcernEntity=userConcernDao.queryByConcernCountId(userId,offset,end);
        return userConcernEntity;
    }

    @Override
    public void insertByConcern(UserConcernEntity userConcernEntity) {

        userConcernDao.insertByConcern(userConcernEntity);
    }

    @Override
    public void concerDelete(String concernId) {
        userConcernDao.concerDelete(concernId);
    }
}
