package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserPointEntity;

/**
 *积分总额表
 * @author huojg
 */
public interface UserPointService  extends IService<UserPointEntity>{
    public UserPointEntity pointGet(String  userId);
    public void pointInsert(UserPointEntity userPointEntity);
    public void pointUpdate(UserPointEntity userPointEntity);
    public void pointDelete(String userId);
}
