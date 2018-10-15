package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserSnapDao;
import com.qualityshop.entity.UserSnapEntity;
import com.qualityshop.service.UserSnapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author gaoj
 */
@Service("userSnapService")
public class UserSnapServiceImpl extends ServiceImpl<UserSnapDao,UserSnapEntity> implements UserSnapService {
    @Resource
    private UserSnapDao userSnapDao;

    @Override
    public List<UserSnapEntity> queryBySnap(String userId) {
        List<UserSnapEntity> list=userSnapDao.queryBySnap(userId);
        return list;
    }

    @Override
    public List<UserSnapEntity> queryBySnapAll() {
        List<UserSnapEntity> list=userSnapDao.queryBySnapAll();
        return list;
    }

    @Override
    public List<UserSnapEntity> queryBySnapCount(int offset, int end) {
        List<UserSnapEntity> list=userSnapDao.queryBySnapCount(offset,end);
        return list;
    }

    @Override
    public List<UserSnapEntity> queryBySnapCountId(String userId, int offset, int end) {
        List<UserSnapEntity> list=userSnapDao.queryBySnapCountId(userId,offset,end);
        return list;
    }

    @Override
    public void insertBySnap(UserSnapEntity userConcernEntity) {
        userSnapDao.insertBySnap(userConcernEntity);
    }
}
