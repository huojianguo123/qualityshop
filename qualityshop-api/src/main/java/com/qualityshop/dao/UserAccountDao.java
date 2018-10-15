package com.qualityshop.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qualityshop.entity.UserAccountEntity;

/**
 * 用户佣金表
 *
 * @author huojg
 */
public interface UserAccountDao extends BaseMapper<UserAccountEntity>{
    public UserAccountEntity accountGet(String  userId);
    public void accountInsert(UserAccountEntity userAccountEntity);
    public void accountUpdate(UserAccountEntity userAccountEntity);
    public void accountDelete(String userId);
}
