package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserCommentEntity;

import java.util.List;

/**
 * 评论
 *
 * @author huojg
 */
public interface UserCommentService extends IService<UserCommentEntity> {

    List<UserCommentEntity> queryByComment(String userId);
    List<UserCommentEntity> queryByCommentAll();
    List<UserCommentEntity> queryByCommentCount(int offset,int end);
    List<UserCommentEntity> queryByCommentCountId(String userId,int offset,int end);
    void   insertByComment(UserCommentEntity userCommentEntity);
}
