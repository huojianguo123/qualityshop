package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserFeedBackEntity;

import java.util.List;

/**
 *反馈表
 *
 * @author huojg
 */
public interface UserFeedBackDao extends BaseMapper<UserFeedBackEntity> {

    public List<UserFeedBackEntity> feedBackGet(String  userId);
    public void feedBackInsert(UserFeedBackEntity userFeedBackEntity);
}
