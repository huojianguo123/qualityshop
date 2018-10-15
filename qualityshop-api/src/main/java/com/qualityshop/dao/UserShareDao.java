package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserShareEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分享
 *
 * @author huojg
 */
public interface UserShareDao extends BaseMapper<UserShareEntity>{

    List<UserShareEntity> queryByShare(String userId);
    List<UserShareEntity> queryByShareAll();
    List<UserShareEntity> queryByShareCount(int offset,int end);
    List<UserShareEntity> queryByShareCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
    void    insertByShare(UserShareEntity userConcernEntity);
}
