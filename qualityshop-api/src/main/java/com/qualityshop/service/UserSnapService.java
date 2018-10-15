package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserSnapEntity;

import java.util.List;

/**
 * 点赞接口
 *
 * @author huojg
 */
public interface UserSnapService  extends IService<UserSnapEntity> {

    List<UserSnapEntity> queryBySnap(String userId);
    List<UserSnapEntity> queryBySnapAll();
    List<UserSnapEntity> queryBySnapCount(int offset,int end);
    List<UserSnapEntity> queryBySnapCountId(String  userId,int offset,int end);
    void    insertBySnap(UserSnapEntity userConcernEntity);
}
