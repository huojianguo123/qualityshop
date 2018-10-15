package com.qualityshop.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserSnapEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 点赞接口
 *
 * @author huojg
 */
public interface UserSnapDao extends BaseMapper<UserSnapEntity> {
    List<UserSnapEntity> queryBySnap(String userId);
    List<UserSnapEntity> queryBySnapAll();
    List<UserSnapEntity> queryBySnapCount(int offset,int end);
    List<UserSnapEntity> queryBySnapCountId(@Param("userId")String  userId, @Param("offset")int offset, @Param("end")int end);
    void    insertBySnap(UserSnapEntity userConcernEntity);
}
