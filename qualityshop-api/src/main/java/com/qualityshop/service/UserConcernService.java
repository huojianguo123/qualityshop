package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserConcernEntity;

import java.util.List;

/**
 * 关注接口
 *
 * @author gaoj
 */
public interface UserConcernService extends IService<UserConcernEntity> {

    List<UserConcernEntity> queryByConcern(String userId);
    List<UserConcernEntity> queryByConcernAll();
    List<UserConcernEntity> queryByConcernCount(int offset,int end);
    List<UserConcernEntity> queryByConcernCountId(String userId,int offset,int end);
    void    insertByConcern(UserConcernEntity userConcernEntity);
    void concerDelete(String concernId);

}
