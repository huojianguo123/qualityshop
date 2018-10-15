package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserCollectDao;
import com.qualityshop.entity.UserCollectEntity;
import com.qualityshop.service.UserCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏
 *
 * @author huojg
 */
@Service("userCollectService")
public class UserCollectServiceImpl extends ServiceImpl<UserCollectDao,UserCollectEntity> implements UserCollectService{
    @Resource
    private UserCollectDao userCollectDao;

    @Override
    public List<UserCollectEntity> queryByCollect(String userId) {
        List<UserCollectEntity> list=userCollectDao.queryByCollect(userId);
        return list;
    }

    @Override
    public List<UserCollectEntity> queryByCollectAll() {
        List<UserCollectEntity> list=userCollectDao.queryByCollectAll();
        return list;
    }

    @Override
    public List<UserCollectEntity> queryByCollectCount(int offset, int end) {
        List<UserCollectEntity> list=userCollectDao.queryByCollectCount( offset,end);
        return list;
    }

    @Override
    public List<UserCollectEntity> queryByCollectCountId(String userId, int offset, int end) {
        List<UserCollectEntity> list=userCollectDao.queryByCollectCountId( userId,offset,end);
        return list;
    }

    @Override
    public void insertByCollect(UserCollectEntity userCollectEntity) {
        userCollectDao.insertByCollect(userCollectEntity);
    }
}
