package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserDetailPointEntity;

/**
 * 积分详情表
 *
 * @author huojg
 */
public interface UserDetailPointDao extends BaseMapper<UserDetailPointEntity> {
    public UserDetailPointEntity detailPointGet(String  userId);
    public void detailPointInsert(UserDetailPointEntity userDetailPointEntity);
    public void detailPointUpdate(UserDetailPointEntity userDetailPointEntity);
    public void detailPointDelete(String userId);

}
