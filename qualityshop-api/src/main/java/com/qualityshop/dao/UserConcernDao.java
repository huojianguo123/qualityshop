package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserConcernEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关注
 *
 * @author huojg
 */
public interface UserConcernDao extends BaseMapper<UserConcernEntity> {
    List<UserConcernEntity> queryByConcern(String userId);
    List<UserConcernEntity> queryByConcernAll();
    List<UserConcernEntity> queryByConcernCount(int offset,int end);
    List<UserConcernEntity> queryByConcernCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
    void    insertByConcern(UserConcernEntity userConcernEntity);
     void concerDelete(String concernId);
}
