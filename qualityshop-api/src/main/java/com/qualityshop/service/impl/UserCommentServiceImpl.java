package com.qualityshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qualityshop.dao.UserCommentDao;
import com.qualityshop.entity.UserCommentEntity;
import com.qualityshop.service.UserCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论接口实现
 *
 * @author huojg
 */
@Service("userCommentService")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentDao,UserCommentEntity> implements UserCommentService {

    @Resource
    private UserCommentDao userCommentDao;

    @Override
    public List<UserCommentEntity> queryByComment(String userId) {
        List<UserCommentEntity> list=userCommentDao.queryByComment(userId);
        return list;
    }

    @Override
    public List<UserCommentEntity> queryByCommentAll() {
        List<UserCommentEntity> list=userCommentDao.queryByCommentAll();
        return list;
    }

    @Override
    public List<UserCommentEntity> queryByCommentCount(int offset, int end) {
        List<UserCommentEntity> list=userCommentDao.queryByCommentCount(offset, end);
        return list;
    }

    @Override
    public List<UserCommentEntity> queryByCommentCountId(String userId, int offset, int end) {
        List<UserCommentEntity> list=userCommentDao.queryByCommentCountId(userId,offset, end);
        return list;
    }

    @Override
    public void insertByComment(UserCommentEntity userCommentEntity) {
        userCommentDao.insertByComment(userCommentEntity);
    }
}
