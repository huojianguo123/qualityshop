package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserCommentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 *
 * @author huojg
 */
public interface UserCommentDao extends BaseMapper<UserCommentEntity> {
    List<UserCommentEntity> queryByComment(String userId);
    List<UserCommentEntity> queryByCommentAll();
    List<UserCommentEntity> queryByCommentCount(int offset,int end);
    List<UserCommentEntity> queryByCommentCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
    void    insertByComment(UserCommentEntity userCommentEntity);
}
