package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserDetailPointEntity;

/**
 * 积分明细表
 *
 * @author huojg
 */
public interface UserDetailPointService  extends IService<UserDetailPointEntity>{
    public UserDetailPointEntity detailPointGet(String  userId);
    public void detailPointInsert(UserDetailPointEntity userDetailPointEntity);
    public void detailPointUpdate(UserDetailPointEntity userDetailPointEntity);
    public void detailPointDelete(String userId);

}
