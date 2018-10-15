package com.qualityshop.service;

import com.baomidou.mybatisplus.service.IService;
import com.qualityshop.entity.UserSignEntity;

import java.util.List;

/**
 * 签到接口
 *
 * @author huojg
 */
public interface UserSignService extends IService<UserSignEntity> {
    List<UserSignEntity> queryBySign(String userId);
    void   insertBySign(UserSignEntity userSignEntity);
    void signUpdate(UserSignEntity userSignEntity);
    void signdelete(String userId);
    //查询当天用户是否签到
    int querySignDate(String userId,String datetime);
    UserSignEntity firstSignDate(String userId);
}
