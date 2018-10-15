package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserPointEntity;

/**
 * 积分总额表
 *
 * @author huojg
 */
public interface UserPointDao extends BaseMapper<UserPointEntity>{
    public UserPointEntity pointGet(String  userId);
    public void pointInsert(UserPointEntity userPointEntity);
    public void pointUpdate(UserPointEntity userPointEntity);
    public void pointDelete(String userId);


}
