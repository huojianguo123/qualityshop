package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserShareEntity;

import java.util.List;

/**
 * 分享
 *
 * @author huojg
 */
public interface UserShareService extends IService<UserShareEntity> {
    List<UserShareEntity> queryByShare(String userId);
    List<UserShareEntity> queryByShareAll();
    List<UserShareEntity> queryByShareCount(int offset,int end);
    List<UserShareEntity> queryByShareCountId(String userId,int offset,int end);
    void    insertByShare(UserShareEntity userConcernEntity);
}
