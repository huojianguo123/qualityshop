package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserSignEntity;

import java.util.List;

/**
 * 签到接口
 *
 * @author huojg
 */
public interface UserSignDao extends BaseMapper<UserSignEntity> {

    List<UserSignEntity> queryBySign(String userId);
    void   insertBySign(UserSignEntity userSignEntity);
    void signUpdate(UserSignEntity userSignEntity);
    void  signdelete(String userId);
    //查询当天用户是否签到
    int querySignDate(String userId,String datetime);
    //查询第一天签到的日期
    UserSignEntity firstSignDate(String userId);
}
