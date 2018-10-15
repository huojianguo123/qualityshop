package com.qualityshop.service;

import com.qualityshop.entity.UserFeedBackEntity;

import java.util.List;

/**
 * 反馈
 *
 * @author huojg
 */
public interface UserFeedBackService {

    public List<UserFeedBackEntity> feedBackGet(String  userId);
    public void feedBackInsert(UserFeedBackEntity userFeedBackEntity);
}
