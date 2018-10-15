package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserFeedBackDao;
import com.qualityshop.entity.UserFeedBackEntity;
import com.qualityshop.service.UserFeedBackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 反馈表
 *
 * @author huojg
 */
@Service("userFeedBackService")
public class UserFeedBackServiceImpl  extends ServiceImpl<UserFeedBackDao,UserFeedBackEntity> implements UserFeedBackService {
    @Resource
    private UserFeedBackDao userFeedBackDao;

    @Override
    public List<UserFeedBackEntity> feedBackGet(String userId) {

        return userFeedBackDao.feedBackGet(userId);
    }

    @Override
    public void feedBackInsert(UserFeedBackEntity userFeedBackEntity) {
        userFeedBackDao.feedBackInsert(userFeedBackEntity);
    }
}
