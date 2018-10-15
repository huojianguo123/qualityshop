package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserCollectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏
 *
 * @author huojg
 */
public interface UserCollectDao extends BaseMapper<UserCollectEntity> {
    List<UserCollectEntity> queryByCollect(String userId);
    List<UserCollectEntity> queryByCollectAll();
    List<UserCollectEntity> queryByCollectCount(int offset,int end);
    List<UserCollectEntity> queryByCollectCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
    void    insertByCollect(UserCollectEntity userCollectEntity);
}
