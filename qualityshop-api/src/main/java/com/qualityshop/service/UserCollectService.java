package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserCollectEntity;

import java.util.List;

/**
 * 收藏接口
 *
 * @author huojg
 */
public interface UserCollectService extends IService<UserCollectEntity> {
    List<UserCollectEntity> queryByCollect(String userId);
    List<UserCollectEntity> queryByCollectAll();
    List<UserCollectEntity> queryByCollectCount(int offset,int end);
    List<UserCollectEntity> queryByCollectCountId(String userId,int offset,int end);
    void    insertByCollect(UserCollectEntity userCollectEntity);
}
